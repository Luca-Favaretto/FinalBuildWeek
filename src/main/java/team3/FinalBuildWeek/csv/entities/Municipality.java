package team3.FinalBuildWeek.csv.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team3.FinalBuildWeek.address.Address;

import java.util.UUID;

@Getter
@Setter
@Table(name = "municipality")
@Entity
@NoArgsConstructor
public class Municipality {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)

    private UUID id;
    private String municipalName;
    private String city;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    @OneToMany
    private Address address;



    public Municipality(String municipalName, String city, Province province) {
        this.municipalName = municipalName;
        this.city = city;
        this.province = province;
    }
}
