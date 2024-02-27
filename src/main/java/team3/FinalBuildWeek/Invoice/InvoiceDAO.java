package team3.FinalBuildWeek.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team3.FinalBuildWeek.customer.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, UUID> {

//    @Query("SELECT i FROM Invoice i JOIN Custumer c ON c=i.customer")
    List<Invoice> findInvoiceByCustomer(Customer customer);


}
