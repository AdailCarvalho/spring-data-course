/**
 * 
 */
package br.com.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Adail Carvalho
 *
 * @version 
 *
 * @since 18/05/2016 
 */

@Entity
public class Compras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonProperty(value = "usuario")
	private User user;
	
	@Column(name = "total")
	@JsonProperty(value = "total")
	private Double total;
	
	@Column(name = "data")
	@JsonProperty(value = "data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
	private Date buyDate;
	
	@Column(name = "quantidade")
	@JsonProperty(value = "quantidade")
	private Integer quantity;

	public Compras() {
		super();
	}

	public Compras(Long id) {
		super();
		this.id = id;
	}

	public Compras(Double total, Date buyDate, Integer quantity) {
		super();
		this.total = total;
		this.buyDate = buyDate;
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}	
}