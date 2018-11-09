package com.jannouMetter.dao;

import com.jannouMetter.bo.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzRepository extends JpaRepository<Quizz, Long> {
}
