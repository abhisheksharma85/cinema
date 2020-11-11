package com.abhisheksharma.fourthwall.cinema.security.jwt;

import com.abhisheksharma.fourthwall.cinema.config.FWProperties;
import com.abhisheksharma.fourthwall.cinema.security.DomainUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TokenProvider {

    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

    private static final String AUTHORITIES_KEY =   "auth";

    private static final String USER_ID         =   "userId";

    private static final String IP_ADDRESS      =   "ip";

    private static final String FIRST_NAME      =   "firstName";

    private static final String LAST_NAME       =   "lastName";

    private static final String SOURCE          =   "source";

    private Key key;

    private long tokenValidityInMilliseconds;

    private long tokenValidityInMillisecondsForRememberMe;

    private final FWProperties fwProperties;

    public TokenProvider(FWProperties fwProperties){this.fwProperties = fwProperties;}

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(fwProperties.getSecurity().getAuthentication().getJwt().getBase64Secret());
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.tokenValidityInMilliseconds = 1000 * fwProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSeconds();;
        this.tokenValidityInMillisecondsForRememberMe = 1000 * fwProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSecondsForRememberMe();
    }

    public String createToken(Authentication authentication, boolean rememberMe, String source) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        DomainUser user = (DomainUser) authentication.getPrincipal();

        return createToken(user.getId(), authentication.getName(),user.getFirstName(), user.getLastName(), authorities,rememberMe, source );
    }

    public String createToken(Long userId, String principal, String firstName, String lastName, String authorities, boolean rememberMe, String source) {
        long now = (new Date()).getTime();
        Date validity;
        if (rememberMe) {
            validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
        } else {
            validity = new Date(now + this.tokenValidityInMilliseconds);
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put(AUTHORITIES_KEY, authorities);
        claims.put(USER_ID,userId);
        claims.put(FIRST_NAME,firstName);
        claims.put(LAST_NAME,lastName);
        claims.put(SOURCE,source);

        return Jwts.builder()
                .setSubject(principal)
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(validity)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        DomainUser principal = new DomainUser(Long.parseLong(claims.get(USER_ID).toString()),claims.getSubject(), "",
                claims.get(FIRST_NAME).toString(),claims.get(LAST_NAME).toString(),authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace.", e);
        }
        return false;
    }

    public long getTokenValidityInMilliseconds(){ return this.tokenValidityInMilliseconds - 60000;}

}

