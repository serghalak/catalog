package com.exadel.catalog.service;

import com.exadel.catalog.domain.Book;
import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.domain.Publisher;
import com.exadel.catalog.request.PublisherRequest;
import com.exadel.catalog.response.PublisherResponse;

import java.util.Set;

public interface PublisherService {

    Set<PublisherResponse> listPublishers();
    PublisherResponse createPublisher(PublisherRequest publisherRequest);

//    Publisher findById(Long id);
//
//    Publisher updatePublisher(Publisher book);
//    void deletePublisher(Publisher publisher);
//    void deletePublisherById(Long id);
//    Set<Publisher>findByName(String name);
//    Set<Publisher>findByAddress(String address);
}
