package com.suresh.aws.awsdemo.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class SnsService {

    private final SnsClient snsClient;

    public SnsService(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    public String publishToTopic(String topicArn, String message) {
        PublishRequest req = PublishRequest.builder()
                .topicArn(topicArn)
                .message(message)
                .build();
        return snsClient.publish(req).messageId();
    }
}
