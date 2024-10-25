package com.example.bookuser.repository;

import com.example.bookuser.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Author, UUID> {
}
