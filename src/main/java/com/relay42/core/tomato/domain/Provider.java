package com.relay42.core.tomato.domain;

/**
 * Created by teknik on 20-2-16.
 */
public enum Provider {
    Heinz("Heinz"), Hunts("Hunt's"), DelMonte("Del Monte"), LeOlGranma("Le Ol'Granma");

    private String name;

    Provider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
