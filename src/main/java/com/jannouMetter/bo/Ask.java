package com.jannouMetter.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ask")
public class Ask {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "entitled")
    private String entitled;

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizz_id", nullable = false, updatable = false)
    private Quizz quizz;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ask")
    private List<Answer> answers = new ArrayList<>();

    @Column(name = "total_polling")
    private int total_polling;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getTotal_polling() {
        return total_polling;
    }

    public void setTotal_polling(int total_polling) {
        this.total_polling = total_polling;
    }

    public void addPolling() { this.total_polling++; }
}
