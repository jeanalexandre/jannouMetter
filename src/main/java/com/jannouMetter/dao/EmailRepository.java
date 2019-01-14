package com.jannouMetter.dao;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.bo.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
