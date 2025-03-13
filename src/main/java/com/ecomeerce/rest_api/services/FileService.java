package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.File;
import com.ecomeerce.rest_api.repositories.FileRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.handler.file.services.FileStorageService;
import pro.handler.file.vo.v1.UploadFileResponseVO;

@Service
public class FileService extends BaseService<File>{

    private FileStorageService fileStorageService;

    @Autowired
    public FileService(FileRepository dataBaseRepository, Validator validator, FileStorageService fileStorageService) {
        super(dataBaseRepository, validator);
        this.fileStorageService=fileStorageService;
    }

    public File create(MultipartFile multipartFile, String... subDirs){
        UploadFileResponseVO uploadFile = fileStorageService.uploadFile(multipartFile,subDirs);

        File file = new File();
        file.setFile_name(uploadFile.getFileName());
        file.setFile_size(uploadFile.getFileSize());
        file.setFile_downloadUri(uploadFile.getFileDownloadUri());
        file.setFile_targetLocation(uploadFile.getFileTargetLocation());
        file.setFile_type(uploadFile.getFileType());

        return super.create(file);
    }
}
