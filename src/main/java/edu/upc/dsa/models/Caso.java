package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.Date;

public class Caso {
    String nombre;
    String apellidos;
    String idCaso;
    Date fechaNacimiento;
    Date fechaInforme; /** Dato para ordenar  */
    String clasificacion; /** Dato para ordeanr;
     Clasifiación:
     confirmado
     sospechoso
     noCaso*/
    String genero;
    String correo;
    String telefono;
    String direccion;
    String idBrote;


    public Caso(String nombre, String apellidos, String idCaso, Date fechaNacimiento, Date fechaInforme, String clasificacion, String genero, String correo, String telefono, String direccion, String idBrote) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idCaso = idCaso;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInforme = fechaInforme;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idBrote = idBrote;
    }

    public Caso(){} /* Constructor Vacio*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(String idCaso) {
        this.idCaso = idCaso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(Date fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
