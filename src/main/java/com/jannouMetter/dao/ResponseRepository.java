package com.jannouMetter.dao;

import com.jannouMetter.bo.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
