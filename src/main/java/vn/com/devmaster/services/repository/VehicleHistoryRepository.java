package vn.com.devmaster.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.devmaster.services.domain.VehicleHistory;

public interface VehicleHistoryRepository extends JpaRepository<VehicleHistory, Long> {
}