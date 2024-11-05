package dayone.explore.spring_data_jpa.repository;

import dayone.explore.spring_data_jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
