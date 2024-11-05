package dayone.explore.spring_data_jpa.repository;

import dayone.explore.spring_data_jpa.entity.Book;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.logging.Logger;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    List<Book> findAllByWriter(String writer);

//    native query
    @Query(
            nativeQuery = true,
            value = "select * from book"
    )
    List<Book> findAllQueryNative();

//    native query with parameter
    @Query(
            nativeQuery = true,
            value = "select * from book where writer = ?1"
    )
    List<Book> findAllByWriterQueryNative(String writer);
}
