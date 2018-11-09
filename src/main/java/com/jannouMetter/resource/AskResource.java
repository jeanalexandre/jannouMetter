package com.jannouMetter.resource;

import com.jannouMetter.bo.Ask;
import com.jannouMetter.service.AskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asks")
public class AskResource {

    private AskService askService;

    public AskResource(AskService askService) {
        this.askService = askService;
    }

    public List<Ask> getAllAsks() {
        return this.askService.getAll();
    }
}
