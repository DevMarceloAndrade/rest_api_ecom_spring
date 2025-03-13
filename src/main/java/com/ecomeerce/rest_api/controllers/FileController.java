package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.File;
import com.ecomeerce.rest_api.services.FileService;
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
    private FileService fileService;

    @PostMapping("/api/file/post")
    public File uploadFile(@RequestParam("file") MultipartFile multipartFile){
        return fileService.create(multipartFile);
    }
}
