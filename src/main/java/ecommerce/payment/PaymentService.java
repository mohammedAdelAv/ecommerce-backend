package ecommerce.payment;

import org.springframework.stereotype.Service;

import ecommerce.order.Order;
import ecommerce.order.OrderRepo;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;
     private final OrderRepo orderRepo;

    public PaymentService(PaymentRepo paymentRepo, OrderRepo orderRepo) {
        this.paymentRepo = paymentRepo;
        this.orderRepo = orderRepo;
    }

    public Payment save(Payment payment) {

        Order order = orderRepo.findById(payment.getOrder().getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        payment.setOrder(order);

        return paymentRepo.save(payment);
    }

    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }
}