package vn.com.devmaster.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.devmaster.services.domain.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}