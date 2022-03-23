package dao;

import domain.Cidade;
import java.util.List;
import org.hibernate.Session;
import utils.HibernateUtil;

public class CidadeDao {

    private final Session session;
    
    public CidadeDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
     

    public List<Cidade> findAll(){
        session.beginTransaction();
        try{
            List<Cidade> cidades = session.createQuery("from Cidade order by nome").list();
            session.getTransaction().commit();
            return cidades;
        }catch(Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }

    public Cidade findById(Integer id){
        session.beginTransaction();
        try{
            Cidade cidade = (Cidade)session.createQuery("from Cidade where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return cidade;
        }catch(Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean insert(Cidade cidade){
        session.beginTransaction();
        try{
            session.save(cidade);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean update(Cidade cidade){
        session.beginTransaction();
        try{
            session.update(cidade);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(Cidade cidade){
        session.beginTransaction();
        try{
            session.delete(cidade);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
    }
}
