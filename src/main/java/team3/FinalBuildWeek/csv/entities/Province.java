package team3.FinalBuildWeek.csv.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "province")
@NoArgsConstructor

public class Province {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private UUID id;
    private String acronym;
    private String Province;
    private String Region;


    public Province(String acronym, String province, String region) {
        this.acronym = acronym;
        Province = province;
        Region = region;
    }
}
