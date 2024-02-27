package team3.FinalBuildWeek.csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import team3.FinalBuildWeek.csv.services.CsvReaderService;

@Component
public class CsvRunner implements CommandLineRunner {
    @Autowired
    CsvReaderService csvReaderService;


    @Override
    public void run(String... args) throws Exception {
csvReaderService.readCsv();

    }
}
