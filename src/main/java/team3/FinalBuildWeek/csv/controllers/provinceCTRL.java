package team3.FinalBuildWeek.csv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team3.FinalBuildWeek.csv.entities.Province;
import team3.FinalBuildWeek.csv.services.ProvinceSRV;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/province")
public class provinceCTRL {
    @Autowired
    ProvinceSRV provinceSRV;
    @GetMapping
    public ResponseEntity<List<Province>> getAll() {
        List<Province> list = provinceSRV.getAllProvince();
        if( list.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        Optional<Province> clObj = provinceSRV.getProvinceById(id);
        return clObj.<ResponseEntity<Object>>map(province -> new ResponseEntity<>(province, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Provincia non trovata", HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProvinceById(@PathVariable UUID id) {
        provinceSRV.deleteProvinceById(id);
    }
}