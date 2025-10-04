package com.example.reddis.controller;

import com.example.reddis.entity.Projects;
import com.example.reddis.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/project/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }

    @PostMapping("/project")
    public ResponseEntity<?>createProject(@RequestBody Projects project){
        return projectService.createProject(project);
    }

}
