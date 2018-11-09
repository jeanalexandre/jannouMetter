package com.jannouMetter.dao;

import com.jannouMetter.bo.Ask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AskRepository extends JpaRepository<Ask, Long> {
}
