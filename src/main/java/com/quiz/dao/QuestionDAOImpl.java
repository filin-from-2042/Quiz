package com.quiz.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.quiz.entity.Answer;
import com.quiz.entity.Question;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

//        ClassPathResource resource = new ClassPathResource(fileName);
//        File file = resource.getFile();

        try(CSVReader reader = new CSVReader(new FileReader(file)))
        {
            List<String[]> rows = reader.readAll();
            for(String[] row : rows)
            {
                Question question = new Question();
                question.setQuestion(row[0]);
                for(int i = 1; i< row.length; i++)
                {
                    Answer answer = new Answer();
                    answer.setAnswer(row[i]);
                    question.addAnswer(answer);
                }
                questions.add(question);
            }
        }


        return questions;
    }
}
