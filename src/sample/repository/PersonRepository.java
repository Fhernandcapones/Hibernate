package sample.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sample.model.PersonModel;
import sample.service.PersonService;
import sample.util.Database;

public class PersonRepository implements PersonService {
    private static SessionFactory sessionFactory;
    private Transaction transaction;
    private Session session;

    public PersonRepository(){
        //tatawagin mo dito si util
        this.sessionFactory = Database.getSessionFactory();
    }
@Override
    public void savePerson(PersonModel person){
        session = sessionFactory.openSession();

        try{
            transaction = session.beginTransaction();

            session.save(person);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }

    }



    }



