package com.crawler.crawler.repository;

import com.crawler.crawler.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {

    Domain findFirstByUrl(String url);
}
