package com.exadel.catalog.service;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.request.JenreRequest;
import com.exadel.catalog.response.JenreResponse;

import java.util.Set;

public interface JenreService {

    Set<JenreResponse> listJenres();

    JenreResponse createJenre(JenreRequest jenreRequest);

//    Jenre updateJenre(Jenre jenre);
//
//    void deleteAuthor(Jenre jenre);
//    void deleteJenreById(Long id);
//    Set<Jenre>findByName(String name);
}
