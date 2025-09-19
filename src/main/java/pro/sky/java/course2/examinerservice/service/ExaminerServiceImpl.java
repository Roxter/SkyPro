package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.InvalidQuestionAmountException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int totalQuestions = questionService.getAll().size();

        if (amount <= 0 || amount > totalQuestions) {
            throw new InvalidQuestionAmountException(totalQuestions);
        }

        Set<Question> examQuestions = new HashSet<>();
        while (examQuestions.size() < amount) {
            examQuestions.add(questionService.getRandomQuestion());
        }

        return examQuestions;
    }
}