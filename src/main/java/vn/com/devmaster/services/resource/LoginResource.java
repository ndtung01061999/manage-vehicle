package vn.com.devmaster.services.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.com.devmaster.services.service.LoginService;
import vn.com.devmaster.services.service.dto.LoginDTO;

@RestController
@RequiredArgsConstructor
public class LoginResource {
    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
