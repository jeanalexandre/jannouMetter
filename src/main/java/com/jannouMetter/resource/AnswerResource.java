package com.jannouMetter.resource;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.service.AnswerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerResource {

    private AnswerService answerService;

    public AnswerResource(AnswerService answerService) {
        this.answerService = answerService;
    }

    public List<Answer> getAllAnswers() {
        return this.answerService.getAll();
    }
}
