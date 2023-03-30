package vn.com.devmaster.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.devmaster.services.constants.EntityName;
import vn.com.devmaster.services.constants.ErrorEnum;
import vn.com.devmaster.services.domain.Building;
import vn.com.devmaster.services.error.BadAlertRequestException;
import vn.com.devmaster.services.repository.BuildingRepository;
import vn.com.devmaster.services.service.dto.BuildingDTO;
import vn.com.devmaster.services.service.mapper.BuildingMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;


    public Page<BuildingDTO> findByKeyWord(String keyword, Pageable pageable) {
        Page<Building> buildings = buildingRepository.findByKeyword(keyword, pageable);
        return buildings.map(buildingMapper::toDto);
    }

    @Transactional
    public void create(BuildingDTO buildingDTO) {
        if (buildingRepository.existsByCode(buildingDTO.getCode())) {
            throw new BadAlertRequestException(ErrorEnum.BUILDING_CODE_EXIST.getMsg(),
                    EntityName.BUIlDING,
                    ErrorEnum.BUILDING_CODE_EXIST.getCode());
        }
        Building building = buildingMapper.toEntity(buildingDTO);
        building.setStatus(true);
        buildingRepository.save(building);
    }

    @Transactional
    public void update(Long id, BuildingDTO buildingDTO) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (!optionalBuilding.isPresent()) {
            throw new BadAlertRequestException(
                    ErrorEnum.BUILDING_NOT_FOUND.getMsg(),
                    EntityName.BUIlDING,
                    ErrorEnum.BUILDING_NOT_FOUND.getCode());
        }
        Building building = buildingMapper.toEntity(buildingDTO);
        building.setId(id);
        building.setStatus(optionalBuilding.get().getStatus());
        buildingRepository.save(building);
    }
}
