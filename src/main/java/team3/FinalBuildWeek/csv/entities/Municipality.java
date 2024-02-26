package team3.FinalBuildWeek.csv.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "municipality")
@Entity
@NoArgsConstructor
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cityCode;
    private String city;

    @ManyToOne
    private Province province;


}
