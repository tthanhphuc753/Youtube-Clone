package com.projectt.youtubeclone.service;

import com.projectt.youtubeclone.DTO.VideoDTO;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    void uploadVideo(MultipartFile file);

    VideoDTO editVideo(VideoDTO videoDTO);

    String uploadThumbnail(MultipartFile file, String videoId);
}
