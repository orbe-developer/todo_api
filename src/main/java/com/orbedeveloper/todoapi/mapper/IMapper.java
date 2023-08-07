package com.orbedeveloper.todoapi.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}