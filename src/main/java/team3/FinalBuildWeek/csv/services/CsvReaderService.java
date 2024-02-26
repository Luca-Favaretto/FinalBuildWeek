package team3.FinalBuildWeek.csv.services;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Configuration
public class CsvReaderService {

        @Bean
        public String readCsv() {
                try {

                        Resource resource = new ClassPathResource("C:\\Users\\lucaf\\OneDrive\\Desktop\\JAVA\\U5\\FinalBuildWeek\\src\\main\\java\\team3\\FinalBuildWeek\\csv\\file\\comune");
                        CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(resource.getInputStream())).withSkipLines(1).build();
                        List<String[]> csvData = csvReader.readAll() ;
                        for (String[] row : csvData) {
                                String codiceProvincia =(String) row[0];
                                String progressivoComune =(String) row[1];
                                String denominazioneItaliana =(String) row[2];
                                String provincia =(String)row[3];
                                System.out.println("Codice Provincia: " + codiceProvincia +
                                        ", Progressivo Comune: " + progressivoComune +
                                        ", Denominazione Italiana: " + denominazioneItaliana +
                                        ", Provincia: " + provincia);

                        }
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (CsvException e) {
                    throw new RuntimeException(e);
                }
                return "pippo";
        }
}
