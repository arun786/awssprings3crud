package com.arun.springs3read.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "aws.s3")
@Getter
@Setter
public class AWSConfig {
    private String accessKey;
    private String secretKey;
}
