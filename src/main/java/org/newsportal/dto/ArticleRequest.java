package org.newsportal.dto;

import jakarta.validation.constraints.NotNull;

public record ArticleRequest(
        String title,
        @NotNull(message = "Author is required")
        String author,
        @NotNull(message = "Content is required")
        String content,
        @NotNull(message = "Url is required")
        String url,
        @NotNull(message = "Thumbnail is required")
        String thumbnail
) {
}
