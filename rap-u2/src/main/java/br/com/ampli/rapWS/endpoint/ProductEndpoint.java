package br.com.ampli.rapWS.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.ampli.rapWS.repository.ProductRepository;
import br.com.ampli.rapWS.response.GetProductResponse;
import br.com.ampli.rapWS.response.GetProductsResponse;

@Endpoint
public class ProductEndpoint {
	private static final String NAMESPACE_URI = "http://ampli.com.br/rapWS";

	private ProductRepository productRepository;

	@Autowired
	public ProductEndpoint(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProduct")
	@ResponsePayload
    public GetProductResponse getProduct(@RequestPayload Integer id) {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productRepository.find(id));
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProducts")
	@ResponsePayload
	public GetProductsResponse getAllProducts() {
		GetProductsResponse response = new GetProductsResponse();
        response.setProducts(productRepository.findAll());
		return response;
	}
}
