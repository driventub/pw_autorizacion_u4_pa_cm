package uce.edu.pw_autorizacion_u4_pa_cm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.pw_autorizacion_u4_pa_cm.service.to.UsuarioTO;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenControllerRestful {

    // @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public void insertar(@RequestBody Usuario usuario){

    // }

    @GetMapping
    public String obtenertoken(@RequestBody UsuarioTO usuario) {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.Plxpieozy08GbnlTLdPQqxbFduwc8QW2nIDrcRKgpUk";
    }

}