package com.jannouMetter.service;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.bo.Email;
import com.jannouMetter.dao.AnswerRepository;
import com.jannouMetter.dao.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email create(Email email) {
        return this.emailRepository.save(email);
    }

    public List<Email> getAll() {
        return this.emailRepository.findAll();
    }

    public Optional<Email> getById(Long id) {
        return this.emailRepository.findById(id);
    }
}
