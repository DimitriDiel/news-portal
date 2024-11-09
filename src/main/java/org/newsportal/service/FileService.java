package org.newsportal.service;


import org.newsportal.common.Pair;
import org.newsportal.entity.FileMetadata;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface FileService {
        UUID store(MultipartFile file);
        Pair<Resource, FileMetadata> load(UUID id);
}
