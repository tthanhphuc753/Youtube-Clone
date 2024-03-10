package com.projectt.youtubeclone.service;

import com.projectt.youtubeclone.DTO.VideoDTO;
import com.projectt.youtubeclone.Repository.VideoRepository;
import com.projectt.youtubeclone.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final S3Service s3Service;
    private final VideoRepository videoRepository;

    @Override
    public void uploadVideo(MultipartFile file) {
        String videoUrl = s3Service.uploadFile(file);
        var video = new Video();
        video.setVideoUrl(videoUrl);
        videoRepository.save(video);


    }

    @Override
    public VideoDTO editVideo(VideoDTO videoDTO) {
        var savedVideo = getVideoById(videoDTO.getId());

        savedVideo.setTitle(videoDTO.getTitle());
        savedVideo.setDescription(videoDTO.getDescription());
        savedVideo.setTags(videoDTO.getTags());
        savedVideo.setVideostatus(videoDTO.getVideostatus());
        savedVideo.setThumbnailUrl(videoDTO.getThumbnailUrl());

        videoRepository.save(savedVideo);
        return videoDTO;


    }

    @Override
    public String uploadThumbnail(MultipartFile file, String videoId) {
        var savedVideo = getVideoById(videoId);
        String thumbnailURL = s3Service.uploadFile(file);
        savedVideo.setThumbnailUrl(thumbnailURL);
        videoRepository.save(savedVideo);
        return thumbnailURL;
    }

    Video getVideoById(String videoId) {
        return videoRepository.findById(videoId).orElseThrow(() ->
                new IllegalArgumentException("Cannot find video by id " + videoId));
    }
}
