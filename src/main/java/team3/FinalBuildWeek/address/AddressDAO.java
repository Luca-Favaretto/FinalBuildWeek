package team3.FinalBuildWeek.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressDAO extends JpaRepository<Address, UUID> {
}
