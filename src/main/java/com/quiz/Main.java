package com.quiz;

import com.quiz.dao.QuestionDAO;
import com.quiz.dao.QuestionDAOImpl;
import com.quiz.service.QuestionService;
import com.quiz.service.QuestionServiceImpl;
import com.quiz.ui.Quiz;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
public class Main {

    @Value("${url}")
    private String url;

    @Bean
    public QuestionDAO questionDAO()
    {
        return new QuestionDAOImpl(url);
    }

    @Bean
    public QuestionService questionService(QuestionDAO dao)
    {
        return new QuestionServiceImpl(dao);
    }

    @Bean
    public Quiz quiz(QuestionService questionService)
    {
        return new Quiz(questionService);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Quiz quiz = context.getBean(Quiz.class);
        quiz.start();
    }
}
