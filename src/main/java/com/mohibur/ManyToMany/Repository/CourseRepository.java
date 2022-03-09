package com.mohibur.ManyToMany.Repository;

import com.mohibur.ManyToMany.Entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findByCourseCode(String courseCode);
}
