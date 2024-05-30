package com.basesdedatos.repository.interfaces;

import java.util.List;

public interface MedicosInterface <T>{

    List<T> findAllByEspecialist() throws Exception;
    List<T> findAllByNoEspecialist() throws Exception;


}
