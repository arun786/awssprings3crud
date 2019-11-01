package com.arun.springs3read.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ReadS3 {

    private AWSConfig awsConfig;

    @Autowired
    public ReadS3(AWSConfig AWSConfig) {
        this.awsConfig = AWSConfig;
    }

    private static Regions regions = Regions.US_WEST_2;
    private static String bucketName = "earlys3bucket";

    public void lists3Bucket() {
        AmazonS3 awss3Client = getAWSS3Client(regions);
        ObjectListing objectListing = awss3Client.listObjects(bucketName);
        List<S3ObjectSummary> objectSummaries = objectListing.getObjectSummaries();
        objectSummaries.forEach(
                key -> System.out.println(key.getKey())
        );
    }


    private AmazonS3 getAWSS3Client(Regions regions) {
        AWSCredentials credentials = new BasicAWSCredentials(awsConfig.getAccessKey(), awsConfig.getSecretKey());
        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(regions).build();
    }


}
