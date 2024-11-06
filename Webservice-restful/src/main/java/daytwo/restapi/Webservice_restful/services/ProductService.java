package daytwo.restapi.Webservice_restful.services;

import daytwo.restapi.Webservice_restful.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Product findProductById(Long id);

    Product saveorUpdateProduct(Product product);

    void deleteProduct(Long id);
}
