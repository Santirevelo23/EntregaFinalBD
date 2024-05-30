package com.basesdedatos.repository.interfaces;

import java.util.List;

public interface TratamientosInterface<T>{

    List<T> findAllPacientasConMasDeUnTratamiento() throws Exception;
    List<T> findAllSegunElTipoTratamiento(String tipoTratamiento) throws Exception;
    List<T> findAllCantiadadTipoTratamiento() throws Exception;
    List<T> findAllTratamientosLargoPlazo() throws Exception;


}
