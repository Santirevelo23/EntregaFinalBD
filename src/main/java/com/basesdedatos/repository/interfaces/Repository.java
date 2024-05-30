package com.basesdedatos.repository.interfaces;
import java.sql.SQLException;
import java.util.List;

public interface Repository <T>{
    List<T> findAll() throws SQLException;

}
