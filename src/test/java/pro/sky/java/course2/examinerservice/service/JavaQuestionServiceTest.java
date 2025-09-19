package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.EmptyQuestionsException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
    }

    @Test
    void add_shouldAddQuestionAndReturnIt() {
        String questionText = "Почему небо голубое?";
        String answerText = "Структура атмосферы.";

        Question result = questionService.add(questionText, answerText);

        assertNotNull(result);
        assertEquals(questionText, result.getQuestion());
        assertEquals(answerText, result.getAnswer());
        assertTrue(questionService.getAll().contains(result));
    }

    @Test
    void add_shouldNotAddDuplicateQuestions() {
        Question question = new Question("Что такое массив?",
            "Структура данных.");
        questionService.add(question);

        questionService.add(question);

        assertEquals(1, questionService.getAll().size());
    }

    @Test
    void remove_shouldRemoveExistingQuestion() {
        Question question = new Question("Что такое Spring?",
            "Фреймворк.");
        questionService.add(question);
        assertTrue(questionService.getAll().contains(question));

        Question removed = questionService.remove(question);

        assertEquals(question, removed);
        assertFalse(questionService.getAll().contains(question));
        assertTrue(questionService.getAll().isEmpty());
    }

    @Test
    void getAll_shouldReturnAllAddedQuestions() {
        Question question1 = new Question("Question 1",
            "Answer 1");
        Question question2 = new Question("Question 2",
            "Answer 2");
        questionService.add(question1);
        questionService.add(question2);

        Collection<Question> allQuestions = questionService.getAll();

        assertNotNull(allQuestions);
        assertEquals(2,
            allQuestions.size());
        assertTrue(allQuestions.contains(question1));
        assertTrue(allQuestions.contains(question2));
    }

    @Test
    void getRandomQuestion_shouldThrowException_whenQuestionListIsEmpty() {
        assertThrows(EmptyQuestionsException.class, () -> questionService.getRandomQuestion());
    }

    @Test
    void getRandomQuestion_shouldReturnAQuestionFromList_whenListIsNotEmpty() {
        Question question1 = new Question("Question 1",
            "Answer 1");
        Question question2 = new Question("Question 2",
            "Answer 2");
        questionService.add(question1);
        questionService.add(question2);

        Question randomQuestion = questionService.getRandomQuestion();

        assertNotNull(randomQuestion);
        assertTrue(questionService.getAll().contains(randomQuestion));
    }
}