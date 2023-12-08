package org.lld.controller;

import org.lld.dto.CreateUrlRequestDto;
import org.lld.exception.AppException;
import org.lld.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
public class UrlController {

  @Autowired
  private UrlService urlService;

  @PostMapping(value = "/create")
  public ResponseEntity<String> createShortUrl(@RequestBody CreateUrlRequestDto createUrlRequestDto) throws AppException {
    return ResponseEntity.ok(urlService.createUrl(createUrlRequestDto));
  }

  @GetMapping(value = "/{shortUrlId}")
  @Cacheable(value = "urls", key = "#shortUrlId", sync = true)
  public ResponseEntity<Object> getString(@PathVariable String shortUrlId) throws AppException {
    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(urlService.getUrl(shortUrlId))).build();
  }
}
