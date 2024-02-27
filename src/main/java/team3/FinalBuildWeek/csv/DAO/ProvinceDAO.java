package team3.FinalBuildWeek.csv.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import team3.FinalBuildWeek.csv.entities.Province;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProvinceDAO extends JpaRepository<Province, UUID> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM provinces WHERE name = :name"
    )
    Optional<Province> findProvinceByName(@Param("name") String name);



}
