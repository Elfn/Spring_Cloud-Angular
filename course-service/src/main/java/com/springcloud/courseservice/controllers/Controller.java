package com.springcloud.courseservice.controllers;

import com.springcloud.courseservice.model.Course;
import com.springcloud.courseservice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course")
public class Controller {

    private final CourseService service;


    public Controller(CourseService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(service.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId){
        service.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCourse(){
        service.getAllCourses();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
