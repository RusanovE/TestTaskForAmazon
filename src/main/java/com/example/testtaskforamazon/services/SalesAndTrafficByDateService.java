package com.example.testtaskforamazon.services;

import com.example.testtaskforamazon.entities.ReportSpecificationEntity;
import com.example.testtaskforamazon.entities.SalesAndTrafficByDataEntity;

import java.util.List;

public interface SalesAndTrafficByDateService {

    List<SalesAndTrafficByDataEntity> getAllStats();

    SalesAndTrafficByDataEntity.SalesAndTrafficByDate getStatsByDate(String date);

    List<SalesAndTrafficByDataEntity> putCache();

    void deleteAll();

    void saveNewDoc(SalesAndTrafficByDataEntity byDataEntity, ReportSpecificationEntity reportEntity);

    List<SalesAndTrafficByDataEntity.SalesAndTrafficByDate> getStatsBetweenDate(String[] dates);
}
