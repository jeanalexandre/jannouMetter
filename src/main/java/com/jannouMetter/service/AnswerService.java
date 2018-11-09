package com.jannouMetter.service;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.dao.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }
}
