package com.springcloud.courseservice.services;

import com.springcloud.courseservice.model.Course;

public interface CourseService {

    Course saveCourse(Course course);

    void deleteCourse(Long id);

    void getAllCourses();
}
