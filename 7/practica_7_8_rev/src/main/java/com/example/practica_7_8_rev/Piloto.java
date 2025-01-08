package com.example.practica_7_8_rev;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="piloto")
public class Piloto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToOne	//CAMBIO
	@JoinColumn(name = "id_team", referencedColumnName="id")
	private Team team;
	
	
	public Piloto() {
	}
	public Piloto(String name, Team team) {	//CAMBIO
		this.name = name;
		this.team = team;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
	
}
