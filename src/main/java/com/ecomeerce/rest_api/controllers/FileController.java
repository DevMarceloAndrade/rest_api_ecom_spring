package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.File;
import com.ecomeerce.rest_api.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/create")
    public File uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        return fileService.create(multipartFile);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFile(@PathVariable("id") UUID id) {
        return fileService.delete(id);
    }

    @DeleteMapping("/delete")
    public List<String> deleteAllFile(@RequestBody List<UUID> ids) {
        return fileService.deleteAllFile(ids);
    }
}
