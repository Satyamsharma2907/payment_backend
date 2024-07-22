package Payment_Service.repository;


import Payment_Service.domain.orderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface razorpayRepository extends JpaRepository<orderResponse,String> {

}
