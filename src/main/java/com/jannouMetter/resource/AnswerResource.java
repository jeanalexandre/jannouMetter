package com.jannouMetter.resource;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.service.AnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@Api(value = "Answers", description = "Answers")
public class AnswerResource {

    private AnswerService answerService;

    public AnswerResource(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return all Answers")
    public ResponseEntity<List<Answer>> getAllAnswer() {
        return new ResponseEntity<>(this.answerService.getAll(), HttpStatus.OK
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return an Answer")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Long id) {
        return this.answerService.getById(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
