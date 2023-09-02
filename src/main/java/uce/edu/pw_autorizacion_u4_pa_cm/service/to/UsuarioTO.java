package uce.edu.pw_autorizacion_u4_pa_cm.service.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String semilla;
    private Integer tiempoExpiracion;

    

    public UsuarioTO(String username, String password, String semilla, Integer tiempoExpiracion) {
        this.username = username;
        this.password = password;
        this.semilla = semilla;
        this.tiempoExpiracion = tiempoExpiracion;
    }

    public String getSemilla() {
        return semilla;
    }

    public void setSemilla(String semilla) {
        this.semilla = semilla;
    }

    public Integer getTiempoExpiracion() {
        return tiempoExpiracion;
    }

    public void setTiempoExpiracion(Integer tiempoExpiracion) {
        this.tiempoExpiracion = tiempoExpiracion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
