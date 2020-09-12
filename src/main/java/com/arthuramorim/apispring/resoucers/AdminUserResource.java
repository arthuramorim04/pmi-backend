package com.arthuramorim.apispring.resoucers;

import com.arthuramorim.apispring.entity.User;
import com.arthuramorim.apispring.entity.enums.UserRole;
import com.arthuramorim.apispring.security.VerifiLogin;
import com.arthuramorim.apispring.services.UserService;
import com.arthuramorim.apispring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/user/manager")
public class AdminUserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private VerifiLogin verifiLogin;


    @GetMapping(value = "/list-users")
    public ResponseEntity<List<User>> findAll(@RequestHeader HttpHeaders header) {

        if (verifiLogin.isAutorizated(header, UserRole.ADMIN)) {
            List<User> list = userService.findAll();
            return ResponseEntity.ok().body(list);
        } else {
            throw new ResourceNotFoundException(0);
        }

    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id, @RequestHeader HttpHeaders header) {
        if (verifiLogin.isAutorizated(header, UserRole.ADMIN)) {
            User obj = userService.findById(id);
            return ResponseEntity.ok().body(obj);
        } else {
            throw new ResourceNotFoundException(0);
        }

    }

    @PutMapping(value = "/edityrole")
    public ResponseEntity<User> findById(@RequestParam("idUser") Long id, @RequestParam("idRole") int idRole, @RequestHeader HttpHeaders header) {

        if (verifiLogin.isAutorizated(header, UserRole.ADMIN)) {
            User obj = userService.findById(id);
            try {
                UserRole userRole = UserRole.valueOf(idRole);
                if (userRole != null) {
                    obj.setRole(userRole);
                    userService.update(id, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ResponseEntity.ok().body(obj);
        } else {
            throw new ResourceNotFoundException(0);
        }

    }

//    @GetMapping(value = "/list-users-logged")
//    public ResponseEntity<List<User>> userLogged(@RequestHeader HttpHeaders header) {
//
//        if (verifiLogin.isAutorizated(header, UserRole.ADMIN)) {
//            return ResponseEntity.ok().body((List<User>) ApiSpringApplication.getUserLoginManager().getLogged());
//        } else {
//            throw new ResourceNotFoundException(0);
//        }
//
//    }


}
