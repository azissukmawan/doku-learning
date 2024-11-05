package dayone.explore.spring_data_jpa.repository;

import dayone.explore.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
