package com.jannouMetter.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "anwser")
public class Answer {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "entitled")
    private String entitled;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ask_id", nullable = false, updatable = false)
    private Ask ask;

    @Column(name = "polling")
    private int polling;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    public Ask getAsk() {
        return ask;
    }

    public void setAsk(Ask ask) {
        this.ask = ask;
    }

    public int getPolling() {
        return polling;
    }

    public void setPolling(int polling) {
        this.polling = polling;
    }

    public void addPolling() { this.polling++; }
}
