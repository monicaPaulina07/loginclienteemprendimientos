package com.distribuida.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="categoria")
public class Categoria {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCategoria")
	private int idCategoria;
	@Column(name="Categoria")
	private String Categoria;
	@Column(name="Descripcion")
	private String Descripcion;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="fk_idSeccion")		
	//GENERAMOS Seccion ***********
//	@Autowired
	private Seccion seccion;  //Seccion

	//Constructor Vacio
	public Categoria() {
		
	}
	
	
	//Constructor por parametro
	
	
	public Categoria(int idCategoria, String categoria, String descripcion) {
		this.idCategoria = idCategoria;
		this.Categoria = categoria;
		this.Descripcion = descripcion;
	
	}


	//METODOS SET Y GET
	
	public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getCategoria() {
		return Categoria;
	}


	public void setCategoria(String categoria) {
		Categoria = categoria;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public Seccion getSeccion() {
		return seccion;
	}


	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}


	
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", Categoria=" + Categoria + ", Descripcion=" + Descripcion
				+ ", seccion=" + seccion + "]";
	}



	
	
	
}
