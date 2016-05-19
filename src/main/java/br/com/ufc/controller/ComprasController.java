/**
 * 
 */
package br.com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.model.Compras;
import br.com.ufc.service.IComprasService;

/**
 * @author Adail Carvalho
 *
 * @version 
 *
 * @since 18/05/2016 
 */

@RestController
@RequestMapping(value = "/compras")
public class ComprasController {
	
	@Autowired
	private IComprasService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Compras>> findAll() {
		List<Compras> comprasList = service.findAll();
		
		return new ResponseEntity<List<Compras>>(comprasList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Compras> findOne(@PathVariable(value = "id") Long id) {
		Compras buy = service.findOne(id);
		return new ResponseEntity<Compras>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Compras> save(@RequestBody Compras requestBuy) {
		Compras buy = service.save(requestBuy);
		return new ResponseEntity<Compras>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Compras> update(@PathVariable(value = "id") Long id, @RequestBody Compras requestBuy) {
		Compras buy = service.update(requestBuy);
		return new ResponseEntity<Compras>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) throws Exception {
		if (id == null) {
			throw new Exception("Id nao pode ser nulo");
		}
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}