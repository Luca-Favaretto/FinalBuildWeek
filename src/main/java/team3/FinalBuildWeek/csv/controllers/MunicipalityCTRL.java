package team3.FinalBuildWeek.csv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team3.FinalBuildWeek.csv.entities.Municipality;
import team3.FinalBuildWeek.csv.services.MunicipalitySRV;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/municipality")
public class MunicipalityCTRL {

    @Autowired
    MunicipalitySRV municipalitySRV;

    @GetMapping
    public ResponseEntity<List<Municipality>> getAll() {
        List<Municipality> list = municipalitySRV.getAllMunicipality();
        if( list.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        Optional<Municipality> clObj = municipalitySRV.getMunicipalityById(id);
        return clObj.<ResponseEntity<Object>>map(municipality -> new ResponseEntity<>(municipality, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Comune non trovato", HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProvinceById(@PathVariable UUID id) {
        municipalitySRV.deleteMunicipalityById(id);
    }


}
