package com.jannouMetter.dao;

import com.jannouMetter.bo.Anwser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Anwser, Long> {
}
