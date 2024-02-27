package team3.FinalBuildWeek.customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByEmail(String email);

    @Query("SELECT c FROM Customer c JOIN c.invoices inv WHERE YEAR(inv.date) = :year GROUP BY c HAVING SUM(inv.amount) > :value")
    public List<Customer> getByAnnualRevenue(double value, int year);


}
