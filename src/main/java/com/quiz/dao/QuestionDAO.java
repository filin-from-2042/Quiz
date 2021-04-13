package com.quiz.dao;

import com.opencsv.exceptions.CsvException;
import com.quiz.entity.Question;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface QuestionDAO {
    List<Question> getAll() throws FileNotFoundException, IOException, CsvException;
}
