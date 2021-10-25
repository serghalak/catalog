package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.mapper.JenreMapper;
import com.exadel.catalog.repository.JenreRepository;
import com.exadel.catalog.request.JenreRequest;
import com.exadel.catalog.response.JenreResponse;
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
class JenreServiceImplTest {

    private Jenre jenre1;

    private Jenre jenre2;

    @InjectMocks
    private JenreServiceImpl jenreService;

    @Mock
    private JenreRepository jenreRepository;

    @Mock
    private JenreMapper jenreMapper;

    @Mock
    private JenreRequest jenreRequest;

    @BeforeEach
    void setUp() {

        jenre1 = new Jenre();
        jenre1.setId(1L);
        jenre1.setName("Web");

        jenre2 = new Jenre();
        jenre2.setId(2L);
        jenre2.setName("Lan");
    }

    @Test
    void shouldReturnAllJenresFromRepository() {

        List<Jenre> jenres= List.of(jenre1, jenre2);
        when((jenreRepository.findAll())).thenReturn(jenres);

        assertNotNull(jenreService.listJenres());
        assertEquals(2, jenres.size());
        assertNotEquals(3, jenres.size());
    }

//    @Test
//    void shouldReturnJenreResponseIfJenreIsPresentJenreById() {
//
//        JenreResponse jenreResponse = new JenreResponse();
//        jenreResponse.setId(1L);
//        jenreResponse.setName("Web");
//
//        when((jenreRepository.findById(1L))).thenReturn(java.util.Optional.ofNullable(jenre1));
//        when(jenreMapper.jenreToJenreResponse(jenre1)).thenReturn(jenreResponse);
//        assertEquals(jenreResponse, jenreService.(1L));
//    }

    @Test
    void shouldThrowExceptionDuringSaveJenreIfNameIsEmpty() {

        when(jenreRequest.getName()).thenReturn("");

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    jenreService.createJenre(jenreRequest);
                });
    }

    @Test
    void shouldThrowExceptionDuringSaveJenreIfNameIsNull() {

        when(jenreRequest.getName()).thenReturn(null);

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    jenreService.createJenre(jenreRequest);
                });
    }


    @Test
    void shouldReturnJenreResponseDuringSaveJenreRequest(){
        JenreResponse jenreResponse = new JenreResponse();
        jenreResponse.setId(1L);
        jenreResponse.setName("Web");

        JenreRequest jenreRequest = new JenreRequest();
        jenreRequest.setName("Lan");

        Jenre jenreBeforeSave = new Jenre();
        jenreBeforeSave.setName("Web");

        when(jenreMapper.jenreRequestToJenre(jenreRequest)).thenReturn(jenreBeforeSave);
        when(jenreRepository.save(jenreBeforeSave)).thenReturn(jenre1);
        when(jenreMapper.jenreToJenreResponse(jenre1)).thenReturn(jenreResponse);

        assertEquals(jenreResponse, jenreService.createJenre(jenreRequest));
    }
}