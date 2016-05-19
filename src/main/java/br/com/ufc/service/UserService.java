package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.User;
import br.com.ufc.repository.UserRepository;

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		
		if(!(repository.exists(user.getId()))){
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(user);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

	@Override
	public List<User> findByName(String name) {
		return repository.findByName(name);
	}
}
