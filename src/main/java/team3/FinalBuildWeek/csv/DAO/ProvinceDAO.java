package team3.FinalBuildWeek.csv.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import team3.FinalBuildWeek.csv.entities.Province;

import java.util.List;

import java.util.UUID;

@Repository
public interface ProvinceDAO extends JpaRepository<Province, UUID> {





    public List<Province> findByProvince(String province);


}
