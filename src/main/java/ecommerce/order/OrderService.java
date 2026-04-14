package ecommerce.order;

import org.springframework.stereotype.Service;

import ecommerce.product.Product;
import ecommerce.product.ProductRepo;
import ecommerce.user.User;
import ecommerce.user.UserRepo;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;

    public OrderService(OrderRepo orderRepo, UserRepo userRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    public Order save(Order order) {

        User user = userRepo.findById(order.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);

        if (order.getProducts() != null) {
            List<Product> products = order.getProducts().stream()
                    .map(p -> productRepo.findById(p.getId())
                            .orElseThrow(() -> new RuntimeException("Product not found")))
                    .toList();

            order.setProducts(products);
        }
        return orderRepo.save(order);
    }

    public List<Order> getAll() {
        return orderRepo.findAll();
    }
}