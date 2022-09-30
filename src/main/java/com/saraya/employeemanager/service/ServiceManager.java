package com.saraya.employeemanager.service;

import java.util.List;
import java.util.Set;

public interface ServiceManager<E, Dto> {

    List<Dto> getAll();
    E create(Dto dto);
    E update(Dto dto);



}
