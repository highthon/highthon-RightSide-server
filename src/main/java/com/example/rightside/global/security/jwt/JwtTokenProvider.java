package com.example.rightside.global.security.jwt;

import com.example.rightside.domain.user.presentation.dto.response.TokenResponse;
import com.example.rightside.global.exception.ExpiredJwtException;
import com.example.rightside.global.exception.InvalidJwtException;
import com.example.rightside.global.exception.SignatureJwtException;
import com.example.rightside.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private static final String ACCESS_KEY = "access";
    private static final String REFRESH_KEY = "refresh";
    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse generateTokens(String accountId) {
        String accessToken = generateToken(accountId, jwtProperties.getAccessExp());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }

    private String generateToken(String accountId, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .setSubject(accountId)
                .setHeaderParam("typ", ACCESS_KEY)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }



    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(HEADER);
        return parseToken(bearer);
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(PREFIX)) {
            return bearerToken.replace(PREFIX, "");
        }
        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw SignatureJwtException.EXCEPTION;
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }
}
