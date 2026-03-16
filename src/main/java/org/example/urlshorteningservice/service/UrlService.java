package org.example.urlshorteningservice.service;

import org.example.urlshorteningservice.model.UrlMapping;

public interface UrlService {

    UrlMapping createShortUrl(String url);

    UrlMapping getUrl(String code);

    UrlMapping updateUrl(String code, String newUrl);

    void delete(String code);

    UrlMapping getStats(String code);
}
