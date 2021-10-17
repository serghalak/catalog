package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.domain.Publisher;
import com.exadel.catalog.mapper.JenreMapper;
import com.exadel.catalog.mapper.PublisherMapper;
import com.exadel.catalog.repository.JenreRepository;
import com.exadel.catalog.repository.PublisherRepository;
import com.exadel.catalog.request.JenreRequest;
import com.exadel.catalog.request.PublisherRequest;
import com.exadel.catalog.response.JenreResponse;
import com.exadel.catalog.response.PublisherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PublisherServiceImplTest {

    private Publisher publisher1;

    private Publisher publisher2;

    @InjectMocks
    private PublisherServiceImpl publisherService;

    @Mock
    private PublisherRepository publisherRepository;

    @Mock
    private PublisherMapper publisherMapper;

    @Mock
    private PublisherRequest publisherRequest;

    @BeforeEach
    void setUp() {

        publisher1 = new Publisher();
        publisher1.setId(1L);
        publisher1.setName("PROGRAMMER");

        publisher2 = new Publisher();
        publisher2.setId(2L);
        publisher2.setName("IT Today");
    }

    @Test
    void shouldReturnAllPublishersFromRepository() {

        List<Publisher> publishers= List.of(publisher1, publisher2);
        when((publisherRepository.findAll())).thenReturn(publishers);

        assertNotNull(publisherService.listPublishers());
        assertEquals(2, publishers.size());
        assertNotEquals(3, publishers.size());
    }

    @Test
    void shouldThrowExceptionDuringSavePublisherIfNameIsEmpty() {

        when(publisherRequest.getName()).thenReturn("");

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    publisherService.createPublisher(publisherRequest);
                });
    }

    @Test
    void shouldThrowExceptionDuringSavePublisherIfNameIsNull() {

        when(publisherRequest.getName()).thenReturn(null);

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    publisherService.createPublisher(publisherRequest);
                });
    }

    @Test
    void shouldReturnPublisherResponseDuringSavePublisherRequest(){
        PublisherResponse publisherResponse = new PublisherResponse();
        publisherResponse.setId(1L);
        publisherResponse.setName("PROGRAMMER");

        PublisherRequest publisherRequest = new PublisherRequest();
        publisherRequest.setName("PROGRAMMER");

        Publisher publisherBeforeSave = new Publisher();
        publisherBeforeSave.setName("PROGRAMMER");

        when(publisherMapper.PublisherRequestToPublisher(publisherRequest)).thenReturn(publisherBeforeSave);
        when(publisherRepository.save(publisherBeforeSave)).thenReturn(publisher1);
        when(publisherMapper.publisherToPublisherResponse(publisher1)).thenReturn(publisherResponse);

        assertEquals(publisherResponse, publisherService.createPublisher(publisherRequest));
    }
}