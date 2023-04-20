package com.backend.servicerepo.Dao;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {


    @Value("${aws.accessKeyID}")
    private String accessId;
    @Value("${aws.secretAccessKey}")
    private String accessKey;

    @Bean()
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(getAmazonDB());
    }

    @Bean()
    public AmazonDynamoDB getAmazonDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "dynamodb.ap-south-1.amazonaws.com",
                                "ap-south-1"
                        )
                )
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(accessId, accessKey)
                        )
                ).build();
    }
}
