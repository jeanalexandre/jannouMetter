package com.jannouMetter.dao;

import com.jannouMetter.bo.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
