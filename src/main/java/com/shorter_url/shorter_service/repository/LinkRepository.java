package com.shorter_url.shorter_service.repository;

import com.shorter_url.shorter_service.Entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {


}
