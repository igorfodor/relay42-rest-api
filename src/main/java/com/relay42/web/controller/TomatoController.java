package com.relay42.web.controller;

/**
 * Created by teknik on 19-2-16.
 */

import com.relay42.core.tomato.domain.Tomato;
import com.relay42.core.tomato.service.TomatoService;
import com.relay42.web.exception.TomatoBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tomatoes")
public class TomatoController {

    @Value("${controller.tomato.listlimit}")
    private Integer tomatoListLimit;

    @Autowired
    TomatoService tomatoService;

    @RequestMapping(path = "/data", method = RequestMethod.GET)
    public  @ResponseBody
    List<Tomato> retrieveTomatoes(@RequestParam(required = false) Integer size) throws TomatoBadRequestException {


        if (size != null ) {
            if (size > tomatoListLimit) {
                throw new TomatoBadRequestException("Maximum size is 1000!");
            } else if (size < 1) {
                throw new TomatoBadRequestException("Size must be higher then 0!");
            }
            return tomatoService.getTomatoes(size);
        }

        return tomatoService.getAllTomatoes();
    }




}
