package org.example.springpractice.upload.controller;

import org.example.springpractice.upload.model.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Long> {
}
