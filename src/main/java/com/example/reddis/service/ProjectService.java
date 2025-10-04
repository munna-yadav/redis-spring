package com.example.reddis.service;


import com.example.reddis.entity.Projects;
import com.example.reddis.repository.ProjectsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.Map;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectsRepository projectsRepository;

    @Cacheable(value = "projects", key = "#id")
    @Transactional
    public Projects getProjectById(Long id) {
        return projectsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project with id " + id + " not found"));
    }


    @Transactional
    public  ResponseEntity<?> createProject(Projects project){

        Projects createdProject = projectsRepository.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);

    }

    
}
