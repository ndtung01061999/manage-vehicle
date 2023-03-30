package vn.com.devmaster.services.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.devmaster.services.domain.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    @Query(value = "select b from Building b " +
            " where b.code like concat('%',:keyword,'%') " +
            " or b.name like concat('%',:keyword, '%') ")
    Page<Building> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

    boolean existsByCode(String code);
}