package com.suresh.aws.awsdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AwsConfig {
    private static final Region region = Region.AP_SOUTH_1;

    @Bean
    public S3Client s3Client() {
        return S3Client.builder().region(region).build();
    }

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder().region(region).build();
    }

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder().region(region).build();
    }

}
