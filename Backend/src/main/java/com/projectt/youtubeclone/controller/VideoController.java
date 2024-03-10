package com.projectt.youtubeclone.controller;


import com.projectt.youtubeclone.DTO.VideoDTO;
import com.projectt.youtubeclone.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/video")
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/upload-video")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadVideo(@RequestParam("file") MultipartFile file) {
        videoService.uploadVideo(file);
    }

    @PostMapping("/upload-thumbnail")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadThumbnail(@RequestParam("file") MultipartFile file, @RequestParam("videoId") String videoId) {
        return videoService.uploadThumbnail(file,videoId);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public VideoDTO editVideodata(@RequestBody VideoDTO videoDTO ){
        return videoService.editVideo(videoDTO);
    }

}
