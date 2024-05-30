package com.basesdedatos.model;

public class Medico {
    private Integer idMedicos;
    private String nombre;
    private String apellido;
    private String medico_general;
    private String especialista;

    
    public Medico() {
    }
    public Medico(Integer idMedicos, String nombre, String apellido, String medico_general, String especialista) {
        this.idMedicos = idMedicos;
        this.nombre = nombre;
        this.apellido = apellido;
        this.medico_general = medico_general;
        this.especialista = especialista;
    }
    public Integer getIdMedicos() {
        return idMedicos;
    }
    public void setIdMedicos(Integer idMedicos) {
        this.idMedicos = idMedicos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getMedico_general() {
        return medico_general;
    }
    public void setMedico_general(String medico_general) {
        this.medico_general = medico_general;
    }
    public String getEspecialista() {
        return especialista;
    }
    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    
}
