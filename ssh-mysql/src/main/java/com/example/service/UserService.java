package com.example.service;

import com.example.entities.Usera;

import java.util.List;

public interface UserService {

    List<Usera> list();

    void insert(Usera usera);

    void deleteById(int id);

    Usera queryById(int id);
}
