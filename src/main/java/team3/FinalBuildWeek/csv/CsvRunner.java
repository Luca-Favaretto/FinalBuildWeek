package team3.FinalBuildWeek.csv;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import team3.FinalBuildWeek.csv.DAO.MunicipalityDAO;
import team3.FinalBuildWeek.csv.DAO.ProvinceDAO;
import team3.FinalBuildWeek.csv.entities.Municipality;
import team3.FinalBuildWeek.csv.entities.Province;

import java.io.FileReader;
import java.util.List;

@Component
public class CsvRunner implements CommandLineRunner {

    @Autowired
    ProvinceDAO provinceDAO;

    @Autowired
    MunicipalityDAO municipalityDAO;

    @Override
    public void run(String... args) throws Exception {



//
//        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
//        try(CSVReader reader = new CSVReaderBuilder(
//                new FileReader("src/main/java/team3/FinalBuildWeek/csv/file/province-italiane.csv"))
//                .withCSVParser(csvParser)
//                .withSkipLines(1)
//                .build()){
//            List<String[]> r = reader.readAll();
//            r.forEach(x -> provinceDAO.save(new Province(x[0],x[1],x[2])) );
//        }

//
//        CSVParser csvParser2 = new CSVParserBuilder().withSeparator(';').build();
//        try(CSVReader reader = new CSVReaderBuilder(
//                new FileReader("src/main/java/team3/FinalBuildWeek/csv/file/comuni-italiani.csv"))
//                .withCSVParser(csvParser2)
//                .withSkipLines(1)
//                .build()){
//            List<String[]> r = reader.readAll();
//            r.forEach(x -> municipalityDAO.save(new Municipality(x[0],x[0],new Province() )) );
//        }


    }
}
