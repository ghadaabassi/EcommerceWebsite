package com.micro.productservice.services;

import com.micro.productservice.entities.File;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    File getFileById(int id);
    File saveFile(MultipartFile file);
    boolean deleteFileById(int id);


}
