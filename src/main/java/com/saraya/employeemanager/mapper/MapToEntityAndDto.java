package com.saraya.employeemanager.mapper;

import org.springframework.stereotype.Service;

import java.util.List;

public interface MapToEntityAndDto<E, Dto> {

    List<E> mapToListEntity(List<Dto> dtoList);

    List<Dto> mapToListDto(List<E> entityList);

    E mapToEntity(Dto dto);

    Dto mapToDto(E entity);
}
