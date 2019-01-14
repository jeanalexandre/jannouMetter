package com.jannouMetter.service;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.bo.Ask;
import com.jannouMetter.dao.AnswerRepository;
import com.jannouMetter.dao.AskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AskService {

    private AskRepository askRepository;
    private AnswerRepository answerRepository;

    public AskService(AskRepository askRepository, AnswerRepository answerRepository) {
        this.answerRepository =answerRepository;
        this.askRepository = askRepository;
    }

    public List<Ask> getAll() {
        return this.askRepository.findAll();
    }

    public Optional<Ask> getById(Long id) {
        return this.askRepository.findById(id);
    }

    public Ask addAnswer(Ask ask, Answer answer) {
        answer.setAsk(ask);
        answerRepository.save(answer);
        return ask;
    }

    public Ask poll(Ask ask, Long idAnswer) {
        if (this.answerRepository.findById(idAnswer).isPresent()) {
            this.answerRepository.findById(idAnswer).get().addPolling();
            int askPolling = ask.addPolling();
            if (askPolling == ask.getQuizz().getNbContributors()) {
                ask.setStateDone();
            }
            askRepository.save(ask);
            return ask;
        }
        return null;
    }

    public Ask pollFreeString(Ask ask, String value) {
        Answer answer = new Answer();
        answer.setEntitled(value);
        answer.setAsk(ask);
        answer.setPolling(1);
        int askPolling = ask.addPolling();
        if (askPolling == ask.getQuizz().getNbContributors()) {
            ask.setStateDone();
        }
        answerRepository.save(answer);
        return ask;
    }

    public Ask setDone(Ask ask) {
        ask.setStateDone();
        return askRepository.save(ask);
    }
}
