package org.newsportal.controller;


import org.newsportal.entity.FileMetadata;
import org.newsportal.exception.InvalidDataException;
import org.newsportal.exception.NotFoundException;
import org.newsportal.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.UUID;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new InvalidDataException("File cannot be empty.");
        }
        var id = fileService.store(file);

        return ResponseEntity.ok(id.toString());
    }


    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") String fileId) throws FileNotFoundException {
        UUID id = UUID.fromString(fileId);
        var got = fileService.load(id);
        Resource resource = got.getFirst();
        FileMetadata media = got.getSecond();

        if (resource == null) {
            throw new NotFoundException("File not found.");
        }
        HttpHeaders headers = new HttpHeaders();

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + media.getFileName() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
