package com.example.demo.repository;

import com.example.demo.dto.Demo;
import org.springframework.data.repository.CrudRepository;

public interface DemoRepository extends CrudRepository<Demo, String> {
}
