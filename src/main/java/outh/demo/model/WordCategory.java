package outh.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class WordCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategory;

    private String nameCategory;

    @JsonIgnore
    @OneToOne(mappedBy = "wordCategory", cascade = CascadeType.MERGE)
    private Word word;

    public WordCategory(String nameCategory){
        this.nameCategory = nameCategory;
    }
    public WordCategory() {
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long id_category) {
        this.idCategory = id_category;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String name_category) {
        this.nameCategory = name_category;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }


}
