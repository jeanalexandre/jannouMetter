package com.jannouMetter.service;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.dao.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }

    public Optional<Answer> getById(Long id) {
        return this.answerRepository.findById(id);
    }
}
