package com.projectt.youtubeclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Document(value = "Video")
@Data
public class Video {

    @Id
    private String id;
    private String title;
    private String description;
    private String userId;
    private Integer likes;
    private Integer disLikes;
    private Set<String> tags;
    private String videoUrl;
    private Videostatus videostatus;
    private Integer viewCount;
    private String thumbnailUrl;
    private List<Comment> commentList;

}
