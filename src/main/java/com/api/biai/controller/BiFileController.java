package com.api.biai.controller;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.biai.service.BiFileService;



@RestController
public class BiFileController {

    private BiFileService biFileService;

    
    public BiFileController(BiFileService biFileService) {
        this.biFileService = biFileService;
    }


	@RequestMapping(method = RequestMethod.GET ,path = "/hello")
    public String hello() {
        return "Hello, Woaaaaaaaarld!";
    }


    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file) {
        String status = biFileService.uploadFile(file);
        return "CREATED".equals(status) ? new ResponseEntity<>(HttpStatus.CREATED) : ("EXIST".equals(status) ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED) : new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED));
    }
}


/* https://stackoverflow.com/questions/44128195/how-to-upload-file-in-spring */