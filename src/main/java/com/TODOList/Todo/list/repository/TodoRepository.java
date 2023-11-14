package com.TODOList.Todo.list.repository;

import com.TODOList.Todo.list.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Todo, Integer> {
}
