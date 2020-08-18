package com.arthuramorim.apispring.resoucers;

import com.arthuramorim.apispring.entity.User;
import com.arthuramorim.apispring.entity.enums.UserRole;
import com.arthuramorim.apispring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/user/manager")
public class AdminUserResource {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/list-users")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "user/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/edityrole")
    public ResponseEntity<User> findById(@RequestParam("idUser") Long id, @RequestParam("idRole") int idRole) {
        User obj = userService.findById(id);
        try{
            UserRole userRole = UserRole.valueOf(idRole);
            if(userRole!=null){
                obj.setRole(userRole);
                userService.update(id,obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user = userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }


}
