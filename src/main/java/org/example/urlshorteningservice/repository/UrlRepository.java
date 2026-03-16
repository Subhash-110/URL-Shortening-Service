package org.example.urlshorteningservice.repository;

import org.example.urlshorteningservice.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlMapping, Long> {

    Optional<UrlMapping> findByShortCode(String shortCode);

    void deleteByShortCode(String shortCode);
}
