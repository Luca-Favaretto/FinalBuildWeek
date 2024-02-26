package team3.FinalBuildWeek.csv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team3.FinalBuildWeek.csv.DAO.ProvinceDAO;
import team3.FinalBuildWeek.csv.entities.Province;

@RestController
@RequestMapping("/provinciacontroller")
public class provinceCTRL {

    @Autowired
    private ProvinceDAO provinceDAO;


        @PostMapping("/salvaprovincia")
        public void save (@RequestBody Province province) {
            provinceDAO.save(province);
        }



}
