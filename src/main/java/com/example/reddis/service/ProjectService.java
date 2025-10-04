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
    public ResponseEntity<?> getProjectById(Long id){
        Optional<Projects> optionalProjects = projectsRepository.findById(id);
        if(optionalProjects.isEmpty()){
            return ResponseEntity.status(404).body("project with id not found");
        }
        Projects project = optionalProjects.get();

        return ResponseEntity.status(200).body(project);
    }

    @Transactional
    public  ResponseEntity<?> createProject(Projects project){

        Projects createdProject = projectsRepository.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);

    }
}
