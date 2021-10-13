package com.exadel.catalog.service;

import com.exadel.catalog.request.PublisherRequest;
import com.exadel.catalog.response.PublisherResponse;

import java.util.Set;

public interface PublisherService {

    Set<PublisherResponse> listPublishers();

    PublisherResponse createPublisher(PublisherRequest publisherRequest);

}
