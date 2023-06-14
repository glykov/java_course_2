package pro.sky.course02.services;

import org.springframework.stereotype.Service;
import pro.sky.course02.domain.Question;
import pro.sky.course02.exceptions.OversizeException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getSize()) {
            throw new OversizeException();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
