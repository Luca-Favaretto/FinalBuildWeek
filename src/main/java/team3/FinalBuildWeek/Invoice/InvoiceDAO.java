package team3.FinalBuildWeek.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import team3.FinalBuildWeek.customer.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, UUID> {

    @Query("SELECT i FROM Invoice i JOIN i.customer c WHERE c = :customer")
    List<Invoice> getInvoiceByCustomer(Customer customer);
    @Query("SELECT i FROM Invoice i WHERE LOWER(i.invoiceStatus)=LOWER(:invoiceStatus)")
    List<Invoice> findByInvoiceStatus(String invoiceStatus);
    @Query("SELECT i FROM Invoice i WHERE i.date=:date")
    List<Invoice> findInvoicesByDate(LocalDate date);
    @Query("SELECT i FROM Invoice i WHERE YEAR(i.date) = :year")
    List<Invoice> findInvoicesByYear(int year);


}
