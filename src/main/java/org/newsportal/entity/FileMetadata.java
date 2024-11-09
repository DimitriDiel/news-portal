package org.newsportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "file_metadata")
public class FileMetadata {
        @Id
        private UUID id;
        private LocalDateTime ctime;
        private long size;
        private String fileName;
        private String mimeType;
        private String keyword;
        }
