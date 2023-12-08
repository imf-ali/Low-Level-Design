package org.lld.service;

import lombok.extern.slf4j.Slf4j;
import org.lld.dao.entity.Url;
import org.lld.dao.repository.UrlRespository;
import org.lld.dto.CreateUrlRequestDto;
import org.lld.exception.AppErrorCodes;
import org.lld.exception.AppException;
import org.lld.utils.CryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
@Slf4j
public class UrlService {
  @Autowired
  private UrlRespository urlRespository;

  public String createUrl(CreateUrlRequestDto createUrlRequestDto) throws AppException {
    Url url = urlRespository.findByLongUrl(createUrlRequestDto.getLongUrl());
    if(!ObjectUtils.isEmpty(url)){
      throw new AppException(AppErrorCodes.URL_ALREADY_PRESENT);
    }
    String shortUrl = CryptionService.hashString(createUrlRequestDto.getLongUrl());
    Url urlData = new Url(createUrlRequestDto.getLongUrl(), shortUrl, createUrlRequestDto.getExpiryDate());
    urlRespository.save(urlData);
    return urlData.getShortUrl();
  }
  public String getUrl(String shortUrlId) throws AppException {
    log.info("Fetching url for the short url : {}", shortUrlId);
    Url url = urlRespository.findByShortUrl(shortUrlId)
        .orElseThrow(() -> new AppException(AppErrorCodes.URL_NOT_FOUND));
    log.info("Url found with long id as : {}", url.getLongUrl());
    if(url.hasExpired()){
      throw new AppException(AppErrorCodes.URL_HAS_EXPIRED);
    }
    return url.getLongUrl();
  }
}
