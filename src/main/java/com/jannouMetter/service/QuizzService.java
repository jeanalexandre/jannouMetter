package com.jannouMetter.service;

import com.jannouMetter.bo.Quizz;
import com.jannouMetter.dao.QuizzRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizzService {

    private QuizzRepository quizzRepository;

    public QuizzService(QuizzRepository quizzRepository) {
        this.quizzRepository = quizzRepository;
    }

    public List<Quizz> getAll() {
        return this.quizzRepository.findAll();
    }
}
