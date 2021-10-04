package com.exadel.catalog.service;

import com.exadel.catalog.domain.Book;
import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.domain.Publisher;

import java.util.Set;

public interface PublisherService {

    Set<Publisher> findAll();
    Publisher findById(Long id);
    Publisher createPublisher(Publisher book);
    Publisher updatePublisher(Publisher book);
    void deletePublisher(Publisher publisher);
    void deletePublisherById(Long id);
    Set<Publisher>findByName(String name);
    Set<Publisher>findByAddress(String address);
}
