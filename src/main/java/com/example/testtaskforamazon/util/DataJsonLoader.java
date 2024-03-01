package com.example.testtaskforamazon.util;

import com.example.testtaskforamazon.entities.ReportSpecificationEntity;
import com.example.testtaskforamazon.entities.SalesAndTrafficByASINEntity;
import com.example.testtaskforamazon.entities.SalesAndTrafficByDataEntity;
import com.example.testtaskforamazon.services.SalesAndTrafficByASINService;
import com.example.testtaskforamazon.services.SalesAndTrafficByDateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataJsonLoader {

    final SalesAndTrafficByDateService byDateService;

    final SalesAndTrafficByASINService byASINService;

    @Value("${filepath}")
    String FILEPATH;

    static final ObjectMapper objectMapper = new ObjectMapper();
    @PostConstruct
    public void loadData() {
        try {

            ReportSpecificationEntity reportSpecification = objectMapper.readValue(new File(FILEPATH), ReportSpecificationEntity.class);
            SalesAndTrafficByDataEntity salesAndTrafficByDataEntity = objectMapper.readValue(new File(FILEPATH), SalesAndTrafficByDataEntity.class);
            SalesAndTrafficByASINEntity salesAndTrafficByASINEntity = objectMapper.readValue(new File(FILEPATH), SalesAndTrafficByASINEntity.class);

            byDateService.saveNewDoc(salesAndTrafficByDataEntity, reportSpecification);
            byASINService.saveNewDoc(salesAndTrafficByASINEntity);

            log.info("Данные сохранены в MongoDB.");
        } catch (IOException e) {
            log.error("Ошибка при загрузке данных: " + e.getMessage());
        }
    }
}