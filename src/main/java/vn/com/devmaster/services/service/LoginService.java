package vn.com.devmaster.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import vn.com.devmaster.services.constants.EntityName;
import vn.com.devmaster.services.constants.ErrorEnum;
import vn.com.devmaster.services.domain.User;
import vn.com.devmaster.services.error.BadAlertRequestException;
import vn.com.devmaster.services.jwt.TokenProvider;
import vn.com.devmaster.services.jwt.domain.CustomUserDetail;
import vn.com.devmaster.services.repository.UserRepository;
import vn.com.devmaster.services.service.dto.LoginDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final TokenProvider tokenProvider;
    private final UserRepository userRepository;

    public String login(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findByAccount(loginDTO.getUsername());
        if (!userOptional.isPresent()) {
            throw new BadAlertRequestException(ErrorEnum.USER_NOT_FOUND.getMsg(), EntityName.USER, ErrorEnum.USER_NOT_FOUND.getCode());
        }
        User user = userOptional.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        UserDetails userDetails = new CustomUserDetail(user.getFullName(), "", authorities);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
        return tokenProvider.genToken(loginDTO.getUsername(), authentication);
    }
}
