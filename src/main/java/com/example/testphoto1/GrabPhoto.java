package com.example.testphoto1;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;

public class GrabPhoto {

   public static String grabPho(InputStream i) throws IOException {
        String clientRegion = "us-east-2";
        String bucketName = "theupchuckbucket";
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        //2016-11-16 06:43:19.77

        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(clientRegion)
                    .build();
        
            
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/jpg");
            metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            
            byte[] bytes = IOUtils.toByteArray(i);
            metadata.setContentLength(bytes.length);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            
            // Upload a file as a new object with ContentType and title specified.
            PutObjectRequest request = new PutObjectRequest(bucketName, timestamp, byteArrayInputStream, metadata);
            
            s3Client.putObject(request);
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
        
        return timestamp;
    }
}

