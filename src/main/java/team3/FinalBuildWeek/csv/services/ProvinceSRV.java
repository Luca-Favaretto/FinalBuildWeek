package team3.FinalBuildWeek.csv.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.csv.DAO.ProvinceDAO;
import team3.FinalBuildWeek.csv.entities.Province;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ProvinceSRV {

    @Autowired
    ProvinceDAO provinceDAO;


    public Optional<Province> getProvinceById(UUID id){
        return provinceDAO.findById(id);
    }

    public List<Province> getAllProvince(){
        return provinceDAO.findAll();
    }

    public void deleteProvinceById(UUID id) {
        provinceDAO.deleteById(id);
    }



}