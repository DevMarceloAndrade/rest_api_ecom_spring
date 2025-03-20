package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.File;
import com.ecomeerce.rest_api.models.Product;
import com.ecomeerce.rest_api.repositories.FileRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import pro.handler.file.services.FileStorageService;
import pro.handler.file.vo.v1.UploadFileResponseVO;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileService extends BaseService<File>{

    private final FileStorageService fileStorageService;

    @Autowired
    public FileService(FileRepository dataBaseRepository, Validator validator, FileStorageService fileStorageService) {
        super(dataBaseRepository, validator);
        this.fileStorageService=fileStorageService;
    }

    public File fileStorage(MultipartFile multipartFile, String... subDirs){
        UploadFileResponseVO uploadFile = fileStorageService.uploadFile(multipartFile,subDirs);

        File file = new File(uploadFile.getFileName(),uploadFile.getFileType(),uploadFile.getFileSize());
        file.setFile_downloadUri(uploadFile.getFileDownloadUri());
        file.setFile_targetLocation(uploadFile.getFileTargetLocation());

        return file;
    }

    public File create(MultipartFile multipartFile, String... subDirs){
        return super.create(fileStorage(multipartFile,subDirs));
    }

    public List<File>createAll(MultipartFile[] multipartFiles,Product product ,String... subDirs){

        List<File> filesToCreate = Arrays.stream(multipartFiles).map(multipartFile->{
            File file = fileStorage(multipartFile,subDirs);
            file.setProduct_id(product);

            return file;
        }).toList();

        return super.dataBaseRepository.saveAll(filesToCreate);

    }

    public String delete(UUID id){
        super.checkEntityById(id);
        File fileToDelete = super.readById(id);
        fileStorageService.deleteFile(fileToDelete.getFile_name(),fileToDelete.getFile_targetLocation());
        deleteById(id);

        return "File deleted";
    }

    public List<String> deleteAllFile(@RequestBody List<UUID> ids){
        List<File> filesToDelete = dataBaseRepository.findAllById(ids);
        List<String> deletedResult = filesToDelete
                .stream()
                .map(file -> fileStorageService.deleteFile(file.getFile_name(),file.getFile_targetLocation()))
                .toList();

        dataBaseRepository.deleteAllById(ids);
        return deletedResult;
    }
}
