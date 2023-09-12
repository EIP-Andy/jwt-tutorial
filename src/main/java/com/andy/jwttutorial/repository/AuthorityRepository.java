package com.andy.jwttutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andy.jwttutorial.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
