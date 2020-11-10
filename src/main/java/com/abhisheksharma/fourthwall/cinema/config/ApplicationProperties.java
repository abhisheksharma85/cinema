package com.abhisheksharma.fourthwall.cinema.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to this application.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
}
