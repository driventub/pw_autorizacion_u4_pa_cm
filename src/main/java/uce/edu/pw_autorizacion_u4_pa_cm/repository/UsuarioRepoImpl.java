package uce.edu.pw_autorizacion_u4_pa_cm.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
