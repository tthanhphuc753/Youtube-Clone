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
@Document(value = "User")
@Data
public class User {
    @Id
    private String id;
    private String lastName;
    private String firstName;
    private String fullName;
    private String email;
    private Set<String> subscribedToUsers;
    private Set<String> subscribers;
    private List<String> videoHistory;
    private Set<String> likedVideos;
    private Set<String> disLikedVideos;

}
