package com.basesdedatos.model;

import java.sql.Date;
import java.sql.Time;

public class citas {
    private Integer idCitas;
    private Integer id_pacientes;
    private Time Hora;
    private Date fecha;
    private String sede;
    private Integer no_consultorio;
    private Integer id_medico;

    public citas(){

    }
    public citas(Integer idCitas, Integer id_pacientes, Time Hora, Date fecha, String sede, Integer no_consultorio, Integer id_medico){
        this.idCitas = idCitas;
        this.id_pacientes = id_pacientes;
        this.Hora = Hora;
        this.fecha =fecha;
        this.sede = sede;
        this.no_consultorio = no_consultorio;
        this.id_medico = id_medico;
    }
    public Integer getIdCitas() {
        return idCitas;
    }
    public void setIdCitas(Integer idCitas) {
        this.idCitas = idCitas;
    }
    public Integer getId_pacientes() {
        return id_pacientes;
    }
    public void setId_pacientes(Integer id_pacientes) {
        this.id_pacientes = id_pacientes;
    }
    public Time getHora() {
        return Hora;
    }
    public void setHora(Time hora) {
        Hora = hora;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getSede() {
        return sede;
    }
    public void setSede(String sede) {
        this.sede = sede;
    }
    public Integer getNo_consultorio() {
        return no_consultorio;
    }
    public void setNo_consultorio(Integer no_consultorio) {
        this.no_consultorio = no_consultorio;
    }
    public Integer getId_medico() {
        return id_medico;
    }
    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

    
}
