package com.relay42.core.tomato.service;

import com.relay42.core.tomato.domain.Provider;
import com.relay42.core.tomato.domain.Tomato;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by teknik on 20-2-16.
 */
@Service
public class TomatoService {
    public static final int MIN_TOMATOES = 1;
    public static final int MAX_TOMATOES = 2000;

    private Random rand = new Random();


    public List<Tomato> getAllTomatoes() {
        return getTomatoes(3);
    }

    public List<Tomato> getTomatoes(Integer limit) {
        List<Tomato> tomatoList = new ArrayList<>();

        for (int i= 1; i<=limit; i ++) {
            Tomato tomato = new Tomato();
            tomato.setProvider(this.randomEnum(Provider.class));
            tomato.setTomatoes(randInt(MIN_TOMATOES, MAX_TOMATOES));
            tomato.setUUID(UUID.randomUUID().toString());
            tomato.setTimestamp(getRandomDateTime());
            tomatoList.add(tomato);
        }

        tomatoList.sort((Tomato t1, Tomato t2) -> t1.getTimestamp().compareTo(t2.getTimestamp()));
        return tomatoList;
    }


    private int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


    private LocalDateTime getRandomDateTime () {
        long beginTime = Timestamp.valueOf("2016-01-01 00:00:00").getTime();
        long endTime = Timestamp.valueOf(LocalDateTime.now()).getTime();
        long diff = endTime - beginTime + 1;
        return new Timestamp(beginTime + (long) (Math.random() * diff)).toLocalDateTime();
    }

    private <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = rand.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }


}
