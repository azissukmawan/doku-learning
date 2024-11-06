package daytwo.restapi.Webservice_restful.repository;

import daytwo.restapi.Webservice_restful.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
