package com.example.testtaskforamazon.services;

import com.example.testtaskforamazon.entities.SalesAndTrafficByASINEntity;

import java.util.List;

public interface SalesAndTrafficByASINService {

    List<SalesAndTrafficByASINEntity> getAllStats();

    SalesAndTrafficByASINEntity.SalesAndTrafficByAsin getStatsByAsin(String date);

    List<SalesAndTrafficByASINEntity> putCache();

    void deleteAll();

    void saveNewDoc(SalesAndTrafficByASINEntity byDataEntity);

    List<SalesAndTrafficByASINEntity.SalesAndTrafficByAsin> getStatsBetweenAsin(String[] asins);
}
