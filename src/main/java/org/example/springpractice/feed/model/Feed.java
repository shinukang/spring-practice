package org.example.springpractice.feed.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springpractice.common.model.BaseEntity;
import org.example.springpractice.upload.model.Upload;
import org.example.springpractice.user.model.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feed extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User writer;
    @OneToMany(mappedBy="feed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Upload> images = new ArrayList<>();

    public void addImage(Upload image) {
        this.images.add(image);
        image.setFeed(this);
    }
}
