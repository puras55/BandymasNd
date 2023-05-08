import Data.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AnswerDao {

    private final SessionFactory sessionFactory;

    public AnswerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Answer answer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(answer);
            session.getTransaction().commit();
        }
    }

    public Answer read(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Answer.class, id);
        }
    }

    public void update(Answer answer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(answer);
            session.getTransaction().commit();
        }
    }

    public void delete(Answer answer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(answer);
        }
    }
}

