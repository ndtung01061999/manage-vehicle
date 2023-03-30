package vn.com.devmaster.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "vehicle_history")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleHistory extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "account")
    private String account;

    @Column(name = "name_account")
    private String nameAccount;

    @Column(name = "vehicle_type_id")
    private Long vehicleTypeId;

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

    @Column(name = "building_id")
    private Long buildingId;

    @Column(name = "updated_reason", length = 4000)
    private String updatedReason;
}