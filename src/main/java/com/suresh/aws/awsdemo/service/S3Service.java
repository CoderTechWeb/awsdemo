package com.suresh.aws.awsdemo.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

    private final S3Client s3Client;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void uploadText(String bucketname, String key, String content) {
        PutObjectRequest build = PutObjectRequest.builder()
                .bucket(bucketname)
                .key(key)
                .build();

        s3Client.putObject(build, RequestBody.fromString(content));
    }
}