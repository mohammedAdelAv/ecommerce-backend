package ecommerce.paymentclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentClient {

    private final RestTemplate restTemplate;

    public PaymentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPayments() {

        String url = "http://localhost:8081/api/payments";

        return restTemplate.getForObject(url, String.class);
    }

    public String makePayment(Long orderId) {

        String url = "http://localhost:8081/api/payments/pay";

        PaymentRequest request = new PaymentRequest();

        request.setOrderId(orderId);
        request.setMethod("VISA");

        restTemplate.postForObject(url, request, String.class);

        return "Payment Done";
    }
}