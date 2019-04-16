package com.greencom.empower.importer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
@EnableScheduling
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

        LOGGER.info("Start cron to check customer agreement files");
        try {
            List<Path> walk = Files.walk(Paths.get(sourceFolder)).filter(Files::isRegularFile).collect(Collectors.toList());
            for (Path path : walk) {
                try {
                    LOGGER.info("Found file {}", path.toString());
                    Path newPath = Paths.get(path.getParent().toString(), "to_process", path.getFileName().toString());
                    Files.move(path, newPath);

                    // TODO: call Spring batch with file as parameter
                    JobExecution execution = jobLauncher.run(providerImporterJob,
                            new JobParametersBuilder().addString("file",newPath.toString())
                                    .toJobParameters()
                    );

                } catch (IOException e) {
                    LOGGER.error("Failed to move file {}", path);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }
            }
        } catch (IOException e) {
            LOGGER.error("Failed to list files in {}", sourceFolder);

        } finally {
            LOGGER.info("End of cron to check customer agreement files");
        }
    }
}
