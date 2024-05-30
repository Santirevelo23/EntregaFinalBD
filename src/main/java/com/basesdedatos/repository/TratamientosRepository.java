package com.basesdedatos.repository;

import com.basesdedatos.config.DatabaseConnection;
import com.basesdedatos.model.Paciente;
import com.basesdedatos.model.Tratamiento;
import com.basesdedatos.repository.interfaces.TratamientosInterface;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TratamientosRepository implements TratamientosInterface<Tratamiento> {

    @Override
    public List<Tratamiento> findAllPacientasConMasDeUnTratamiento() throws Exception {
        List<Tratamiento> tratamientos = new ArrayList<>();

        try(Statement myStat = DatabaseConnection.getInstance().createStatement()){

            ResultSet myResultSet = myStat.executeQuery("select p.nombre, p.apellido, t.idpacientes, count(*) ct " +
                    "from tratamientos t " +
                    "join pacientes p on p.idpacientes = t.idpacientes " +
                    "group by p.nombre, p.apellido, t.idpacientes " +
                    "having count(*) > 1;");

            while (myResultSet.next()) {
                Tratamiento tratamiento = new Tratamiento();
                Paciente paciente = new Paciente();

                paciente.setNombre(myResultSet.getString("nombre"));
                paciente.setApellido(myResultSet.getString("apellido"));
                paciente.setIdPacientes(myResultSet.getInt("idpacientes"));

                tratamiento.setCantidad(myResultSet.getInt("ct"));
                tratamiento.setPaciente(paciente);

                tratamientos.add(tratamiento);
            }
        }
        return tratamientos;
    }

    @Override
public List<Tratamiento> findAllSegunElTipoTratamiento(String tipoTratamiento) throws Exception {
    List<Tratamiento> tratamientos = new ArrayList<>();

    try (Statement myStat = DatabaseConnection.getInstance().createStatement()) {

        ResultSet myResultSet = myStat.executeQuery("SELECT idTratamientos, Tipo_tratamiento FROM tratamientos WHERE tipo_tratamiento = '" + tipoTratamiento + "'");

        while (myResultSet.next()) {
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setIdTratamientos(myResultSet.getInt("idTratamientos"));
            tratamiento.setTipo_tratamiento(myResultSet.getString("Tipo_tratamiento"));

            tratamientos.add(tratamiento);
        }
    }
    return tratamientos;
}


    @Override
    public List<Tratamiento> findAllCantiadadTipoTratamiento() throws Exception {
        List<Tratamiento> tratamientos = new ArrayList<>();

        try(Statement myStat = DatabaseConnection.getInstance().createStatement()){

            ResultSet myResultSet = myStat.executeQuery("SELECT Tipo_tratamiento, COUNT(*) AS cantidad FROM tratamientos GROUP BY Tipo_tratamiento");

            while (myResultSet.next()) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setTipo_tratamiento(myResultSet.getString("Tipo_tratamiento"));
                tratamiento.setCantidad(myResultSet.getInt("cantidad"));

                tratamientos.add(tratamiento);
            }
        }
        return tratamientos;
    }

    @Override
    public List<Tratamiento> findAllTratamientosLargoPlazo() throws Exception {
        List<Tratamiento> tratamientos = new ArrayList<>();

        try(Statement myStat = DatabaseConnection.getInstance().createStatement()){

            ResultSet myResultSet = myStat.executeQuery("SELECT idTratamientos, Tipo_Tratamiento, tiempo_consumo FROM tratamientos WHERE tiempo_consumo > 100");

            while (myResultSet.next()) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setIdTratamientos(myResultSet.getInt("idTratamientos"));
                tratamiento.setTipo_tratamiento(myResultSet.getString("Tipo_tratamiento"));
                tratamiento.setTiempo_consumo(myResultSet.getInt("tiempo_consumo"));

                tratamientos.add(tratamiento);
            }
        }
        return tratamientos;
    }
}
