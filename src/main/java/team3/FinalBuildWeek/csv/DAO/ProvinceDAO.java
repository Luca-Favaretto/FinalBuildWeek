package team3.FinalBuildWeek.csv.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.FinalBuildWeek.csv.entities.Province;

@Repository
public interface ProvinceDAO extends JpaRepository<Province,Long> {
}