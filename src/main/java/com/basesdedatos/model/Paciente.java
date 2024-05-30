package com.basesdedatos.model;

public class Paciente {
    private Integer idPacientes;
    private String nombre;
    private String apellido;
    private Integer documentoId;
    private String noTelefono;

    public Paciente(){
    }


    public Paciente(Integer idPacientes, String nombre, String apellido, Integer documentoId, String noTelefono) {
        this.idPacientes = idPacientes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoId = documentoId;
        this.noTelefono = noTelefono;
    }

    public Integer getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Integer idPacientes) {
        this.idPacientes = idPacientes;
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

    public Integer getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Integer documentoId) {
        this.documentoId = documentoId;
    }

    public String getNoTelefono() {
        return noTelefono;
    }

    public void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
    }


}
