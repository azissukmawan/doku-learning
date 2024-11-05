package dayone.explore.spring_data_jpa;

import dayone.explore.spring_data_jpa.entity.Book;
import dayone.explore.spring_data_jpa.entity.BookCategory;
import dayone.explore.spring_data_jpa.entity.Course;
import dayone.explore.spring_data_jpa.entity.Student;
import dayone.explore.spring_data_jpa.repository.BookCategoryRepository;
import dayone.explore.spring_data_jpa.repository.BookRepository;
import dayone.explore.spring_data_jpa.repository.CourseRepository;
import dayone.explore.spring_data_jpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(SpringDataJpaApplication.class);

	@Autowired
	private BookCategoryRepository bookCategoryRespository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CourseRepository courseRespository;

	@Autowired
	private StudentRepository studentRespository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	public void run(String... args) throws Exception {

//		add book
//		Book book1 = new Book();
//		book1.setTitle("Spring Data JPA");
//		book1.setWriter("Abdul Azis Sukmawan");
//		book1.setIsbn("IS-9999");
//
//		Book book2 = new Book();
//		book2.setTitle("Spring Data JPA 2");
//		book2.setWriter("Asep Kangkung");
//		book2.setIsbn("IS-9696");
//
//		bookRepository.save(book1);
//		bookRepository.save(book2);
//
//        LOG.info("Berhasil menyimpah book {}", book1);
//        LOG.info("Berhasil menyimpah book {}", book2);

//		find all books
		List<Book> allBooks = bookRepository.findAll();
		LOG.info("All Books: " + allBooks);

//		find books by writer
		final String writer = "Asep Kangkung";
		List<Book> booksByWriter = bookRepository.findAllByWriter(writer);
		LOG.info("Books by writer: " + booksByWriter);

//		find all books by native query
//		List<Book> nativeQueryBooks = bookRepository.findAllQueryNative();
//		LOG.info("Books with native query: " + nativeQueryBooks);

//		find all books in writer by native query
//		List<Book> nativeQueryBooksByWriter = bookRepository.findAllByWriterQueryNative(writer);
//		LOG.info("Books with writer in query native: " + nativeQueryBooksByWriter);

//		case one to many
//		create book category
//		BookCategory bookCategory = bookCategoryRespository.save(new
//				BookCategory("Sulap", new Book("Ajaib", "Asep", "969696"), new Book("Test2", "Ucup", "97643")));
//		LOG.info("Book Category: {}", bookCategory);

//		case many to many
		Student student = new Student("Udin", 15);

		studentRespository.save(student);
		Course course1 = new Course("Beginning Spring Boot", 12, 1500);
		Course course2 = new Course("Spring Reactive", 8, 800);
		Course course3 = new Course("Basic Microservices",9, 100);

		courseRespository.saveAll(Arrays.asList(course1, course2, course3));
		student.getCourses().addAll(Arrays.asList(course1, course2, course3));
		studentRespository.save(student);
	}

}
