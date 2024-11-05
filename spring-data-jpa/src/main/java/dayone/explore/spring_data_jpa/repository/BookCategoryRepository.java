package dayone.explore.spring_data_jpa.repository;

import dayone.explore.spring_data_jpa.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
