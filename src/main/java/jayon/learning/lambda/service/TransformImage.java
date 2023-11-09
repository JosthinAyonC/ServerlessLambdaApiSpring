package jayon.learning.lambda.service;

import java.io.ByteArrayInputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class TransformImage {

    @Autowired
    private AmazonS3 s3Client;

    public String uploadImage(byte[] img) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(img.length);

            System.out.println("img2: " + img);

            String bucket = "base-images-bucket";
            String fileName = UUID.randomUUID().toString() + ".png";
            s3Client.putObject(
                    new PutObjectRequest(
                            bucket, fileName, new ByteArrayInputStream(img), metadata));

            System.out.println("array: " + new ByteArrayInputStream(img));

            String imageUrl = String.format("https://%s.s3.amazonaws.com/%s", bucket, fileName);

            return imageUrl;

        } catch (Exception e) {
            throw new RuntimeException("Error al subir el archivo multimedia al servidor S3: " + e.getMessage());
        }
    }
}
