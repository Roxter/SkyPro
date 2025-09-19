package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.InvalidQuestionAmountException;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private final List<Question> MOCK_QUESTIONS = List.of(
        new Question("Question 1",
            "Answer 1"),
        new Question("Question 2",
            "Answer 2"),
        new Question("Question 3",
            "Answer 3"),
        new Question("Question 4",
            "Answer 4")
    );
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions_shouldReturnCorrectAmountOfUniqueQuestions() {
        int amountToRequest = 2;
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion())
            .thenReturn(MOCK_QUESTIONS.get(0))
            .thenReturn(MOCK_QUESTIONS.get(1));

        Collection<Question> result = examinerService.getQuestions(amountToRequest);

        assertNotNull(result);
        assertEquals(amountToRequest, result.size());
        assertTrue(result.containsAll(
            Set.of(MOCK_QUESTIONS.get(0),
                MOCK_QUESTIONS.get(1))
        ));
    }

    @Test
    void getQuestions_shouldHandleDuplicateRandomsAndReturnUniqueQuestions() {
        int amountToRequest = 2;
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion())
            .thenReturn(MOCK_QUESTIONS.get(0))
            .thenReturn(MOCK_QUESTIONS.get(0))
            .thenReturn(MOCK_QUESTIONS.get(2));

        Collection<Question> result = examinerService.getQuestions(amountToRequest);

        assertNotNull(result);
        assertEquals(amountToRequest, result.size());
        assertTrue(result.containsAll(Set.of(MOCK_QUESTIONS.get(0), MOCK_QUESTIONS.get(2))));
    }

    @Test
    void getQuestions_shouldThrowException_whenAmountIsGreaterThanTotal() {
        int amountToRequest = MOCK_QUESTIONS.size() + 1;
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);

        assertThrows(InvalidQuestionAmountException.class,
            () -> examinerService.getQuestions(amountToRequest)
        );
    }

    @Test
    void getQuestions_shouldThrowException_whenAmountIsNegative() {
        int amountToRequest = -1;
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);

        assertThrows(InvalidQuestionAmountException.class,
            () -> examinerService.getQuestions(amountToRequest)
        );
    }
}