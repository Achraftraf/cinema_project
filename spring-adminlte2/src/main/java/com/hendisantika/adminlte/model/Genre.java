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
public class Genre extends AbstractModel<Long> {

	private static final long serialVersionUID = -2974953413266908441L;

	@Column(nullable = false, length = 50)
    private String libellee;
	
	
}
