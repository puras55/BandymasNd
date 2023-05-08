import Data.Questions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QuestionDao {

    private final SessionFactory sessionFactory;

    public QuestionDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Questions question) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(question);
            session.getTransaction().commit();
        }
    }

    public Questions read(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Questions.class, id);
        }
    }

    public void update(Questions question) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(question);
            session.getTransaction().commit();
        }
    }

    public void delete(Questions question) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(question);
            session.getTransaction().commit();
        }
    }

    public List<Questions> list() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Questions", Questions.class).list();
        }
    }

    // Čia galite pridėti papildomus metodus, kad rastumėte klausimus pagal tam tikrus kriterijus
}
