package com.bezkoder.spring.files.upload.db.repository;

import com.bezkoder.spring.files.upload.db.model.FileCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileCategoryRepository extends JpaRepository<FileCategory, Long> {
}
