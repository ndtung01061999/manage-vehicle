package vn.com.devmaster.services.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.com.devmaster.services.constants.PageConstants;
import vn.com.devmaster.services.service.BuildingService;
import vn.com.devmaster.services.service.dto.BuildingDTO;

import java.util.List;

@RestController
@RequestMapping("/api/building")
@RequiredArgsConstructor
public class BuildingResource {
    private final BuildingService buildingService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<BuildingDTO>> findByKeyword(@RequestParam("keyword") String keyword, Pageable pageable) {
        Page<BuildingDTO> page = buildingService.findByKeyWord(keyword, pageable);
        HttpHeaders headers = new HttpHeaders();
        headers.add(PageConstants.TOTAL_PAGE, String.valueOf(page.getTotalElements()));
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("")
    public void createBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.create(buildingDTO);
    }

}
