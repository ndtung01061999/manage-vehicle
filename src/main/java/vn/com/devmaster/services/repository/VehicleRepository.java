package vn.com.devmaster.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.devmaster.services.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}