package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Task;
import com.hashedin.model.User;

public interface UserRepository {

	User find(Long taskId);

	List<User> findAll();

	User save(User task);

	User update(User task, Long taskId);

	User delete(Long taskId);

	List<Task> findTasksByUserId(Long userId);
}
