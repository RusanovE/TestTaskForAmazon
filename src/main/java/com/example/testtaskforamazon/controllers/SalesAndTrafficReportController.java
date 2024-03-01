package com.example.testtaskforamazon.controllers;

import com.example.testtaskforamazon.entities.SalesAndTrafficByASINEntity;
import com.example.testtaskforamazon.entities.SalesAndTrafficByDataEntity;
import com.example.testtaskforamazon.services.SalesAndTrafficByASINService;
import com.example.testtaskforamazon.services.SalesAndTrafficByDateService;
import com.example.testtaskforamazon.util.DataJsonLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stats")
public class SalesAndTrafficReportController {

    final SalesAndTrafficByDateService byDateService;

    final SalesAndTrafficByASINService byASINService;

    final DataJsonLoader dataJsonLoader;
    @GetMapping("/allDates")
    public List<SalesAndTrafficByDataEntity> getAllStats() {
        List<SalesAndTrafficByDataEntity> list = byDateService.getAllStats();
        if (list.isEmpty()) return null;
        else return list;
    }

    @GetMapping("/{date}")
    public SalesAndTrafficByDataEntity.SalesAndTrafficByDate getStatsByDate(@PathVariable String date) {
        return byDateService.getStatsByDate(date);
    }

    @GetMapping("/between-dates")
    public List<SalesAndTrafficByDataEntity.SalesAndTrafficByDate> getStatsBetweenDate(@RequestParam String[] dates) {
        return byDateService.getStatsBetweenDate(dates);
    }

    @GetMapping("/allAsin")
    public List<SalesAndTrafficByASINEntity> getAllStatsByASIN() {
        return byASINService.getAllStats();
    }

    @GetMapping("/Asin/{asin}")
    public SalesAndTrafficByASINEntity.SalesAndTrafficByAsin getStatsByASIN(@PathVariable String asin) {
        return byASINService.getStatsByAsin(asin);
    }

    @GetMapping("/Asin/between-asins")
    public List<SalesAndTrafficByASINEntity.SalesAndTrafficByAsin> getStatsBetweenAsin(@RequestParam String[] asins) {
        return byASINService.getStatsBetweenAsin(asins);
    }

    @Scheduled(cron = "10 * * * * *")
    public void schedule(){
        byDateService.deleteAll();
        byASINService.deleteAll();
        dataJsonLoader.loadData();
        byDateService.putCache();
        byASINService.putCache();
    }
}
