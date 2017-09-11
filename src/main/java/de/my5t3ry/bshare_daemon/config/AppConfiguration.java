package de.my5t3ry.bshare_daemon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * created by: sascha.bast
 * since: 27.08.17
 */
@Configuration
@ComponentScan("de.my5t3ry")
@PropertySource(value = "classpath:application.properties")
public class AppConfiguration {}