package vn.com.devmaster.services.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import vn.com.devmaster.services.jwt.domain.CustomUserDetail;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenProvider {
    public static final String AUTHORIZATION = "Authorization";
    public static final String ID_TOKEN = "idToken";
    public static final long exp = 5L;
    private static final String SECRET_KEY_STATE = "keymoc010699keymoc010699keymoc010699keymoc010699keymoc010699keymoc010699keymoc010699keymoc010699";

    public Key genKey() {
        return new SecretKeySpec(Base64.getDecoder().decode(SECRET_KEY_STATE),
                SignatureAlgorithm.HS256.getJcaName());
    }


    public String genToken(String email, Authentication authentication) {
        String authenticationString = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        long now = new Date().getTime();
        Date expiration = new Date(now + exp * 3600 * 24);
        return Jwts.builder()
                .setSubject(email)
                .setId(ID_TOKEN)
                .claim(AUTHORIZATION, authenticationString)
                .signWith(genKey(), SignatureAlgorithm.HS512)
                .setExpiration(expiration)
                .compact();
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(genKey()).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Invalid JWT token.");
        }
        return false;
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(genKey())
                .parseClaimsJws(token)
                .getBody();
        List<GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORIZATION)
                .toString()
                .split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        CustomUserDetail userDetails = new CustomUserDetail(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(userDetails, token, authorities);
    }

}
