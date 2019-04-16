import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClientService } from '../service/http-client.service';
var MappingComponent = /** @class */ (function () {
    function MappingComponent(httpClientService, router) {
        var _this = this;
        this.httpClientService = httpClientService;
        this.router = router;
        this.router.queryParams.subscribe(function (params) {
            _this.productId = params['product'];
        });
    }
    MappingComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.httpClientService.getEntities(this.productId).subscribe(function (entityResponse) { return _this.handleSuccessfulResponse(entityResponse); });
    };
    MappingComponent.prototype.handleSuccessfulResponse = function (entityResponse) {
        this.entities = entityResponse;
        alert("Entities : " + this.entities.toString);
    };
    MappingComponent.prototype.loadFields = function (entityId) {
        var _this = this;
        this.httpClientService.getFields(entityId).subscribe(function (fieldResponse) { return _this.handleSuccessFieldResponse(fieldResponse); });
    };
    MappingComponent.prototype.handleSuccessFieldResponse = function (fieldResponse) {
        this.entities = fieldResponse;
    };
    MappingComponent = tslib_1.__decorate([
        Component({
            selector: 'app-mapping',
            templateUrl: './mapping.component.html',
            styleUrls: ['./mapping.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClientService, ActivatedRoute])
    ], MappingComponent);
    return MappingComponent;
}());
export { MappingComponent };
//# sourceMappingURL=mapping.component.js.map