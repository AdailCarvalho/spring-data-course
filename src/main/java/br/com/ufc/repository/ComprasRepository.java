/**
 * 
 */
package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Compras;

/**
 * @author Adail Carvalho
 *
 * @version 
 *
 * @since 18/05/2016 
 */

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long> {

}