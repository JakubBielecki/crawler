package com.crawler.crawler.repository;

import com.crawler.crawler.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
