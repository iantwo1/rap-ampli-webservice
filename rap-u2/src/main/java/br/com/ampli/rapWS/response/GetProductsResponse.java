package br.com.ampli.rapWS.response;

import java.util.Collection;

import br.com.ampli.rapWS.entity.Product;

public class GetProductsResponse {
    private Collection<Product> products;

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
