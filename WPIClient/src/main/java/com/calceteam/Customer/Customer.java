package com.calceteam.Customer;

import java.io.Serializable;

import com.calceteam.WPIClient.model.BaseJsonObject;

public class Customer extends BaseJsonObject implements Serializable {

	private static final long serialVersionUID = -2283775326229957480L;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String edad;
	private String estabilidadLaboral;
	private String lugarTrabajo;
	private String salario;
	private String otrosIngresos;
	private String sexo;
	private String provincia;
	private String ciudad;
	private String corregimiento;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getEstabilidadLaboral() {
		return estabilidadLaboral;
	}

	public void setEstabilidadLaboral(String estabilidadLaboral) {
		this.estabilidadLaboral = estabilidadLaboral;
	}

	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getOtrosIngresos() {
		return otrosIngresos;
	}

	public void setOtrosIngresos(String otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorregimiento() {
		return corregimiento;
	}

	public void setCorregimiento(String corregimiento) {
		this.corregimiento = corregimiento;
	}
}
