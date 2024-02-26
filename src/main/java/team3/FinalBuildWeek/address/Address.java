package team3.FinalBuildWeek.address;

import jakarta.persistence.*;
import lombok.*;

import team3.FinalBuildWeek.company.Company;



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
    private String Location;
    @Column(name="post_code")
    private int PostCode;
    private String cityHall;

    @ManyToOne
    private Company company;


    public Address(String address, int number, String location, int postCode, String cityHall) {
        this.address = address;
        this.number = number;
        Location = location;
        PostCode = postCode;
        this.cityHall = cityHall;
    }
}