package com.example.demo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covi19Confirmed {

    public static final String CON_CONFIRMED_RUL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";


    private DataRepo dataRepo;

    @Autowired
    public Covi19Confirmed(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    Covi19Confirmed(){

    }


    @EventListener(ApplicationReadyEvent.class)
    public void get() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(CON_CONFIRMED_RUL,String.class);

        StringReader stringReader = new StringReader(forObject);
        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);


        for (CSVRecord strings : parse){
           double lat = Double.parseDouble(strings.get("Lat"));
           double lon = Double.parseDouble(strings.get("Long"));
           String text = strings.get("3/15/20");
            dataRepo.addPoint(new Point(lat,lon,text));
        }
    }

}
