package com.projectt.youtubeclone;

import com.projectt.youtubeclone.Repository.VideoRepository;
import com.projectt.youtubeclone.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class YoutubeCloneApplication {

    private final VideoRepository videoRepository;


    public static void main(String[] args) {
        SpringApplication.run(YoutubeCloneApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            videoRepository.save(new Video("1","Java","for beginner","1",100,0,null,null,null,null,null,null));
        };
    }

}
