import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
var Client = /** @class */ (function () {
    function Client(clientId, clientName) {
        this.clientId = clientId;
        this.clientName = clientName;
    }
    return Client;
}());
export { Client };
var Product = /** @class */ (function () {
    function Product(productId, productName) {
        this.productId = productId;
        this.productName = productName;
    }
    return Product;
}());
export { Product };
var Entity = /** @class */ (function () {
    function Entity(entityId, entityName, product) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.product = product;
    }
    return Entity;
}());
export { Entity };
var HttpClientService = /** @class */ (function () {
    function HttpClientService(httpClient) {
        this.httpClient = httpClient;
    }
    HttpClientService.prototype.getClients = function () {
        return this.httpClient.get('http://localhost:9099/dmt/client/getAll');
    };
    HttpClientService.prototype.getProducts = function (clientId) {
        return this.httpClient.get('http://localhost:9099/dmt/product/getProductForClient/' + clientId);
    };
    HttpClientService.prototype.getEntities = function (productId) {
        return this.httpClient.get('http://localhost:9099/dmt/module/getModulesForProduct/' + productId);
    };
    HttpClientService.prototype.getFields = function (entityId) {
        return this.httpClient.get('http://localhost:9099/dmt/fields/getFieldsForModule/' + entityId);
    };
    HttpClientService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClient])
    ], HttpClientService);
    return HttpClientService;
}());
export { HttpClientService };
//# sourceMappingURL=http-client.service.js.map