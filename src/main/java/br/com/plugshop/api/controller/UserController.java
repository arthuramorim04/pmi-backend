package br.com.plugshop.api.controller;

import br.com.plugshop.api.repository.UserRepository;
import com.sun.corba.se.impl.protocol.RequestCanceledException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.plugshop.api.entity.User;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository _UserRepository;

    //Cadastra User
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public Object Post(@Valid @RequestBody User user) {
        try{
            return _UserRepository.save(user);

        }catch (RequestCanceledException e){
            return  e.getCause();
        }
    }
}
