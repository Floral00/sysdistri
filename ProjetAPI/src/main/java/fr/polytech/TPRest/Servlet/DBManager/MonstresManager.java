package fr.polytech.TPRest.Servlet.DBManager;
import fr.polytech.TPRest.Servlet.Monstres;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import java.util.List;
import static fr.polytech.TPRest.Servlet.DBManager.HibernateFactory.getSession;

public class MonstresManager {
    /**
     * Permet de récupérer tous les magasins
     *
     * @return liste de tous les magasins
     */
    public Monstres create(Monstres monstres) {
        Session session = getSession();
        session.beginTransaction();
        session.save(monstres.getType());
        session.getTransaction().commit();
        if(monstres.getGeneration().getId() == 0){
            session.beginTransaction();
            session.save(monstres.getGeneration());
            session.getTransaction().commit();
        }
        session.beginTransaction();
        session.save(monstres);
        session.getTransaction().commit();
        return monstres;
    }

    public Monstres update(Monstres monstres) {
        Session session = getSession();
        session.beginTransaction();
        session.update(monstres);
        session.getTransaction().commit();
        Query query = session.createQuery("select monstres from Monstres as monstres where monstres.id =:id");
        query.setParameter("id", monstres.getId());
        return (Monstres) query.getSingleResult();
    }

    public List<Monstres> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select monstres from Monstres as monstres");
        return query.getResultList();
    }

    public Response delete(Monstres monstres) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(monstres);
        session.getTransaction().commit();
        return Response.ok().build();
    }
}