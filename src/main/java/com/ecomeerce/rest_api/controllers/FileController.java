package com.ecomeerce.rest_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pro.handler.file.services.FileStorageService;
import pro.handler.file.vo.v1.UploadFileResponseVO;

@RestController
public class FileController {
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/api/file/post")
    public UploadFileResponseVO uploadFile(@RequestParam("file") MultipartFile file){
        return fileStorageService.uploadFile(file);
    }
}
