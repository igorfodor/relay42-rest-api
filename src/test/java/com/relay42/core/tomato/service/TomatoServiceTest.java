package com.relay42.core.tomato.service;

import com.relay42.core.tomato.domain.Tomato;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by teknik on 21-2-16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-core-config.xml")
public class TomatoServiceTest {

    @Autowired
    private TomatoService tomatoService;


    @Test
    public void testGetAllTomatoesSize() throws Exception {
        List<Tomato> tomatoList = tomatoService.getAllTomatoes();
        assertSame(3, tomatoList.size());
    }

    @Test
    public void testTomatoListOrdering() throws Exception {
        List<Tomato> tomatoList = tomatoService.getAllTomatoes();
        for (int i = 0; i < tomatoList.size()-1; i++) {
            Tomato t1 = tomatoList.get(i);
            Tomato t2 = tomatoList.get(i+1);
            assertTrue(t1.getTimestamp().isBefore(t2.getTimestamp()) ||  t1.getTimestamp().isEqual(t2.getTimestamp()));
        }
    }

    @Test
    public void testTomatoListOrderingLargeList() throws Exception {
        List<Tomato> tomatoList = tomatoService.getTomatoes(100);
        for (int i = 0; i < tomatoList.size()-1; i++) {
            Tomato t1 = tomatoList.get(i);
            Tomato t2 = tomatoList.get(i+1);
            assertTrue(t1.getTimestamp().isBefore(t2.getTimestamp()) ||  t1.getTimestamp().isEqual(t2.getTimestamp()));
        }
    }


    @Test
    public void testTomatoDatesAreWithinRange() throws Exception {
        List<Tomato> tomatoList = tomatoService.getTomatoes(100);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime beginTime = LocalDateTime.parse("2016-01-01 00:00:00", formatter);
        LocalDateTime endTime = LocalDateTime.now();

        for (int i = 0; i < tomatoList.size(); i++) {
            Tomato t1 = tomatoList.get(i);
            assertTrue(t1.getTimestamp().isAfter(beginTime) && t1.getTimestamp().isBefore(endTime));
        }
    }

    @Test
    public void testTomatoesPropertyIsWithinRange() throws Exception {
        List<Tomato> tomatoList = tomatoService.getTomatoes(100);
        for (int i = 0; i < tomatoList.size(); i++) {
            Tomato t1 = tomatoList.get(i);
            assertTrue(t1.getTomatoes() >=1  && t1.getTomatoes() <= 2000);
        }
    }





}