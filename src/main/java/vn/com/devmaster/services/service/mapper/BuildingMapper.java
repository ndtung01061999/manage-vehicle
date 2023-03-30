package vn.com.devmaster.services.service.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.services.domain.Building;
import vn.com.devmaster.services.service.dto.BuildingDTO;

import java.util.Collection;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class BuildingMapper implements EntityMapper<BuildingDTO, Building> {
    @Override
    public BuildingDTO toDto(Building entity) {
        BuildingDTO dto = new BuildingDTO();
//        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setLocation(entity.getLocation());
        return dto;
    }

    @Override
    public Building toEntity(BuildingDTO dto) {
        Building entity = new Building();
        entity.setCode(dto.getCode().toUpperCase(Locale.ROOT));
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setArea(dto.getArea());
        entity.setLocation(dto.getLocation());
        return entity;
    }

    @Override
    public Collection<BuildingDTO> toDto(Collection<Building> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Collection<Building> toEntity(Collection<BuildingDTO> dto) {
        return null;
    }
}
