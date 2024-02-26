package team3.FinalBuildWeek.csv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.csv.DAO.MunicipalityDAO;
import team3.FinalBuildWeek.csv.DAO.ProvinceDAO;
import team3.FinalBuildWeek.csv.entities.Province;


@Service
public class provinceSRV  {

    @Autowired
    ProvinceDAO provinceDAO;
    @Autowired
    private MunicipalityDAO municipalityDAO;

    public void salvaProvincia(Province province) {
        provinceDAO.save(province);
    }



}
