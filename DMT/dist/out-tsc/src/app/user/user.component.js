import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';
import { Router } from '@angular/router';
var UserComponent = /** @class */ (function () {
    function UserComponent(httpClientService, router) {
        this.httpClientService = httpClientService;
        this.router = router;
    }
    UserComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.httpClientService.getClients().subscribe(function (clientResponse) { return _this.handleSuccessfulResponse(clientResponse); });
    };
    UserComponent.prototype.handleSuccessfulResponse = function (clientResponse) {
        this.clients = clientResponse;
    };
    UserComponent.prototype.loadProducts = function (clientId) {
        var _this = this;
        this.httpClientService.getProducts(clientId).subscribe(function (productResponse) { return _this.handleSuccessProductResponse(productResponse); });
    };
    UserComponent.prototype.handleSuccessProductResponse = function (productResponse) {
        this.products = productResponse;
    };
    UserComponent.prototype.next = function (productId) {
        this.router.navigate(['mapping'], { queryParams: { product: productId } });
    };
    UserComponent = tslib_1.__decorate([
        Component({
            selector: 'app-user',
            templateUrl: './user.component.html',
            styleUrls: ['./user.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClientService, Router])
    ], UserComponent);
    return UserComponent;
}());
export { UserComponent };
//# sourceMappingURL=user.component.js.map