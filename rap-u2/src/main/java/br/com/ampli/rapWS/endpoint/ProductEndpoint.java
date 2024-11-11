package br.com.ampli.rapWS.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.ampli.rapWS.models.GetProductRequest;
import br.com.ampli.rapWS.models.GetProductResponse;
import br.com.ampli.rapWS.repository.ProductRepository;

@Endpoint
public class ProductEndpoint {
	private static final String NAMESPACE_URI = "http://localhost:8080/ws";

	private ProductRepository productRepository;

	@Autowired
	public ProductEndpoint(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetProductRequest")
	@ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productRepository.find(request.getId()));
        return response;
    }
    

}
