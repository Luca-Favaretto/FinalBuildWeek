package team3.FinalBuildWeek.csv.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team3.FinalBuildWeek.csv.entities.Municipality;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MunicipalityDAO extends JpaRepository<Municipality, UUID> {


    @Query("SELECT m FROM Municipality m WHERE m.municipalName=:name")
    Optional<Municipality> findByMunicipalName(String name);



}
