package com.greencom.empower.importer.batch.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

public class RetryLoggerListener extends RetryListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetryLoggerListener.class);

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        LOGGER.error("Step: an exception was raised during items processing, retrying...");
        super.onError(context, callback, throwable);
    }
}
