package com.jannouMetter.resource;

import com.jannouMetter.bo.Ask;
import com.jannouMetter.bo.Quizz;
import com.jannouMetter.service.QuizzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizz")
@Api(value = "Quizz", description = "Quizz")
public class QuizzResource {

    private final QuizzService quizzService;

    public QuizzResource(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return all Quizz")
    public ResponseEntity<List<Quizz>> getAllQuizz() {
        return new ResponseEntity<>(this.quizzService.getAll(), HttpStatus.OK
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return a Quizz")
    public ResponseEntity<Quizz> getQuizzById(@PathVariable("id") Long id) {
        return this.quizzService.getById(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Create a Quizz")
    public ResponseEntity<Quizz> createQuizz(@RequestBody Quizz quizz) {
        return new ResponseEntity<>(this.quizzService.create(quizz), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}/subscribe", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Subscribe to quiz")
    public ResponseEntity<Quizz> subscribe(@PathVariable("id") Long id) {
        return this.quizzService.getById(id)
                .map(response -> ResponseEntity.ok().body(this.quizzService.subscribe(response)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/{id}/unsubscribe", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Unsubscribe to quiz")
    public ResponseEntity<Quizz> unsubscribe(@PathVariable("id") Long id) {
        return this.quizzService.getById(id)
                .map(response -> ResponseEntity.ok().body(this.quizzService.unsubscribe(response)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/{id}/asks", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Add a Quizz question")
    public ResponseEntity<Quizz> addAsks(@RequestBody Ask ask, @PathVariable("id") Long id) {
        return this.quizzService.getById(id)
                .map(response -> ResponseEntity.ok().body(this.quizzService.addAsk(response, ask)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/{id}/next", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Go to the next step of the quiz")
    public ResponseEntity<Quizz> next(@PathVariable("id") Long id) {
        return this.quizzService.getById(id)
                .map(response -> ResponseEntity.ok().body(this.quizzService.next(response)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/reset", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Reset the application with initial quizz")
    public ResponseEntity<Quizz> resetQuizz() {
        return new ResponseEntity<>(this.quizzService.reset(), HttpStatus.OK);
    }
}
