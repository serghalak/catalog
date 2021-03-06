package com.exadel.catalog.mapper;

import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.request.JenreRequest;
import com.exadel.catalog.response.JenreResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class JenreMapper {

    private ModelMapper mapper;

    public JenreResponse jenreToJenreResponse(Jenre jenre) {
        return Objects.isNull(jenre) ? null : mapper.map(jenre, JenreResponse.class);
    }

    public Jenre jenreRequestToJenre(JenreRequest jenreRequest) {
        return Objects.isNull(jenreRequest) ? null : mapper.map(jenreRequest, Jenre.class);
    }
}
