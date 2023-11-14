package com.TODOList.Todo.list.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "todo")
public class Todo {

    // permet d'indiquer que l'id est l'identifiant unique de l'entité
    @Id
    //indique que la BD générera une nouvelle valeur chaque fois qu'une nouvelle ligne est insérée
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column
    private String name;
    @Column
    private String description;

    public Todo(){}

    public Todo(int id, String name, String description){
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
