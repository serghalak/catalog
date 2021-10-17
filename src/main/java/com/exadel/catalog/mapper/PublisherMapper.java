package com.exadel.catalog.mapper;

import com.exadel.catalog.domain.Publisher;
import com.exadel.catalog.request.PublisherRequest;
import com.exadel.catalog.response.PublisherResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class PublisherMapper {

    private ModelMapper mapper;

    public PublisherResponse publisherToPublisherResponse(Publisher publisher) {
        return Objects.isNull(publisher) ? null : mapper.map(publisher, PublisherResponse.class);
    }

    public Publisher PublisherRequestToPublisher(PublisherRequest publisherRequest) {
        return Objects.isNull(publisherRequest) ? null : mapper.map(publisherRequest, Publisher.class);
    }
}
