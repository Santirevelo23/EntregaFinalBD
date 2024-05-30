package com.basesdedatos.repository.interfaces;

import java.util.List;

public interface PacientesInterface<T>{

    List<T> findAllByLastName(String lastName) throws Exception;
    List<T> findAllInformcacionDeContacto() throws Exception;


}
