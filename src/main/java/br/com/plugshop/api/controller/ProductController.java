package br.com.plugshop.api.controller;

import br.com.plugshop.api.entity.Product;
import br.com.plugshop.api.repository.ProductRepository;
import com.sun.corba.se.impl.protocol.RequestCanceledException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository _ProductRepository;

    @RequestMapping(value = "/usuario/meus-produtos/cadastra-produto", method = RequestMethod.POST)
    public Object Post(@Valid @RequestBody Product product){
        try{
            return _ProductRepository.save(product);
        }catch (RequestCanceledException e){
            return e.getCause();
        }
    }

    @RequestMapping(value = "/produtos/{tipo}", method = RequestMethod.GET)
    public ResponseEntity<Product> getByEntity(@PathVariable (value = "type")long type){
        Optional<Product> product = _ProductRepository.findById(type);
        //valida retorno do banco
        if(product.isPresent()){
            return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/usuario/meus-produtos/remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id")long id){
        Optional<Product> product = _ProductRepository.findById(id);
        if(product.isPresent()) {
            _ProductRepository.delete(product.get());
            return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao foi possivel encontrar esse produto.");
        }
    }
}
