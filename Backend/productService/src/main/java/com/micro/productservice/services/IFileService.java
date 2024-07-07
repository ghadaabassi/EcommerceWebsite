package com.micro.productservice.services;

import com.micro.productservice.entities.File;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    File getFileById(Long id);
    File saveFile(MultipartFile file);
    boolean deleteFileById(Long id);


}
