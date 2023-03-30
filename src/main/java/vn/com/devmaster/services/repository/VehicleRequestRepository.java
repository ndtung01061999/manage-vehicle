package vn.com.devmaster.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.devmaster.services.domain.VehicleRequest;

public interface VehicleRequestRepository extends JpaRepository<VehicleRequest, Long> {
}