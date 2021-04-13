package com.quiz.service;

import com.opencsv.exceptions.CsvException;
import com.quiz.dao.QuestionDAO;
import com.quiz.entity.Question;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    QuestionDAO dao;
    public QuestionServiceImpl(QuestionDAO dao)
    {
        this.dao = dao;
    }
    public List<Question> getAll() throws FileNotFoundException, IOException, CsvException {
        return dao.getAll();
    }
}
