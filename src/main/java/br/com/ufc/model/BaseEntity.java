/**
 * 
 */
package br.com.ufc.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Adail Carvalho
 *
 * @version 
 *
 * @since 18/05/2016 
 */

@MappedSuperclass
public abstract class BaseEntity {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
	@JsonProperty(value = "data_criacao")
	@Column(name = "data_criacao", updatable = false)
	private Date createdAt;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
	@JsonProperty(value = "data_modificacao")
	@Column(name = "data_modificacao")
	private Date updatedAt;
	
	@PrePersist
	protected void prePersist() {
		Date now = Calendar.getInstance().getTime();
		this.createdAt = now;
	}
	
	@PreUpdate
	protected void preUpdate() {
		Date now = Calendar.getInstance().getTime();
		this.updatedAt = now;
	}
}