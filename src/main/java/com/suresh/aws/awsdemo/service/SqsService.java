package com.suresh.aws.awsdemo.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

@Service
public class SqsService {

    private final SqsClient sqsClient;

    public SqsService(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    public void pollMessages(String queryUrl) {
        ReceiveMessageRequest req = ReceiveMessageRequest.builder()
                .queueUrl(queryUrl)
                .build();

        sqsClient.receiveMessage(req).messages()
                .forEach(msg -> System.out.println(msg.body()));
    }
}
