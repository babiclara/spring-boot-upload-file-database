package com.bezkoder.spring.files.upload.db.controller;

import com.bezkoder.spring.files.upload.db.model.FileCategory;
import com.bezkoder.spring.files.upload.db.service.FileCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("http://localhost:8081")
public class FileCategoryController {

    @Autowired
    private FileCategoryService fileCategoryService;

    @GetMapping
    public ResponseEntity<List<FileCategory>> getAllCategories() {
        List<FileCategory> categories = fileCategoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileCategory> getCategoryById(@PathVariable Long id) {
        try {
            FileCategory category = fileCategoryService.findById(id);
            return ResponseEntity.ok(category);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<FileCategory> createCategory(@RequestBody FileCategory category) {
        FileCategory created = fileCategoryService.create(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FileCategory> updateCategory(@PathVariable Long id,
                                                       @RequestBody FileCategory category) {
        try {
            FileCategory updated = fileCategoryService.update(id, category);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        try {
            fileCategoryService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}