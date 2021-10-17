package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.mapper.JenreMapper;
import com.exadel.catalog.repository.JenreRepository;
import com.exadel.catalog.request.JenreRequest;
import com.exadel.catalog.response.JenreResponse;
import com.exadel.catalog.service.JenreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class JenreServiceImpl implements JenreService {

    private final JenreRepository jenreRepository;
    private final JenreMapper jenreMapper;

    @Override
    public Set<JenreResponse> listJenres() {
        return jenreRepository.findAll().stream()
                .map(jenreMapper::jenreToJenreResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public JenreResponse createJenre(JenreRequest jenreRequest) {
        if (jenreRequest == null) {
            throw new IllegalArgumentException("The jenre cannot be empty");
        }

        String name = jenreRequest.getName();

        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("The name cannot be empty");
        }

        Jenre jenre = jenreMapper.JenreRequestToJenre(jenreRequest);

        Jenre saveJenre = jenreRepository.save(jenre);

        return jenreMapper.jenreToJenreResponse(saveJenre);
    }
}
