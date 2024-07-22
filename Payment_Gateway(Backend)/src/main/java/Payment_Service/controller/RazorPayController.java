package Payment_Service.controller;


import Payment_Service.domain.orderRequest;
import Payment_Service.domain.orderResponse;
import Payment_Service.service.IRazorpayService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/paymentservice")
@CrossOrigin(origins = "http://localhost:3000")
public class RazorPayController {

    private IRazorpayService razorpayService;

    @Autowired
    public RazorPayController(IRazorpayService razorpayService) {
        this.razorpayService = razorpayService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<?> createOrder(@RequestBody orderRequest orderRequest) throws RazorpayException {
        try {
            return new ResponseEntity<>(razorpayService.createOrder(orderRequest), HttpStatus.CREATED);
        }
        catch (RazorpayException e) {
            throw new RazorpayException("RazorPay Exception!!!");
        }
    }

    @PutMapping("/status/email/{email}")
    public ResponseEntity<?> updateOrder(@PathVariable String email, @RequestBody orderResponse orderResponse) {
        return new ResponseEntity<>(razorpayService.updateSubscriptionStatus(email, orderResponse), HttpStatus.CREATED);
    }

    @GetMapping("/subscription/email/{email}")
    public ResponseEntity<?> getOrder(@PathVariable String email) {
        return new ResponseEntity<>(razorpayService.getSubscriptionDetail(email), HttpStatus.OK);
    }
}
