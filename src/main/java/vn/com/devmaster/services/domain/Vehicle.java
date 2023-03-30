package vn.com.devmaster.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "vehicle")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account")
    private String account;

    @Column(name = "name_account")
    private String nameAccount;

    @Column(name = "license_plate", length = 200)
    private String licensePlate;

    @Column(name = "automaker", length = 500)
    private String automaker;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "ticket", length = 100)
    private String ticket;

    @Column(name = "status")
    private Integer status;

    @Column(name = "updated_reason", length = 4000)
    private String updatedReason;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "vehicle_request_id")
    private VehicleRequest vehicleRequest;
}