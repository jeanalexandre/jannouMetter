package com.jannouMetter.service;

import com.jannouMetter.bo.Ask;
import com.jannouMetter.bo.Response;
import com.jannouMetter.dao.AskRepository;
import com.jannouMetter.dao.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {

    private ResponseRepository responseRepository;
    private AskRepository askRepository;

    public ResponseService(ResponseRepository responseRepository, AskRepository askRepository) {
        this.responseRepository = responseRepository;
        this.askRepository = askRepository;
    }

    public List<Response> getAll() {
        return this.responseRepository.findAll();
    }

    public Optional<Response> getById(Long id) {
        return this.responseRepository.findById(id);
    }

    public Response create(Response response) {
        return this.responseRepository.save(response);
    }

    public Response addAsk(Ask ask, Response response) {
        response.setAsk(ask);
        responseRepository.save(response);
        return response;
    }
}
