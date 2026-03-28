package com.bezkoder.spring.files.upload.db.service;

import com.bezkoder.spring.files.upload.db.model.FileCategory;
import com.bezkoder.spring.files.upload.db.repository.FileCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileCategoryService {

    @Autowired
    private FileCategoryRepository fileCategoryRepository;

    public List<FileCategory> findAll() {
        return fileCategoryRepository.findAll();
    }

    public FileCategory findById(Long id) {
        return fileCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FileCategory not found with id: " + id));
    }

    public FileCategory create(FileCategory category) {
        return fileCategoryRepository.save(category);
    }

    public FileCategory update(Long id, FileCategory categoryDetails) {
        FileCategory existing = findById(id);
        existing.setName(categoryDetails.getName());
        existing.setDescription(categoryDetails.getDescription());
        return fileCategoryRepository.save(existing);
    }

    public void delete(Long id) {
        FileCategory existing = findById(id);
        fileCategoryRepository.delete(existing);
    }
}