package pro.sky.course02;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.course02.domain.Question;
import pro.sky.course02.services.JavaQuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class JavaQuestionServiceTests {
	JavaQuestionService out;

	@BeforeEach
	public void makeTestSet() {
		out = new JavaQuestionService();
		out.add(new Question("question 1", "answer 1"));
		out.add(new Question("question 2", "answer 2"));
		out.add(new Question("question 3", "answer 3"));
		out.add(new Question("question 4", "answer 4"));
	}

	@AfterEach
	public void clearTestSet() {
		Collection<Question> questions = out.getAll();
		for (Question q : questions) {
			out.remove(q);
		}
	}

	@Test
	public void addTwoStringsPositiveTest() {
		String q = "question 5";
		String a = "answer 5";
		int size = out.getSize();
		Question question = new Question(q, a);
		assertEquals(question, out.add(q, a));
		assertEquals(size + 1, out.getSize());
	}

	@Test
	public void addTwoStringsNegativeTest() {
		String q = "question 4";
		String a = "answer 4";
		int size = out.getSize();
		Question question = new Question(q, a);
		assertEquals(question, out.add(q, a));
		assertEquals(size, out.getSize());
	}

	@Test
	public void addQuestionPositiveTest() {
		int size = out.getSize();
		Question question = new Question("question 5", "answer 5");
		assertEquals(question, out.add(question));
		assertEquals(size + 1, out.getSize());
	}

	@Test
	public void addQuestionNegativeTest() {
		int size = out.getSize();
		Question question = new Question("question 4", "answer 4");
		assertEquals(question, out.add(question));
		assertEquals(size, out.getSize());
	}

	@Test
	public void removeQuestionPositiveTest() {
		int size = out.getSize();
		Question question = new Question("question 4", "answer 4");
		assertEquals(question, out.remove(question));
		assertEquals(size - 1, out.getSize());
	}

	@Test
	public void removeQuestionNegativeTest() {
		int size = out.getSize();
		Question question = new Question("question 5", "answer 5");
		assertEquals(question, out.remove(question));
		assertEquals(size, out.getSize());
	}

	@Test
	public void getAllTest() {
		Set<Question> test = new HashSet<>();
		test.add(new Question("question 1", "answer 1"));
		test.add(new Question("question 2", "answer 2"));
		test.add(new Question("question 3", "answer 3"));
		test.add(new Question("question 4", "answer 4"));
		assertIterableEquals(test, out.getAll());
	}
}
