package pro.sky.course02.services;

import pro.sky.course02.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
