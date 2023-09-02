package uce.edu.pw_autorizacion_u4_pa_cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.pw_autorizacion_u4_pa_cm.security.JwtUtils;
import uce.edu.pw_autorizacion_u4_pa_cm.service.to.UsuarioTO;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenControllerRestful {

    // @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public void insertar(@RequestBody Usuario usuario){

    // }

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/obtener")
    // puse la semilla y tiempo en el usuarioTO 
    public String obtenertoken(@RequestBody UsuarioTO usuario) {
        this.authenticated(usuario.getUsername(), usuario.getPassword());
        return this.jwtUtils.generateJWTToken(usuario.getUsername(), usuario.getSemilla(), usuario.getTiempoExpiracion());
        // return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.Plxpieozy08GbnlTLdPQqxbFduwc8QW2nIDrcRKgpUk";
    }

    private void authenticated(String usuario, String password){
        Authentication authentication =  this.authManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }



}