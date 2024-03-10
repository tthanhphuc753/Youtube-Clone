import {Component} from '@angular/core';
import {FileSystemDirectoryEntry, FileSystemFileEntry, NgxFileDropEntry, NgxFileDropModule} from 'ngx-file-drop';
import {MatButton} from "@angular/material/button";
import {NgIf} from "@angular/common";
import {VideoService} from "../video.service";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-upload-video',
  templateUrl: 'upload-video.component.html',
  imports: [
    NgxFileDropModule,
    MatButton,
    NgIf,
    HttpClientModule
  ],
  standalone: true,
  styleUrls: ['upload-video.component.css']
})
export class UploadVideoComponent {

  public files: NgxFileDropEntry[] = [];
  fileUploaded: boolean = false;
  fileEntry: FileSystemFileEntry | undefined;

  constructor(private videoService: VideoService) {
  }

  public dropped(files: NgxFileDropEntry[]) {
    this.files = files;
    for (const droppedFile of files) {

      // Is it a file?
      if (droppedFile.fileEntry.isFile) {
        this.fileEntry = droppedFile.fileEntry as FileSystemFileEntry;
        this.fileEntry.file((file: File) => {

          // Here you can access the real file
          console.log(droppedFile.relativePath, file);
          this.fileUploaded = true;

          /**
           // You could upload it like this:
           const formData = new FormData()
           formData.append('logo', file, relativePath)

           // Headers
           const headers = new HttpHeaders({
           'security-token': 'mytoken'
           })

           this.http.post('https://mybackend.com/api/upload/sanitize-and-save-logo', formData, { headers: headers, responseType: 'blob' })
           .subscribe(data => {
           // Sanitized logo returned from backend
           })
           **/

        });
      } else {
        // It was a directory (empty directories are added, otherwise only files)
        const fileEntry = droppedFile.fileEntry as FileSystemDirectoryEntry;
        console.log(droppedFile.relativePath, fileEntry);
      }
    }
  }

  public fileOver(event: any) {
    console.log(event);
  }

  public fileLeave(event: any) {
    console.log(event);
  }

  uploadVideo() {
    if (this.fileEntry !== undefined) {
      console.log(this.fileEntry);

      this.fileEntry.file(file => {
        this.videoService.uploadVideo(file).subscribe(data => {
          console.log("Uploaded successfully")
        });

      })

    }
  }
}
