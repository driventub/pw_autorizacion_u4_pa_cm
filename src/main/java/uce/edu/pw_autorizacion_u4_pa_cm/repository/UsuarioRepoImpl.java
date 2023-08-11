package uce.edu.pw_autorizacion_u4_pa_cm.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.pw_autorizacion_u4_pa_cm.repository.model.Usuario;

@Repository
@Transactional
public class UsuarioRepoImpl implements IUsuarioRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario consultarPorUsername(String username) {
        TypedQuery<Usuario> myQuery = this.em
                .createQuery("SELECT u FROM Usuario u WHERE u.username =:username", Usuario.class);
        myQuery.setParameter("username", username);
        return myQuery.getSingleResult();
    }

}
