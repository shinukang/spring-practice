package org.example.springpractice.upload.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.springpractice.feed.model.Feed;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @ManyToOne
    @JoinColumn(name="feed_id")
    @Setter
    private Feed feed;
}
