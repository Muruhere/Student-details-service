package com.backend.servicerepo.Entity;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class CurriculumDetails {

    @DynamoDBAttribute
    private int maths;

    @DynamoDBAttribute
    private int cse;

    @DynamoDBAttribute
    private int physics;

    @DynamoDBAttribute
    private int chemistry;
}
