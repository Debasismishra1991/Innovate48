import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  clients: string[];
  products: string[];

  constructor(private httpClientService: HttpClientService, private router: Router) { }

  ngOnInit() {
    this.httpClientService.getClients().subscribe(
      clientResponse => this.handleSuccessfulResponse(clientResponse),
    );
  }

  handleSuccessfulResponse(clientResponse) {
    this.clients = clientResponse;
  }

  loadProducts(clientId: string) {
    this.httpClientService.getProducts(clientId).subscribe(
      productResponse => this.handleSuccessProductResponse(productResponse),
    );
  }

  handleSuccessProductResponse(productResponse) {
    this.products = productResponse;
  }

  next(productId: string,clientId: string): void {
    this.router.navigate(['mapping'], { queryParams: { product: productId, client: clientId } });
  }

}
