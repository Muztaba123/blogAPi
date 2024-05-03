package com.blogApi.blogApi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="tables",

        uniqueConstraints={@UniqueConstraint(columnNames={"titles"})}
)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="titles",nullable = false)
    private String title;
    @Column(name="descriptions", nullable = false)
    private String description;
    @Lob
    @Column(name="content",nullable = false)
    private String content;
    @OneToMany(mappedBy ="post", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comment> comments=new HashSet<>();

}
