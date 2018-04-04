import {Component, OnInit} from '@angular/core';
import {CommonService} from '../../service/common.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html'
})
export class AboutComponent implements OnInit {

  appVersion = '';

  constructor(private  commonService: CommonService) {
  }

  ngOnInit() {
    this.commonService.getAppVersion().subscribe(
      value => {
        this.appVersion = value.text();
      },
      error => {
        console.log('Error occurred: ' + error);
      }
    );
  }

}
