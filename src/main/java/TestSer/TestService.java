package TestSer;

import Data.Questions;

public class TestService {

    private final QuestionDao questionDao;
    private final Answer answerDao;
    private final TestResultDao testResultDao;

    public TestService(QuestionDao questionDao, AnswerDao answerDao, TestResultDao testResultDao) {
        this.questionDao = questionDao;
        this.answerDao = answerDao;
        this.testResultDao = testResultDao;
    }

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Answer> getAnswersForQuestion(Question question) {
        return answerDao.findByQuestion(question);
    }

    public TestResult submitTest(User user, Map<Question, Answer> userAnswers) {
        int correctAnswers = (int) userAnswers.entrySet().stream()
                .filter(entry -> entry.getKey().getCorrectAnswer().equals(entry.getValue()))
                .count();
        TestResult result = new TestResult(user, correctAnswers, LocalDateTime.now());
        testResultDao.save(result);
        return result;
    }

    public List<TestResult> getUserResults(User user) {
        return testResultDao.findByUser(user);
    }

    public double getAverageScore() {
        return testResultDao.getAverageScore();
    }

    public int getTestCount() {
        return testResultDao.count();
    }

    public void createQuestion(String questionText, List<String> answerTexts, int correctAnswerIndex) {
        Question question = new Question(questionText);
        questionDao.save(question);

        for (int i = 0; i < answerTexts.size(); i++) {
            Answer answer = new Answer(answerTexts.get(i), question);
            if (i == correctAnswerIndex) {
                question.setCorrectAnswer(answer);
            }
            answerDao.save(answer);
        }

        questionDao.update(question);
    }

    public void updateQuestion(Question question, String questionText, List<String> answerTexts, int correctAnswerIndex) {
        question.setText(questionText);
        questionDao.update(question);

        List<Answer> answers = answerDao.findByQuestion(question);
        for (int i = 0; i < answerTexts.size(); i++) {
            Answer answer = answers.get(i);
            answer.setText(answerTexts.get(i));
            if (i == correctAnswerIndex) {
                question.setCorrectAnswer(answer);
            }
            answerDao.update(answer);
        }

        questionDao.update(question);
    }

    public void deleteQuestion(Question question) {
        questionDao.delete(question);
    }
}
