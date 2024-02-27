package team3.FinalBuildWeek.csv.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.csv.DAO.MunicipalityDAO;
import team3.FinalBuildWeek.csv.entities.Municipality;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class MunicipalitySRV {

    @Autowired
    MunicipalityDAO municipalityDAO;


    public Optional<Municipality> getMunicipalityById(UUID id){
        return municipalityDAO.findById(id);
    }

    public List<Municipality> getAllMunicipality(){
        return municipalityDAO.findAll();
    }

    public void deleteMunicipalityById(UUID id) {
        municipalityDAO.deleteById(id);
    }
}
