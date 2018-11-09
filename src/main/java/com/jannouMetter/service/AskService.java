package com.jannouMetter.service;

import com.jannouMetter.bo.Ask;
import com.jannouMetter.dao.AskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AskService {

    private AskRepository askRepository;

    public AskService(AskRepository askRepository) {
        this.askRepository = askRepository;
    }

    public List<Ask> getAll() {
        return this.askRepository.findAll();
    }
}
