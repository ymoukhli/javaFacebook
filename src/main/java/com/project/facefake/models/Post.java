package com.project.facefake.models;

import com.project.facefake.enums.Reaction;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
    private Date creation_time;

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    @Transient
    private Map<Reaction, Integer> reactions;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
