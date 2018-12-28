package com.jannouMetter.resource;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.bo.Ask;
import com.jannouMetter.service.AskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asks")
@Api(value = "Asks", description = "Asks")
public class AskResource {

    private AskService askService;

    public AskResource(AskService askService) {
        this.askService = askService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return all Asks")
    public ResponseEntity<List<Ask>> getAllAsk() {
        return new ResponseEntity<>(this.askService.getAll(), HttpStatus.OK
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return an Ask")
    public ResponseEntity<Ask> getAskById(@PathVariable("id") Long id) {
        return this.askService.getById(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/{id}/answers", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Add a question answer")
    public ResponseEntity<Ask> addAnswer(@RequestBody Answer answer, @PathVariable("id") Long id) {
        return this.askService.getById(id)
                .map(response -> ResponseEntity.ok().body(this.askService.addAnswer(response, answer)))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @RequestMapping(path = "/{id}/poll/{idAnswer}", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Poll YesOrNot and OneOfChoice types of asks")
    public ResponseEntity<Ask> poll(@PathVariable("id") Long id, @PathVariable("idAnswer") Long idAnswer) {
        return this.askService.getById(id)
                .map(response -> ResponseEntity.ok().body(this.askService.poll(response, idAnswer)))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @RequestMapping(path = "/{id}/submit/{answer}", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Submit an answer for FreeString types of asks")
    public ResponseEntity<Ask> poll(@PathVariable("id") Long id, @PathVariable("answer") String answer) {
        return this.askService.getById(id)
                .map(response -> ResponseEntity.ok().body(this.askService.poll(response, answer)))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
