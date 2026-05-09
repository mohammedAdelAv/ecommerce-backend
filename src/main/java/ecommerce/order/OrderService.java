package ecommerce.order;

import org.springframework.stereotype.Service;

import ecommerce.paymentclient.PaymentClient;
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
    private final PaymentClient paymentClient;

    public OrderService(OrderRepo orderRepo,
            UserRepo userRepo,
            ProductRepo productRepo,
            PaymentClient paymentClient) {

        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.paymentClient = paymentClient;
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

        Order savedOrder = orderRepo.save(order);

        paymentClient.makePayment(savedOrder.getId());

        return savedOrder;
    }

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    public Order updateStatus(Long id, String status) {

        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        return orderRepo.save(order);
    }
}