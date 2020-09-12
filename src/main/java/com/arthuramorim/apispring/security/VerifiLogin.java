package com.arthuramorim.apispring.security;

import com.arthuramorim.apispring.entity.User;
import com.arthuramorim.apispring.entity.enums.UserRole;
import com.arthuramorim.apispring.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;

@Service(value = "verifyAcountService")
public class VerifiLogin {

    @Autowired
    private UserService userService;

    protected static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("MySecret"))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }


    public boolean isAutorizated(HttpHeaders header, UserRole endpointRole) {

        String authorization = header.get("authorization").get(0);
        String token = authorization.split("Bearer ")[1];
        //recupera o e-mail da request
        Claims claims = VerifiLogin.decodeJWT(token);
        User sub;
        int status = -1;
        try {
            sub = userService.findByMail((String) claims.get("sub"));
            if (sub.getRole().getCode() >= endpointRole.getCode()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
