/**
 * 
 */
package br.com.ufc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ufc.model.Compras;
import br.com.ufc.repository.ComprasRepository;

/**
 * @author Adail Carvalho
 *
 * @version 
 *
 * @since 18/05/2016 
 */

@Service
@Transactional
public class ComprasService implements IComprasService {
	
	@Autowired
	private ComprasRepository repository;

	@Override
	public List<Compras> findAll() {
		return repository.findAll();
	}

	@Override
	public Compras findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Compras save(Compras buy) {
		return repository.save(buy);
	}

	@Override
	public Compras update(Compras buy) {
		if(!(repository.exists(buy.getId()))){
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(buy);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);	
	}	
}
