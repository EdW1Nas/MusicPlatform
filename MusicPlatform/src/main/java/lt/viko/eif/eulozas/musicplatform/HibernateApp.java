package lt.viko.eif.eulozas.musicplatform;


import lt.viko.eif.eulozas.musicplatform.model.Album;
import lt.viko.eif.eulozas.musicplatform.model.Artist;
import lt.viko.eif.eulozas.musicplatform.model.Song;
import lt.viko.eif.eulozas.musicplatform.util.HibernateUtil;
import lt.viko.eif.eulozas.musicplatform.util.JaxbUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args){
        Artist theWeeknd = new Artist("The Weeknd", "Canada", 1990);
        Song allIKnow = new Song("All I Know",2016, "Pop", 312);
        Song sideWalks = new Song("Sidewalks",2016, "Pop", 210);
        Album starBoy = new Album ("StarBoy", 2016, theWeeknd , List.of(allIKnow, sideWalks));

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(starBoy);
            transaction.commit();
        }catch(Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Album> albums = session.createQuery( "from Album", Album.class).list();
           albums.forEach(alb -> System.out.println(alb));
            System.out.println("--------------------");
            albums.forEach(alb -> JaxbUtil.convertToXML(alb));

            System.in.read();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

        }
    }

}
