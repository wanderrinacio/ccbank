package dao;

import domain.Cidade;
import domain.Pessoa;
import domain.Usuario;
import java.util.List;
import org.hibernate.Session;
import utils.HibernateUtil;

public class PessoaDao {

    private final Session session;
    
    public PessoaDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
     

    public List<Pessoa> findAll(){
        session.beginTransaction();
        try{
            List<Pessoa> pessoas = session.createQuery("from Pessoa order by id").list();
            session.getTransaction().commit();
            return pessoas;
        }catch(Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }

    public Pessoa findById(Integer id){
        session.beginTransaction();
        try{
            Pessoa pessoa = (Pessoa)session.createQuery("from Pessoa where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return pessoa;
        }catch(Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public List<Pessoa> findByUsuario(Usuario usuario) {
        session.beginTransaction();
        try{
        List<Pessoa> pessoas = session.createQuery("from Pessoa p where p.usuarioId = " + usuario.getId()).list();
            session.getTransaction().commit();
            return pessoas;
        }catch(Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean insert(Pessoa pessoa){
        session.beginTransaction();
        try{
            session.save(pessoa);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean update(Pessoa pessoa){
        session.beginTransaction();
        try{
            session.update(pessoa);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(Pessoa pessoa){
        session.beginTransaction();
        try{
            session.delete(pessoa);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }
}
