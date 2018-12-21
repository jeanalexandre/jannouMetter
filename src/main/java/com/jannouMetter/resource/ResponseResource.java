package com.jannouMetter.resource;

import com.jannouMetter.bo.Response;
import com.jannouMetter.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/responses")
@Api(value = "Response", description = "Responses")
public class ResponseResource {

    private ResponseService responseService;

    public ResponseResource(ResponseService responseService) {
        this.responseService = responseService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return all Responses")
    public ResponseEntity<List<Response>> getAllResponses() {
        return new ResponseEntity<>(this.responseService.getAll(), HttpStatus.OK
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return an Response")
    public ResponseEntity<Response> getAnswerById(@PathVariable("id") Long id) {
        return this.responseService.getById(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
