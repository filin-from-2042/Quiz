package com.quiz.ui;

import com.opencsv.exceptions.CsvException;
import com.quiz.dao.QuestionDAO;
import com.quiz.entity.Answer;
import com.quiz.entity.Question;
import com.quiz.service.QuestionService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Quiz {
    QuestionService service;

    public Quiz(QuestionService service)
    {
        this.service = service;
    }

    public void start()
    {
        try {
            Map<String,String> userAnswers = new TreeMap<>();
            Scanner scanner = new Scanner(System.in);
            List<Question> questions = service.getAll();
            for(Question question : questions)
            {
                System.out.println(question.getQuestion());
                List<Answer> answers = question.getAnswers();
                for (int i = 1; i<=answers.size(); i++)
                {
                    System.out.printf("%d. %s\n",i,answers.get(i-1).getAnswer());
                }
                String userAnswer = scanner.nextLine();
                userAnswers.put(question.getQuestion(), userAnswer);
            }
            System.out.println(userAnswers);
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File not found!");
        }
        catch(IOException exception)
        {
            System.out.println("Opening file problem");
        }
        catch (CsvException exception )
        {
            System.out.println("Reading csv file exception");
        }
    }
}
