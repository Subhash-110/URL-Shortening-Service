package org.example.urlshorteningservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @Column(unique = true)
    private String shortCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long accessCount = 0L;

    public UrlMapping(){}

    public Long getId() { return id; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getShortCode() { return shortCode; }

    public void setShortCode(String shortCode) { this.shortCode = shortCode; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Long getAccessCount() { return accessCount; }

    public void setAccessCount(Long accessCount) { this.accessCount = accessCount; }
}