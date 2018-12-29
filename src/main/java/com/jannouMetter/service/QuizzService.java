package com.jannouMetter.service;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.bo.Ask;
import com.jannouMetter.bo.Quizz;
import com.jannouMetter.dao.AskRepository;
import com.jannouMetter.dao.QuizzRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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

    /**
     * Permet de supprimer les quiz existants et de réinitialiser le quizz initial
     *
     * @return
     */
    public Quizz reset() {
        quizzRepository.deleteAll();

        Quizz quizz = new Quizz();
        quizz.setName("MENTI QUIZZ");
        List<Ask> asks = new ArrayList<>();
        asks.add(this.createYesOrNoAsk(quizz, "Croyez-vous qu’il sera possible un jour de connaître l’avenir, de modifier le passé ?"));
        asks.add(this.createYesOrNoAsk(quizz, "Voudriez-vous un jour voyager à travers une faille temporelle et retourner à l’époque où le LOSC était en Ligue 1 ? "));
        asks.add(this.createOneOfChoiceAsk(quizz, "Quel prix seriez-vous prêt à débourser pour discuter avec vos ancêtres ?", Arrays.asList("10[bitcoin]", "100[bitcoin]", "1000[bitcoin]")));
        asks.add(this.createOneOfChoiceAsk(quizz, "Quelle est la raison principale pour laquelle ce genre de technologie doit voir le jour ?", Arrays.asList("Innovation", "Gagner la guerre", "Gagner au loto", "Connaitre son avenir", "Corriger le passé")));
        asks.add(this.createFreeStringAsk(quizz, "Donner le mot qui résume pour vous cette technologie."));
        quizz.setAsks(asks);
        quizzRepository.save(quizz);
        return quizz;
    }

    private Ask createYesOrNoAsk(Quizz quizz, String entitled) {
        Ask ask = new Ask();
        ask.setEntitled(entitled);
        ask.setType("YesOrNo");
        ask.setTotal_polling(0);
        ask.setQuizz(quizz);
        List<Answer> answers = new ArrayList<>();
        answers.add(this.createAnswer(ask, "OUI"));
        answers.add(this.createAnswer(ask, "NON"));
        ask.setAnswers(answers);
        return ask;
    }

    private Ask createOneOfChoiceAsk(Quizz quizz, String entitled, List<String> choices) {
        Ask ask = new Ask();
        ask.setQuizz(quizz);
        ask.setEntitled(entitled);
        ask.setType("OneOfChoice");
        ask.setTotal_polling(0);
        List<Answer> answers = new ArrayList<>();
        choices.forEach(choice -> {
            answers.add(this.createAnswer(ask, choice));
        });
        ask.setAnswers(answers);
        return ask;
    }

    private Ask createFreeStringAsk(Quizz quizz, String entitled) {
        Ask ask = new Ask();
        ask.setQuizz(quizz);
        ask.setType("FreeString");
        ask.setEntitled(entitled);
        ask.setTotal_polling(0);
        return ask;
    }

    private Answer createAnswer(Ask ask, String entitled) {
        Answer answer = new Answer();
        answer.setAsk(ask);
        answer.setEntitled(entitled);
        answer.setPolling(0);
        return answer;
    }
}
