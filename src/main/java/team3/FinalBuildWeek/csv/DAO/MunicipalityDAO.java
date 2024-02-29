package team3.FinalBuildWeek.csv.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.FinalBuildWeek.csv.entities.Municipality;

import java.util.UUID;

@Repository
public interface MunicipalityDAO extends JpaRepository<Municipality, UUID> {




}
