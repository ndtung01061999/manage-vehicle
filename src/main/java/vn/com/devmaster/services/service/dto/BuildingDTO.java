package vn.com.devmaster.services.service.dto;

import lombok.Data;

@Data
public class BuildingDTO {
    private Long id;

    private String code;

    private String name;

    private String address;

    private Double area;

    private Boolean status;

    private String location;
}
