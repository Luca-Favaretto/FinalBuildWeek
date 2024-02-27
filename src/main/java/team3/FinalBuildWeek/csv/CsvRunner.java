package team3.FinalBuildWeek.csv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CsvRunner implements CommandLineRunner {


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
