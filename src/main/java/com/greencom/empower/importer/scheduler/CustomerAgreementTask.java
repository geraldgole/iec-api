package com.greencom.empower.importer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerAgreementTask {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerAgreementTask.class);

    @Value("${application.task.customeragreement.source}")
    private String sourceFolder;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job providerImporterJob;

    @Scheduled(cron = "${application.task.customeragreement.cron}")
    public void checkFiles() {

        LOGGER.info("Cron: Start processing customer agreement files");
        try {
            List<Path> fileList = Files
                    .list(Paths.get(sourceFolder))
                    .filter(Files::isRegularFile)
                    .filter(f -> f.toString().endsWith(".xml"))
                    .collect(Collectors.toList());

            if ( fileList.isEmpty() ) {
                LOGGER.info("Cron: no customer agreement files found");
            }

            for (Path path : fileList) {
                try {
                    LOGGER.info("Cron: found file {}", path.toString());
                    Path toProcessDirectoryPath = Paths.get(path.getParent().toString(), "to_process");
                    Path newPath = Paths.get(toProcessDirectoryPath.toString(), path.getFileName().toString());
                    if (!Files.exists(toProcessDirectoryPath)) {
                        Files.createDirectory(toProcessDirectoryPath);
                    }

                    Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
                    LOGGER.info("Cron: moved file {} to {}", path,newPath);

                    launchJob(newPath.toString());

                } catch (IOException e) {
                    LOGGER.error("Cron: failed to move file {}", path);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }
            }
        } catch (IOException e) {
            LOGGER.error("Cron: failed to list files in {}", sourceFolder);

        } finally {
            LOGGER.info("Cron: end of cron to check customer agreement files");
        }
    }

    private void launchJob(String filePath) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        LOGGER.info("Cron: launch {} batch job", providerImporterJob.getName());
        // The execution time is used to distinguish each instance of job execution
        Instant executionTime = Instant.now();
        jobLauncher.run(
                providerImporterJob,
                new JobParametersBuilder()
                        .addString("file", filePath)
                        .addString("execution_time", executionTime.toString(), true)
                        .toJobParameters()
        );
    }
}
