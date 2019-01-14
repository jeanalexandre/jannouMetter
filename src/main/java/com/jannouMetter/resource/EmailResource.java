package com.jannouMetter.resource;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.bo.Email;
import com.jannouMetter.service.AnswerService;
import com.jannouMetter.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
@Api(value = "Emails", description = "Emails")
public class EmailResource {

    private EmailService emailService;

    public EmailResource(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return all Emails")
    public ResponseEntity<List<Email>> getAllAnswer() {
        return new ResponseEntity<>(this.emailService.getAll(), HttpStatus.OK
        );
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Create a Email")
    public ResponseEntity<Email> createQuizz(@RequestBody Email email) {
        return new ResponseEntity<>(this.emailService.create(email), HttpStatus.CREATED);
    }
}
