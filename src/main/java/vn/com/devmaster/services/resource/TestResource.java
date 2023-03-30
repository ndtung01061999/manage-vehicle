package vn.com.devmaster.services.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {
    @GetMapping("/api/test")
    String test() {
        return "test token successful";
    }
}
