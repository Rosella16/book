package com.example.bookuser.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID authorId;
    private String authorName;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> book;
}
