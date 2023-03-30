package vn.com.devmaster.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "building")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "area")
    private Double area;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "location", length = 50)
    private String location;
}