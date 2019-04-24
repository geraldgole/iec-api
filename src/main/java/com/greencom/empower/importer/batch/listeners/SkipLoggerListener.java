package com.greencom.empower.importer.batch.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

public class SkipLoggerListener implements SkipListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkipLoggerListener.class);

    @Override
    public void onSkipInRead(Throwable throwable) {

    }

    @Override
    public void onSkipInWrite(Object o, Throwable throwable) {
        LOGGER.error("Step: Skipping item {}", o);
    }

    @Override
    public void onSkipInProcess(Object o, Throwable throwable) {

    }
}
