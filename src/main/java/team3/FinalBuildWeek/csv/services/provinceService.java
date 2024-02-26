package team3.FinalBuildWeek.csv.services;

import team3.FinalBuildWeek.csv.entities.Province;

import java.util.List;

public interface provinceService {

        void addProvince(Province province);
        List<Province> getProvince();

}
