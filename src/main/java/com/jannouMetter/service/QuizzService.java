package com.jannouMetter.service;

import com.jannouMetter.bo.Quizz;
import com.jannouMetter.dao.QuizzRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzService {

    private QuizzRepository quizzRepository;

    public QuizzService(QuizzRepository quizzRepository) {
        this.quizzRepository = quizzRepository;
    }

    public List<Quizz> getAll() {
        return this.quizzRepository.findAll();
    }

    public Optional<Quizz> getById(Long id) {
        return this.quizzRepository.findById(id);
    }

    public Quizz create(Quizz quizz) {
        return this.quizzRepository.save(quizz);
    }
}
