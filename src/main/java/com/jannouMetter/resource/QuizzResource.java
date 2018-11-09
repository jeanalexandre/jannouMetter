package com.jannouMetter.resource;

import com.jannouMetter.bo.Quizz;
import com.jannouMetter.service.QuizzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/quizz")
public class QuizzResource {

    private final QuizzService quizzService;

    public QuizzResource(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Quizz>> getAllQuizz() {
        return new ResponseEntity<>(this.quizzService.getAll(), HttpStatus.OK
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Quizz> getQuizzById(@PathVariable("id") Long id) {
        return this.quizzService.getById(id)
                .map( response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Quizz> createQuizz(@RequestBody Quizz quizz) {
        return new ResponseEntity<>( this.quizzService.create(quizz), HttpStatus.CREATED);
    }
}
