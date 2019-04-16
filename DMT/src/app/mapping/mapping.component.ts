import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { Router } from '@angular/router';
import { HttpClientService, Mapping, Field } from '../service/http-client.service';
import * as XLSX from 'ts-xlsx';
import { findSafariExecutable } from 'selenium-webdriver/safari';

@Component({
  selector: 'app-mapping',
  templateUrl: './mapping.component.html',
  styleUrls: ['./mapping.component.css']
})
export class MappingComponent implements OnInit {

  productId: string;
  entities: string[];
  fields: string[];
  fieldVal: string[];
  mappings: Mapping[] = [];
  clientId: string;
  jsonObj: any;

  arrayBuffer: any;
  file: File;

  constructor(private httpClientService: HttpClientService, private router: ActivatedRoute,
    private navRouter :Router) {
    this.router.queryParams.subscribe(params => {
      this.productId = params['product'];
      this.clientId = params['client'];
    });
  }

  ngOnInit() {
    this.httpClientService.getEntities(this.productId).subscribe(
      entityResponse => this.handleSuccessfulResponse(entityResponse),
    );
  }

  handleSuccessfulResponse(entityResponse) {
    this.entities = entityResponse;
  }

  loadFields(moduleId: string) {
    this.httpClientService.getFields(moduleId).subscribe(
      fieldResponse => this.handleSuccessFieldResponse(fieldResponse),
    );
  }

  handleSuccessFieldResponse(fieldResponse) {
    this.fields = fieldResponse;
  }

  incomingfile(event) {
    this.file = event.target.files[0];
  }

  Upload() {
    let fileReader = new FileReader();
    fileReader.onload = (e) => {
      this.arrayBuffer = fileReader.result;
      var data = new Uint8Array(this.arrayBuffer);
      var arr = new Array();
      for (var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
      var bstr = arr.join("");
      var workbook = XLSX.read(bstr, { type: "binary" });
      var first_sheet_name = workbook.SheetNames[0];
      var worksheet = workbook.Sheets[first_sheet_name];
      this.jsonObj = XLSX.utils.sheet_to_json(worksheet, { raw: true });
      var firstObject = this.jsonObj[0];
      this.fieldVal = [];
      
      Object.keys(firstObject).forEach(k => {
        this.fieldVal.push(k);
      });

    }
    fileReader.readAsArrayBuffer(this.file);
  }

  loadMapping(fieldVal: string, field: Field) {
    this.mappings.push(new Mapping(field, fieldVal));
  }

  save(moduleId: string) {
    this.httpClientService.postFieldMapping(this.productId, this.clientId, moduleId, this.mappings).subscribe();
    this.execute(this.productId, this.clientId, moduleId);
  }

  execute(productId: string, clientId: string, moduleId : string){
    this.httpClientService.execute(productId, clientId, moduleId, this.jsonObj).subscribe();
    this.navRouter.navigate(['success']);
  }
}