package br.com.ampli.rapWS.response;

import br.com.ampli.rapWS.entity.Product;

public class GetProductResponse {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
