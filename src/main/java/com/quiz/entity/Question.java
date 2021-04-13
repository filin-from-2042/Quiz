package com.quiz.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private List<Answer> answers = new ArrayList<>();

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getQuestion(){
        return question;
    }

    public void setAnswer(String answer)
    {
        this.answers = answers;
    }

    public List<Answer> getAnswers()
    {
        return this.answers;
    }

    public void addAnswer(Answer answer)
    {
        this.answers.add(answer);
    }
}
