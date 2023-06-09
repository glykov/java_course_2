package pro.sky.course02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course02.domain.Question;
import pro.sky.course02.exceptions.OversizeException;
import pro.sky.course02.services.ExaminerServiceImpl;
import pro.sky.course02.services.JavaQuestionService;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExamServiceImplTests {
    private List<Question> list = List.of(
            new Question("question 1", "answer 1"),
            new Question("question 2", "answer 2"),
            new Question("question 3", "answer 3"),
            new Question("question 4", "answer 4")
    );

    @Mock
    private JavaQuestionService serviceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    public void getQuestionsPositiveTest() {
        when(serviceMock.getRandomQuestion())
                .thenReturn(
                        new Question("question 1", "answer 1"),
                        new Question("question 3", "answer 3"),
                        new Question("question 4", "answer 4")

                );

        when(serviceMock.getSize()).thenReturn(list.size());

        assertThat(out.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("question 1", "answer 1"),
                        new Question("question 3", "answer 3"),
                        new Question("question 4", "answer 4")
                );
    }

    @Test
    public void getQuestionsNegativeTest() {
        when(serviceMock.getSize())
                .thenReturn(list.size());

        assertThrows(OversizeException.class, () -> out.getQuestions(list.size() + 1));
    }

}
