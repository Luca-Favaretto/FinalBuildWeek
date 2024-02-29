package team3.FinalBuildWeek.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import team3.FinalBuildWeek.company.Company;
import team3.FinalBuildWeek.csv.entities.Municipality;


import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue
    private UUID id;
    private String address;
    private int number;
    private String location;
    @Column(name="post_code")

    private int postCode;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;
    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    public Address(String address, int number, String location, int postCode, Municipality municipality,Company company) {
        this.address = address;
        this.number = number;
        this.location = location;
        this.postCode = postCode;
        this.municipality = municipality;
        this.company=company;

    }
}