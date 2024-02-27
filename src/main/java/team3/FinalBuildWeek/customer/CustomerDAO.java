package team3.FinalBuildWeek.customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByEmail(String email);


}
