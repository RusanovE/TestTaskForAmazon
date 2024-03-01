package com.example.testtaskforamazon.services.impl;

import com.example.testtaskforamazon.entities.ReportSpecificationEntity;
import com.example.testtaskforamazon.entities.SalesAndTrafficByDataEntity;
import com.example.testtaskforamazon.repositories.ReportSpecificationRepository;
import com.example.testtaskforamazon.repositories.SalesAndTrafficByDataRepository;
import com.example.testtaskforamazon.services.SalesAndTrafficByDateService;
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
@CacheConfig(cacheNames = "cachedDataByDate")
public class SalesAndTrafficByDateServiceImpl implements SalesAndTrafficByDateService {

    final ReportSpecificationRepository reportRepository;

    final SalesAndTrafficByDataRepository byDataRepository;

    @Override
    @Cacheable
    public List<SalesAndTrafficByDataEntity> getAllStats() {
        return byDataRepository.findAll();
    }

    @Override
    public SalesAndTrafficByDataEntity.SalesAndTrafficByDate getStatsByDate(String date) {
        List<SalesAndTrafficByDataEntity> list = byDataRepository.findAll();

        return list.stream()
                .flatMap(byDataEntity -> byDataEntity.getSalesAndTrafficByDate().stream())
                .filter(salesAndTrafficByDate -> date.equals(salesAndTrafficByDate.getDate()))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteAll() {
        reportRepository.deleteAll();
        byDataRepository.deleteAll();
    }

    @Override
    public void saveNewDoc(SalesAndTrafficByDataEntity byDataEntity, ReportSpecificationEntity reportEntity) {
        reportRepository.save(reportEntity);
        byDataRepository.save(byDataEntity);
    }

    @Override
    public List<SalesAndTrafficByDataEntity.SalesAndTrafficByDate> getStatsBetweenDate(String[] dates) {
        List<SalesAndTrafficByDataEntity> list = byDataRepository.findAll();

        return list.stream()
                .flatMap(byDataEntity -> byDataEntity.getSalesAndTrafficByDate().stream())
                .filter(salesAndTrafficByDate ->
                        Arrays.stream(dates)
                                .filter(Objects::nonNull) // Фильтрация, чтобы избежать NPE, если дата в объекте равна null
                                .anyMatch(s -> s.equals(salesAndTrafficByDate.getDate())))
                .collect(Collectors.toList());
    }


    /**
     * Method for cache
     *
     * @return List<SalesAndTrafficByDataEntity>
     */
    @CachePut
    public List<SalesAndTrafficByDataEntity> putCache() {
        return byDataRepository.findAll();
    }
}
