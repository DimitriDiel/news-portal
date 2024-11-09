package org.newsportal.dto;

import jakarta.validation.constraints.NotNull;
import org.newsportal.entity.User;

public record ArticleRequest(

        @NotNull(message = "Title is required")
        String title,
        @NotNull(message = "Content is required")
        String content,
        @NotNull(message = "Url is required")
        String url,
        @NotNull(message = "Thumbnail is required")
        String thumbnail
) {
}
