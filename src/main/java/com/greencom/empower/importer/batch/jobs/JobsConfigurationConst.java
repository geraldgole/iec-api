package com.greencom.empower.importer.batch.jobs;

public final class JobsConfigurationConst {

    static final String[] PROVIDER_IMPORTER_REQUIRED_JOB_PARAMETERS = {"file", "execution_time"};
    static final String[] PROVIDER_IMPORTER_OPTIONAL_JOB_PARAMETERS = {};
    static final long PROVIDER_IMPORTER_INITIAL_BACK_OFF_INTERVAL = 10000;
    static final long PROVIDER_IMPORTER_MAX_BACK_OFF_INTERVAL = 50000;
    static final int PROVIDER_IMPORTER_RETRY_LIMIT = 3;
    // TODO : Define a skip limit for a batch's chunck or override the default SkipPolicy for unrestrained skipping.
    static final int PROVIDER_IMPORTER_SKIP_LIMIT = 100;

    static final String[] READINGS_IMPORTER_REQUIRED_JOB_PARAMETERS = {"file", "execution_time"};
    static final String[] READINGS_IMPORTER_OPTIONAL_JOB_PARAMETERS = {};
    static final long READINGS_IMPORTER_INITIAL_BACK_OFF_INTERVAL = 10000;
    static final long READINGS_IMPORTER_MAX_BACK_OFF_INTERVAL = 50000;
    static final int READINGS_IMPORTER_RETRY_LIMIT = 3;
    // TODO : Define a skip limit for a batch's chunck or override the default SkipPolicy for unrestrained skipping.
    static final int READINGS_IMPORTER_SKIP_LIMIT = 100;

    private JobsConfigurationConst() {}
}
