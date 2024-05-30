package com.basesdedatos.repository;

import com.basesdedatos.config.DatabaseConnection;
import com.basesdedatos.model.Medico;
import com.basesdedatos.repository.interfaces.MedicosInterface;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicosRepository implements MedicosInterface<Medico> {


    @Override
    public List<Medico> findAllByEspecialist() throws Exception{

        List<Medico> medicos = new ArrayList<>();

        try(Statement myStat = DatabaseConnection.getInstance().createStatement()){

            ResultSet myResultSet = myStat.executeQuery("select idMedicos, nombre,apellido, especialista " +
                    "from medicos where especialista <> 'General' ");

            while (myResultSet.next()) {
                Medico medico = new Medico();
                medico.setIdMedicos(myResultSet.getInt("idMedicos"));
                medico.setNombre(myResultSet.getString("nombre"));
                medico.setApellido(myResultSet.getString("apellido"));
                medico.setEspecialista(myResultSet.getString("especialista"));
                medicos.add(medico);
            }
        }
        return medicos;
    }

    @Override
    public List<Medico> findAllByNoEspecialist() throws Exception {
        List<Medico> medicos = new ArrayList<>();

        try(Statement myStat = DatabaseConnection.getInstance().createStatement()){

            ResultSet myResultSet = myStat.executeQuery("SELECT idMedicos, nombre, apellido, especialista FROM medicos WHERE especialista = 'General'");

            while (myResultSet.next()) {
                Medico medico = new Medico();
                medico.setIdMedicos(myResultSet.getInt("idMedicos"));
                medico.setNombre(myResultSet.getString("nombre"));
                medico.setApellido(myResultSet.getString("apellido"));
                medico.setEspecialista(myResultSet.getString("especialista"));
                medicos.add(medico);
            }
        }
        return medicos;
    }







}
