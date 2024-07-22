package Payment_Service.service;


import com.razorpay.RazorpayException;
import Payment_Service.domain.orderRequest;
import Payment_Service.domain.orderResponse;


import java.util.Optional;

public interface IRazorpayService {
    public orderResponse createOrder(orderRequest orderRequest) throws RazorpayException;
    public orderResponse updateSubscriptionStatus(String email, orderResponse orderDetails);
    public Optional<orderResponse> getSubscriptionDetail(String email);
}
