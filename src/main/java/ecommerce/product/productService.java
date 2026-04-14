package ecommerce.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }
}