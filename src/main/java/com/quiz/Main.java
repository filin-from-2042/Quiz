package com.quiz;

import com.opencsv.exceptions.CsvException;
import com.quiz.dao.QuestionDAO;
import com.quiz.dao.QuestionDAOImpl;
import com.quiz.service.QuestionService;
import com.quiz.ui.Quiz;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static final Log logger = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Quiz quiz = context.getBean(Quiz.class);
        quiz.start();
    }
}
