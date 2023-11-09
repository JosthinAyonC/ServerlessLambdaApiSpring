package jayon.learning.lambda.config;

import org.springframework.context.annotation.Bean;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfiguration {

    private String region = "us-east-1";

    @Bean
    public AmazonS3 s3Client() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .build();
    }
}
