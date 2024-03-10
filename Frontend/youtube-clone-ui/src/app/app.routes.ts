import {Routes} from '@angular/router';
import {UploadVideoComponent} from "./upload-video/upload-video.component";


export const routes: Routes = [
  {
    path: 'upload-video', component: UploadVideoComponent, title: 'Upload Video'
  }
];
