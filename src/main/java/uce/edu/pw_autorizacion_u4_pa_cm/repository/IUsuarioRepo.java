package uce.edu.pw_autorizacion_u4_pa_cm.repository;

import uce.edu.pw_autorizacion_u4_pa_cm.repository.model.Usuario;

public interface IUsuarioRepo {
    public Usuario consultarPorUsername(String username);
}
