package com.springcloud.courseservice.services;

import com.springcloud.courseservice.model.Course;
import com.springcloud.courseservice.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;


    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course saveCourse(Course course){
        course.setCreateTime(LocalDateTime.now());
        return repository.save(course);
    }

    @Override
    public void deleteCourse(Long id){
         repository.deleteById(id);
    }

    @Override
    public void getAllCourses(){
        repository.findAll();
    }
}
