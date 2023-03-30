package vn.com.devmaster.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "vehicle_request")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "pic")
    private String pic;

    @Column(name = "pic_date")
    private Instant picDate;

    @Column(name = "note", length = 4000)
    private String note;
}