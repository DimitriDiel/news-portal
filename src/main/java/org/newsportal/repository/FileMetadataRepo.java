package org.newsportal.repository;


import org.newsportal.entity.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileMetadataRepo extends JpaRepository<FileMetadata, UUID> {
}
