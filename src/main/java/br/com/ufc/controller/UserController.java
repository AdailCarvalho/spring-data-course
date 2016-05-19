package br.com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.model.User;
import br.com.ufc.service.IUserService;


/** 
 * @author Adail Carvalho
 *
 */
@RestController
@RequestMapping(value = "/usuarios")
public class UserController {

	@Autowired
	private IUserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> userList = service.findAll();
		
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findOne(@PathVariable(value = "id") Long id) {
		User user = service.findOne(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User requestUser) {
		User user = service.save(requestUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable(value = "id") Long id, @RequestBody User requestUser) {
		requestUser.setId(id);
		User user = service.update(requestUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) throws Exception {
		if (id == null) {
			throw new Exception("Id nao pode ser nulo");
		}
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findByName(@RequestParam(value = "nome") String name) {
		List<User> userList = service.findByName(name);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
}