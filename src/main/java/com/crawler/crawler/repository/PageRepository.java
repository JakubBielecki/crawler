package com.crawler.crawler.repository;

import com.crawler.crawler.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, Long> {
}
