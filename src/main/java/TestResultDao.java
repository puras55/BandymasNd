import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestResultDao {

    private final SessionFactory sessionFactory;

    public TestResultDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Čia yra likusių CRUD operacijų metodai

    public double getAverageScore() {
        try (Session session = sessionFactory.openSession()) {
            Double average = (Double) session.createQuery("select avg(score) from TestResult").uniqueResult();
            return average != null ? average : 0;
        }
    }
}
