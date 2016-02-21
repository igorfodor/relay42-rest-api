package com.relay42.core.tomato.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.relay42.web.serializer.TomatoSerializer;

import java.time.LocalDateTime;

/**
 * Created by teknik on 19-2-16.
 */

@JsonSerialize(using = TomatoSerializer.class)
public class Tomato {

    private String UUID;
    private Integer tomatoes;
    private Provider provider;
    private LocalDateTime timestamp;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Integer getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Integer tomatoes) {
        this.tomatoes = tomatoes;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
