package com.basesdedatos.model;

public class Tratamiento {

    private Integer idTratamientos;
    private String Tipo_tratamiento;
    private String hora;
    private Integer cantidad;
    private Integer tiempo_consumo;
    private String Direccion;


    private Paciente paciente;



    public Tratamiento(){

    }
    public Tratamiento(Integer idTratamientos,
                       String Tipo_tratamiento, String hora, Integer cantidad,
                       Integer tiempo_consumo, String Direccion,
                       Paciente paciente){
        this.idTratamientos= idTratamientos;
        this.Tipo_tratamiento = Tipo_tratamiento;
        this.hora = hora;
        this.cantidad = cantidad;
        this.tiempo_consumo =  tiempo_consumo;
        this.Direccion  = Direccion;
        this.paciente = paciente;
    }
    public Integer getIdTratamientos() {
        return idTratamientos;
    }
    public void setIdTratamientos(Integer idTratamientos) {
        this.idTratamientos = idTratamientos;
    }
    public String getTipo_tratamiento() {
        return Tipo_tratamiento;
    }
    public void setTipo_tratamiento(String tipo_tratamiento) {
        Tipo_tratamiento = tipo_tratamiento;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Integer getTiempo_consumo() {
        return tiempo_consumo;
    }
    public void setTiempo_consumo(Integer tiempo_consumo) {
        this.tiempo_consumo = tiempo_consumo;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
