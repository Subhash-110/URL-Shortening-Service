package org.example.urlshorteningservice.service;

import org.example.urlshorteningservice.model.UrlMapping;
import org.example.urlshorteningservice.repository.UrlRepository;
import org.example.urlshorteningservice.util.ShortCodeGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository repository;

    public UrlServiceImpl(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public UrlMapping createShortUrl(String url) {

        UrlMapping mapping = new UrlMapping();

        mapping.setUrl(url);
        mapping.setShortCode(ShortCodeGenerator.generateCode());
        mapping.setCreatedAt(LocalDateTime.now());
        mapping.setUpdatedAt(LocalDateTime.now());

        return repository.save(mapping);
    }

    @Override
    public UrlMapping getUrl(String code) {

        UrlMapping mapping = repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        mapping.setAccessCount(mapping.getAccessCount() + 1);

        repository.save(mapping);

        return mapping;
    }

    @Override
    public UrlMapping updateUrl(String code, String newUrl) {

        UrlMapping mapping = repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        mapping.setUrl(newUrl);
        mapping.setUpdatedAt(LocalDateTime.now());

        return repository.save(mapping);
    }

    @Override
    public void delete(String code) {

        UrlMapping mapping = repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        repository.delete(mapping);
    }

    @Override
    public UrlMapping getStats(String code) {

        return repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));
    }
}
