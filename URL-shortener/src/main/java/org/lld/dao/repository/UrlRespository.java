package org.lld.dao.repository;

import org.lld.dao.entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRespository extends MongoRepository<Url, String> {
  Url findByLongUrl(String url);
  Optional<Url> findByShortUrl(String url);
}
