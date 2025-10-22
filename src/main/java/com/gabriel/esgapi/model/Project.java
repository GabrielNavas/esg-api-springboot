package com.gabriel.esgapi.model;

public class Project {
    private Long id;
    private String name;
    private String pillar;
    private Double score;

    public Project() {
    }

    public Project(Long id, String name, String pillar, Double score) {
        this.id = id;
        this.name = name;
        this.pillar = pillar;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPillar() {
        return pillar;
    }

    public void setPillar(String pillar) {
        this.pillar = pillar;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
