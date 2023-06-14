package pro.sky.course02.services;

import org.springframework.stereotype.Service;
import pro.sky.course02.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random rand = new Random();
        int questionNumber = rand.nextInt(questions.size());
        Iterator<Question> it = questions.iterator();
        for (int i = 0; i < questionNumber; i++) {
            it.next();
        }
        return it.next();
    }

    @Override
    public int getSize() {
        return questions.size();
    }
}
