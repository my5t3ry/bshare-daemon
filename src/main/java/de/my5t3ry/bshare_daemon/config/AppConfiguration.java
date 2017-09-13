package de.my5t3ry.bshare_daemon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * created by: sascha.bast
 * since: 27.08.17
 */
@Configuration

@PropertySource(value = "classpath:application.properties")
public class AppConfiguration {}