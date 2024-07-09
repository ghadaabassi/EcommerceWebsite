package com.micro.productservice.controllers;


import com.micro.productservice.entities.File;
import com.micro.productservice.services.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins="*")
@RequestMapping("/File")
@RestController
public class FileController {
    @Autowired
    private IFileService fileService;

    @PostMapping("/upload")
    public File uploadFile(@RequestParam("file") MultipartFile file) {
        return fileService.saveFile(file);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable int id) {
        try {
            boolean deleted = fileService.deleteFileById(id);
            if (deleted) {
                return ResponseEntity.ok("File deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during file deletion.");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable int id) {

        File FileEntity = fileService.getFileById(id);

        if (FileEntity != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", FileEntity.getFileName());
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(FileEntity.getData());
        } else {
            return ResponseEntity.notFound().build();
        }

    }




}