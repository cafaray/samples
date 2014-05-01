package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the kwfm90t database table.
 * 
 */
@Entity
@Table(name="kwfm90t")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String descripcion;

	private String idborol;

	private String idsesion;

	private String prefijo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="Rol")
	private List<Usuario> Usuario;

	public Rol() {
		tmstmp = new Date();
		idsesion = "";
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String setIdentificador(){
		this.identificador =GeneraIdentificador.toMD5(); 
		return this.identificador;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdborol() {
		return this.idborol;
	}

	public void setIdborol(String idborol) {
		this.idborol = idborol;
	}

	public String getIdsesion() {
		return this.idsesion;
	}

	public void setIdsesion(String idsesion) {
		this.idsesion = idsesion;
	}

	public String getPrefijo() {
		return this.prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public List<Usuario> getUsuario() {
		return this.Usuario;
	}

	public void setUsuario(List<Usuario> Usuario) {
		this.Usuario = Usuario;
	}

	public Usuario addUsuario(Usuario Usuario) {
		getUsuario().add(Usuario);
		Usuario.setRol(this);

		return Usuario;
	}

	public Usuario removeUsuario(Usuario Usuario) {
		getUsuario().remove(Usuario);
		Usuario.setRol(null);

		return Usuario;
	}

}