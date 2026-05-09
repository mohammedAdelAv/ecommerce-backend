package ecommerce.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Product updateProduct( @PathVariable Long id,
            @Valid @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteProduct( @PathVariable Long id) {

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/upload-image")
    public Product uploadImage( @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws Exception {

        Product product = productService.getById(id);

        String fileName = file.getOriginalFilename();

        Path path = Paths.get("uploads/" + fileName);

        Files.write(path, file.getBytes());

        product.setImageUrl("uploads/" + fileName);

        return productService.save(product);
    }

}