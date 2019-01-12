package com.jannouMetter.bo;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quizz")
public class Quizz {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "currentAsk")
    private Integer currentAsk;

    @Column(name = "state")
    private String state;

    @Column(name = "nbContributors")
    private Integer nbContributors;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "quizz")
    @OrderBy("id ASC")
    private List<Ask> asks = new ArrayList<>();

    public void next() {
        if (!asks.isEmpty() && this.currentAsk < asks.size()) {
            if ("ToDo".equals(state)) {
                this.setState("InProgress");
            }
            currentAsk++;
        } else {
            this.state = "Done";
        }
    }

    public void subscribe() {
        this.nbContributors++;
    }

    public void unsubscribe() {
        if (nbContributors > 0) {
            this.nbContributors--;
        }
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

    public List<Ask> getAsks() {
        return asks;
    }

    public void setAsks(List<Ask> asks) {
        this.asks = asks;
    }

    public Integer getCurrentAsk() {
        return currentAsk;
    }

    public void setCurrentAsk(Integer currentAsk) {
        this.currentAsk = currentAsk;
    }

    public Integer getNbContributors() {
        return nbContributors;
    }

    public void setNbContributors(Integer nbContributors) {
        this.nbContributors = nbContributors;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
