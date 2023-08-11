package uce.edu.pw_autorizacion_u4_pa_cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uce.edu.pw_autorizacion_u4_pa_cm.repository.IUsuarioRepo;
import uce.edu.pw_autorizacion_u4_pa_cm.repository.model.Usuario;

import static java.util.Collections.emptyList;;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepo.consultarPorUsername(username);
        return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
    }

}