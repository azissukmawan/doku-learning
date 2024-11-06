package daytwo.restapi.Webservice_restful.services.impl;

import daytwo.restapi.Webservice_restful.model.Product;
import daytwo.restapi.Webservice_restful.repository.ProductRepository;
import daytwo.restapi.Webservice_restful.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) throws ExceptionInInitializerError {
        Product product = productRepository.findById(id).orElse(new Product());

        return product;
    }

    @Override
    public Product saveorUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(new Product());
        productRepository.delete(product);
    }
}
