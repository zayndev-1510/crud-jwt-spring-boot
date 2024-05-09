package com.restapijwt.crudjwt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "blogs")
@Entity(name = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users",unique = false, nullable = false)
    private Users users;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false,length = 100)
    private String author;
    @Column(nullable = false,length = 100)
    private String category;
    @Column(nullable = false)
    private String tags;
    @Column(nullable = false)
    private Integer views;
    @Column(nullable = false)
    private Integer likes;
    @Column(nullable = false)
    private Integer comments;
    @Column(nullable = false)
    private Integer favorites;
    @Column(nullable = true)
    private String image;
    @CreationTimestamp()
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = true)
    private LocalDateTime updatedAt;
}
