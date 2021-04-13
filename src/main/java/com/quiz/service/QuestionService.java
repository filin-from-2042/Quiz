package com.quiz.service;

import com.opencsv.exceptions.CsvException;
import com.quiz.entity.Question;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface QuestionService {
    List<Question> getAll() throws FileNotFoundException, IOException, CsvException;
}
