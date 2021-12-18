package com.company.fitnessproject.service;

import java.util.List;

public interface BaseService<Res, Req> {
    Res save(Req req);

    List<Res> getAll();

    Res findById(Long id);

    Res deleteById(Long id);
}
