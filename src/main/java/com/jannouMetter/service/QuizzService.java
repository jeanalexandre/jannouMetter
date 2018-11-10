package com.jannouMetter.service;

import com.jannouMetter.bo.Ask;
import com.jannouMetter.bo.Quizz;
import com.jannouMetter.dao.AskRepository;
import com.jannouMetter.dao.QuizzRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzService {

    private QuizzRepository quizzRepository;
    private AskRepository askRepository;

    public QuizzService(QuizzRepository quizzRepository, AskRepository askRepository) {
        this.quizzRepository = quizzRepository;
        this.askRepository = askRepository;
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

    public Quizz addAsk(Quizz quizz, Ask ask) {
        ask.setQuizz(quizz);
        askRepository.save(ask);
        return quizz;
    }
}
