/**
 * 
 */
package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Compras;

/**
 * @author Adail Carvalho
 *
 * @version 
 *
 * @since 18/05/2016 
 */
public interface IComprasService {
	
	public List<Compras> findAll();
	
	public Compras findOne(long id);
	
	public Compras save(Compras buy);
	
	public Compras update(Compras buy);
	
	public void delete(long id);
}
