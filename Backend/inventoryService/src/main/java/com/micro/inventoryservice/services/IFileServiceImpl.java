package com.micro.productservice.services;

import com.micro.productservice.entities.File;
import com.micro.productservice.repository.FileRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class IFileServiceImpl implements IFileService{

    private FileRepository fileRepository;

    @Override
    public File saveFile(MultipartFile file) {
        try {
            File fileEntity = new File();
            fileEntity.setFileName(file.getOriginalFilename());
            fileEntity.setData(file.getBytes());
            return fileRepository.save(fileEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public boolean deleteFileById(Long id) {
        File fileEntity = fileRepository.findById(id).orElse(null);
        if (fileEntity != null) {
            fileRepository.delete(fileEntity);
            return true;
        }
        return false;
    }

@Override
    public File getFileById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }
}
