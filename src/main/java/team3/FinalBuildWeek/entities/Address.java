package team3.FinalBuildWeek.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
}