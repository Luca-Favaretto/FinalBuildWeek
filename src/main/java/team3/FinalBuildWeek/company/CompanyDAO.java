package team3.FinalBuildWeek.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyDAO extends JpaRepository<Company, UUID> {
       boolean existsByEmail(String email);

       Company findByBuisnessName(String buisnessName);

       @Query("SELECT c.business_name, EXTRACT(YEAR FROM i.date) AS anno, SUM(i.amount) AS fatturatoAnnuo " +
               "FROM Company c " +
               "JOIN Customer cust ON c.customer.id = cust.id " +
               "JOIN Invoice i ON cust.id = i.customer.id " +
               "GROUP BY c.business_name, EXTRACT(YEAR FROM i.date) " +
               "ORDER BY fatturatoAnnuo DESC")
       List<Object[]> getAziendeOrdinatePerFatturatoAnnuo();


       @Query("SELECT c FROM Company c WHERE c.insertion_date=:date")
       List<Company> findCompanyByDate (LocalDate date);


       @Query("SELECT c FROM Company c ORDER BY LOWER(c.business_name)")
       Page<Company> getAllOrderedByName(Pageable pageable);
       @Query("SELECT c FROM Company c ORDER BY (c.insertion_date)")
       Page<Company> getAllOrderedByInsertionDate(Pageable pageable);





       @Query("SELECT c FROM Company c WHERE LOWER(c.business_name) LIKE %:partialName% ORDER BY c.business_name")
       List<Company> getCompaniesByPartialName(@Param("partialName") String partialName);

       @Query("SELECT c FROM Company c WHERE LOWER(c.business_name)=LOWER(:name)")
       Optional<Company> findByBusinessName(String name);


}


