package com.suresh.aws.awsdemo.controller;

import com.suresh.aws.awsdemo.service.S3Service;
import com.suresh.aws.awsdemo.service.SnsService;
import com.suresh.aws.awsdemo.service.SqsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsController {

    private final S3Service s3Service;
    private final SnsService snsService;
    private final SqsService sqsService;

    public AwsController(S3Service s3Service,
                         SnsService snsService,
                         SqsService sqsService) {
        this.s3Service = s3Service;
        this.snsService = snsService;
        this.sqsService = sqsService;
    }

    @GetMapping("/upload")
    public String upload(@RequestParam String key, @RequestParam String content) {
        s3Service.uploadText("springboot-demo-bucket-suresh", key, content);
        return "Uploaded “" + key + "”";
    }

    @GetMapping("/publish")
    public String publish(@RequestParam String topicArn,
                          @RequestParam String msg) {
        String msgId = snsService.publishToTopic(topicArn, msg);
        return "Published — msgId=" + msgId;
    }

    @GetMapping("/poll")
    public String poll(@RequestParam String queueUrl) {
        sqsService.pollMessages(queueUrl);
        return "Polled";
    }
}