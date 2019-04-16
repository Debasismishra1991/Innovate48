import * as tslib_1 from "tslib";
import { NgModule } from "@angular/core";
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatCardModule, MatDialogModule, MatInputModule, MatTableModule, MatToolbarModule, MatMenuModule, MatIconModule, MatProgressSpinnerModule } from '@angular/material';
var CustomMaterialModule = /** @class */ (function () {
    function CustomMaterialModule() {
    }
    CustomMaterialModule = tslib_1.__decorate([
        NgModule({
            imports: [
                CommonModule,
                MatToolbarModule,
                MatButtonModule,
                MatCardModule,
                MatInputModule,
                MatDialogModule,
                MatTableModule,
                MatMenuModule,
                MatIconModule,
                MatProgressSpinnerModule
            ],
            exports: [
                CommonModule,
                MatToolbarModule,
                MatButtonModule,
                MatCardModule,
                MatInputModule,
                MatDialogModule,
                MatTableModule,
                MatMenuModule,
                MatIconModule,
                MatProgressSpinnerModule
            ],
        })
    ], CustomMaterialModule);
    return CustomMaterialModule;
}());
export { CustomMaterialModule };
//# sourceMappingURL=material.module.js.map