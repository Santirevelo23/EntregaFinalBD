package com.basesdedatos.repository;

import com.basesdedatos.config.DatabaseConnection;
import com.basesdedatos.model.Paciente;
import com.basesdedatos.repository.interfaces.PacientesInterface;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacientesRepository implements PacientesInterface<Paciente> {

    @Override
    public List<Paciente> findAllByLastName(String lastName) throws Exception {
        List<Paciente> pacientes = new ArrayList<>();

        try(Statement myStat = DatabaseConnection.getInstance().createStatement()){

            ResultSet myResultSet = myStat.executeQuery("select idPacientes, nombre,apellido, documento_id, no_telefono " +
                    "from pacientes where upper(apellido) like '%" + lastName.toUpperCase() + "%'");

            while (myResultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPacientes(myResultSet.getInt("idPacientes"));
                paciente.setNombre(myResultSet.getString("nombre"));
                paciente.setApellido(myResultSet.getString("apellido"));
                paciente.setDocumentoId(myResultSet.getInt("documento_id"));
                paciente.setNoTelefono(myResultSet.getString("no_telefono"));
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }


    @Override
    public List<Paciente> findAllInformcacionDeContacto() throws Exception {
        List<Paciente> pacientes = new ArrayList<>();
        try(Statement myStat = DatabaseConnection.getInstance().createStatement()){

            ResultSet myResultSet = myStat.executeQuery("SELECT nombre, apellido, no_telefono FROM pacientes");

            while (myResultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setNombre(myResultSet.getString("nombre"));
                paciente.setApellido(myResultSet.getString("apellido"));
                paciente.setNoTelefono(myResultSet.getString("no_telefono"));
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }

    
}
