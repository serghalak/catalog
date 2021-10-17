package com.exadel.catalog.service;

import com.exadel.catalog.request.JenreRequest;
import com.exadel.catalog.response.JenreResponse;

import java.util.Set;

public interface JenreService {

    Set<JenreResponse> listJenres();

    JenreResponse createJenre(JenreRequest jenreRequest);

}
