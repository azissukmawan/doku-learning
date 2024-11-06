package daytwo.restapi.Webservice_restful.controller;

import daytwo.restapi.Webservice_restful.model.Product;
import daytwo.restapi.Webservice_restful.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(),
        HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product product) {
        return new ResponseEntity<>(productService.saveorUpdateProduct(product),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable Long id) throws Exception {
        return new ResponseEntity<Product>(productService.findProductById(id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "delete sukses";
    }
}
