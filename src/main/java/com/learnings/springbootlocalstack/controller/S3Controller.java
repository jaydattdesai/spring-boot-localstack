package com.learnings.springbootlocalstack.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.learnings.springbootlocalstack.domain.CreateBucketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class S3Controller {

    @Autowired
    private AmazonS3 amazonS3;

    @RequestMapping(value = "buckets", method = RequestMethod.POST)
    public ResponseEntity<String> createBucket(@RequestBody CreateBucketRequest createBucketRequest) {
        amazonS3.createBucket(createBucketRequest.getBucketName());
        return ResponseEntity.ok("{\"status\":\"created\"}");
    }

    @RequestMapping(value = "buckets", method = RequestMethod.GET)
    public ResponseEntity<List<Bucket>> listBucket() {
        return ResponseEntity.ok(amazonS3.listBuckets());
    }
}
