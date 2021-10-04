package com.exadel.catalog.service;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.domain.Jenre;

import java.util.Set;

public interface JenereService {

    Set<Jenre> findAll();
    Jenre findById(Long id);
    Jenre createJenre(Jenre jenre);
    Jenre updateJenre(Jenre jenre);
    void deleteAuthor(Jenre jenre);
    void deleteJenreById(Long id);
    Set<Jenre>findByName(String name);
}
