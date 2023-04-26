package com.portfolioap.abeldev.security.jwt;

import com.portfolioap.abeldev.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

/**
 *
 * @author ABEL DEV
 */
@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        UsuarioPrincipal primerusuario = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(primerusuario.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("ERROR EN LA FORMACION DEL TOKEN");
        } catch (UnsupportedJwtException e) {
            logger.error("NO SE SOPORTA EL TOKEN");
        } catch (ExpiredJwtException e) {
            logger.error("EL TOKEN HA EXPIRADO");
        } catch (IllegalArgumentException e) {
            logger.error("EL TOKEN ESTA VACIO");
        } catch (SignatureException e) {
            logger.error("LA FIRMA DEL TOKEN NO ES VALIDA");
        }
        return false;
    }
}
