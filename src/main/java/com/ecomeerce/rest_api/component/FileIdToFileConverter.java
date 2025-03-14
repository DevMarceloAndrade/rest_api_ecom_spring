package com.ecomeerce.rest_api.component;

import com.ecomeerce.rest_api.models.File;
import com.ecomeerce.rest_api.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FileIdToFileConverter extends DataConverterById<File> {

    @Autowired
    public FileIdToFileConverter(FileService baseService) {
        super(baseService);

    }
}
