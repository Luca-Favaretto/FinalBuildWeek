package team3.FinalBuildWeek.csv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.csv.DAO.ProvinceDAO;
import team3.FinalBuildWeek.csv.entities.Province;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProvinceSRV {

    @Autowired
    ProvinceDAO provinceDAO;

    public Optional<Province> getProvinceById(UUID id) {
        return provinceDAO.findById(id);
    }

    public List<Province> getAllProvince() {
        return provinceDAO.findAll();
    }

    public void deleteProvinceById(UUID id) {
        provinceDAO.deleteById(id);
    }

    public List<Province> findByProvince(String a) {
        return provinceDAO.findByProvince(a);
    }

}

