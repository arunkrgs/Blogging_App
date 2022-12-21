package com.blog.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        private String url;

        @Lob
        @Column(nullable = false)
        private String content;
        private String shortDescription;

        @CreationTimestamp
        private LocalDateTime createdOn;

        @UpdateTimestamp
        private LocalDateTime updatedOn;

// (post)ONE to MANY(Comment) but Comment can be many so we hv to store in
// "Set" and mappedBy post variable.
// "cascade" helps us that when we are removing the Comment, the Comment details also should be removed from the post.
        @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
        private Set<Comment> comments = new HashSet<>();
}
