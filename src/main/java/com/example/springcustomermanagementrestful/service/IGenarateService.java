package com.example.springcustomermanagementrestful.service;

import java.util.Optional;

public interface IGenarateService<C>{
    Iterable<C>findAll();
    C save(C c);
    Optional<C>findById(Long id);
    void remove(Long id);
}
