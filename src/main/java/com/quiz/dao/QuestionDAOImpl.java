package com.quiz.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.quiz.entity.Answer;
import com.quiz.entity.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuestionDAOImpl implements QuestionDAO, ResourceLoaderAware {

    private String fileName;
    private ResourceLoader resourceLoader;
    public void setResourceLoader(ResourceLoader loader)
    {
        this.resourceLoader = loader;
    }

    public QuestionDAOImpl(String fileName)
    {
        this.fileName = fileName;
    }

    public List<Question> getAll() throws IOException, CsvException
    {
        List<Question> questions = new ArrayList<>();

        File file  = resourceLoader.getResource(fileName).getFile();

        try(CSVReader reader = new CSVReader(new FileReader(file)))
        {
            List<String[]> rows = reader.readAll();
            for(String[] row : rows)
            {
                String[] questionData = row[0].split(";");

                Question question = new Question();
                question.setQuestion(questionData[0]);

                List<String> rightAnswers = Arrays.asList(questionData[1].split("-"));

                for(int i = 1; i< row.length; i++)
                {
                    Answer answer = new Answer();
                    answer.setAnswer(row[i]);
                    question.addAnswer(answer);
                    if(rightAnswers.contains(String.valueOf(i))) question.addRightAnswer(answer);
                }
                questions.add(question);
            }
        }

        return questions;
    }
}
