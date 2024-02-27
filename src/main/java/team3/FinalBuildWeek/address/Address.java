package team3.FinalBuildWeek.address;

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
    private String Location;
    @Column(name="post_code")
    private int PostCode;

    @ManyToOne
    private Municipality municipality;

    @ManyToOne
    private Company company;

    public Address(String address, int number, String location, int postCode) {
        this.address = address;
        this.number = number;
        Location = location;
        PostCode = postCode;

    }
}