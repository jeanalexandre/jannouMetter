package com.jannouMetter.resource;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.bo.Ask;
import com.jannouMetter.service.AskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asks")
public class AskResource {

    private AskService askService;

    public AskResource(AskService askService) {
        this.askService = askService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Ask>> getAllAsk() {
        return new ResponseEntity<>(this.askService.getAll(), HttpStatus.OK
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Ask> getAskById(@PathVariable("id") Long id) {
        return this.askService.getById(id)
                .map( response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/{id}/answers", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Ask> addAnswer(@RequestBody Answer answer, @PathVariable("id") Long id) {
        return this.askService.getById(id)
                .map(response -> ResponseEntity.ok().body(this.askService.addAnswer(response, answer)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
