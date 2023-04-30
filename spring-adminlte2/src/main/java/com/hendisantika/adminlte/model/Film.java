package com.hendisantika.adminlte.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film extends AbstractModel<Long> {

	private static final long serialVersionUID = -2974953413266908441L;
	
	
    @Column(name = "added_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date addedDate;
    
    @Column(nullable = false, length = 50)
	private int annee;
    
    @Column(nullable = false, length = 50)
    private int duree;
    
    @Column(nullable = false, length = 50)
    private String titre;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="NATIONALITE_ID")
    private Nationalite nationalite;
    
    
     //la relation entre personne et directeur
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="DIRECTEUR_ID")
    private Personne directeur;
    //la relation entre personne et acteur, cela va engendrer la création de la table Film_acteur avec les deux clés étrangères film_id et acteur_id
    // (À cause de l'annotation ManyToMany)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "FILM_ACTEUR",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSONNE_ID"))
	private List<Personne> acteurs;
    
    



}
