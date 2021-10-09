package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Publisher;
import com.exadel.catalog.mapper.PublisherMapper;
import com.exadel.catalog.repository.PublisherRepository;
import com.exadel.catalog.request.PublisherRequest;
import com.exadel.catalog.response.PublisherResponse;
import com.exadel.catalog.service.PublisherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public Set<PublisherResponse> listPublishers() {
        return publisherRepository.findAll().stream()
                .map(publisherMapper::publisherToPublisherResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public PublisherResponse createPublisher(PublisherRequest publisherRequest) {

        if (publisherRequest == null) {
            throw new IllegalArgumentException("The publisher cannot be empty");
        }

        String name = publisherRequest.getName();

        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("The name cannot be empty");
        }

        Publisher publisher = publisherMapper.PublisherRequestToPublisher(publisherRequest);

        Publisher savePublisher = publisherRepository.save(publisher);

        return publisherMapper.publisherToPublisherResponse(savePublisher);
    }
}
