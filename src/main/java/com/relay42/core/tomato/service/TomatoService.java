package com.relay42.core.tomato.service;

import com.relay42.core.tomato.domain.Tomato;

import java.util.List;

/**
 * Created by teknik on 20-2-16.
 */

public interface TomatoService {

    List<Tomato> getAllTomatoes();

    List<Tomato> getTomatoes(Integer limit);



}
