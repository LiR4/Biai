package com.api.biai.service;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.biai.repository.IBiRepository;;


@Service
public class BiFileService {

    public IBiRepository iBiRepository;

    public BiFileService(IBiRepository iBiRepository){
        this.iBiRepository = iBiRepository;
    }

    @Value("${filePath}")
    private String basePath;

    public long getBi(){
        return iBiRepository.count();
    }


    public String uploadFile(MultipartFile multipartFile) {
        File dir = new File(basePath + multipartFile.getName());

        if (dir.exists()) {
            return "EXIST";
        }

        Path path = Path.of(basePath + multipartFile.getName());

        try {
            Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return "CREATED";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "FAILED";
    }

    

}
