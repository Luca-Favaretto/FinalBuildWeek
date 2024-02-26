package team3.FinalBuildWeek.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, UUID> {
    Optional<Invoice> findById(UUID uuid);


}
