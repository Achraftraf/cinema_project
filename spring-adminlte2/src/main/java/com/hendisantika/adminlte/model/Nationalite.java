package com.hendisantika.adminlte.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nationalite extends AbstractModel<Long>  {

	private static final long serialVersionUID = 1L;
	  
	  @Column(nullable = false, length = 50)
	 private String libelle;

	  public String toString() {

	    return this.libelle;

	 }

	  public String getLibelle() {

	  return this.libelle;
	 
	 }
	
}
