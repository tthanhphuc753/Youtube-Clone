package com.projectt.youtubeclone.DTO;


import com.projectt.youtubeclone.model.Videostatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {
    @Id
    private String id;
    private String title;
    private String description;
    private Set<String> tags;
    private String videoUrl;
    private Videostatus videostatus;
    private String thumbnailUrl;
}
