import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class Client{
  constructor(public clientId:string,public clientName:string){}
}
export class Product{
  constructor(public productId:string,public productName:string){}
}
export class Entity{
  constructor(public entityId:string,public entityName:string, public product:Product){}
}

export class Field{
  fieldId : string;
  fieldName : string;
  fieldDesc : string;
  constructor(fieldId:string, fieldName:string, fieldDesc : string){
    this.fieldId = fieldId;
    this.fieldName = fieldName;
    this.fieldDesc = fieldDesc
  }
 
}

export class Mapping{
  field: Field;
  fieldValue:string
  constructor(field: Field,fieldValue: string){
    this.field = field;
    this.fieldValue = fieldValue;
  }
  
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient:HttpClient) { }

  getClients(){
    return this.httpClient.get<Client[]>('http://localhost:9099/dmt/client/getAll');
  }

  getProducts(clientId:string){
      return this.httpClient.get<Product[]>('http://localhost:9099/dmt/product/getProductForClient/'+clientId);
  }

  getEntities(productId:String){
    return this.httpClient.get<Entity[]>('http://localhost:9099/dmt/module/getModulesForProduct/'+productId);
  }

  getFields(moduleId:String){
    return this.httpClient.get<Field[]>('http://localhost:9099/dmt/fields/getFieldsForModule/'+moduleId);
  }

  postFieldMapping(productId:string,clientId:string,moduleId:string,mappings:Mapping[]){
    return this.httpClient.post('http://localhost:9099/dmt/mapping/saveMappings/' + productId + "/" + clientId + "/"+ moduleId,mappings);
  }

  execute(productId: string, clientId : string, moduleId: string, jsonObj: any){
    return this.httpClient.post('http://localhost:9099/dmt/execute/process/' + productId + "/" + clientId + "/"+ moduleId,jsonObj);
  }
}