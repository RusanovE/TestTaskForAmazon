package com.example.testtaskforamazon.services.impl;

import com.example.testtaskforamazon.entities.SalesAndTrafficByASINEntity;
import com.example.testtaskforamazon.repositories.SalesAndTrafficByAsinRepository;
import com.example.testtaskforamazon.services.SalesAndTrafficByASINService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "cachedDataByAsin")
public class SalesAndTrafficByASINServiceImpl implements SalesAndTrafficByASINService {

    final SalesAndTrafficByAsinRepository byAsinRepository;

    @Override
    @Cacheable
    public List<SalesAndTrafficByASINEntity> getAllStats() {
        return byAsinRepository.findAll();
    }

    @Override
    public SalesAndTrafficByASINEntity.SalesAndTrafficByAsin getStatsByAsin(String asin) {
        List<SalesAndTrafficByASINEntity> list = byAsinRepository.findAll();

        return list.stream()
                .flatMap(byASINEntity -> byASINEntity.getSalesAndTrafficByAsin().stream())
                .filter(salesAndTrafficByDate -> asin.equals(salesAndTrafficByDate.getParentAsin()))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteAll() {
        byAsinRepository.deleteAll();
    }

    @Override
    public void saveNewDoc(SalesAndTrafficByASINEntity byASINEntity) {
        byAsinRepository.save(byASINEntity);
    }

    @Override
    public List<SalesAndTrafficByASINEntity.SalesAndTrafficByAsin> getStatsBetweenAsin(String[] asins) {
        List<SalesAndTrafficByASINEntity> list = byAsinRepository.findAll();

        return list.stream()
                .flatMap(byASINEntity -> byASINEntity.getSalesAndTrafficByAsin().stream())
                .filter(salesAndTrafficByAsin ->
                        Arrays.stream(asins)
                                .filter(Objects::nonNull) // Фильтрация, чтобы избежать NPE, если дата в объекте равна null
                                .anyMatch(s -> s.equals(salesAndTrafficByAsin.getParentAsin())))
                .collect(Collectors.toList());
    }

    /**
     * Method for cache
     *
     * @return List<SalesAndTrafficByDataEntity>
     */
    @CachePut
    public List<SalesAndTrafficByASINEntity> putCache() {
        return byAsinRepository.findAll();
    }
}
