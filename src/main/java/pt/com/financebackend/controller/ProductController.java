package pt.com.financebackend.controller;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import pt.com.financebackend.converter.ProductConverter;
import pt.com.financebackend.model.CreateProductResponse;
import pt.com.financebackend.model.Header;
import pt.com.financebackend.model.dto.ProductDTO;
import pt.com.financebackend.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController{

    @Autowired
    private ProductService service;

    @PostMapping(value = "/create")
    public ResponseEntity<CreateProductResponse> create(@RequestBody ProductDTO productDTO){
        CreateProductResponse response = new CreateProductResponse();
        response.setHeader(getHeader("create"));
        response.setProduct(ProductConverter.fromEntityToDTO(service.saveProduct(productDTO)));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<Void> read(@RequestParam(name = "ds_country") String coutry,
                                     @RequestParam(name = "ds_device_code") String deviceCode){
        try {
            throw new ExecutionControl.NotImplementedException("Implement me!");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Void> update(@RequestBody ProductDTO productDTO){
        try {
            throw new ExecutionControl.NotImplementedException("Implement me!");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id){
        try {
            throw new ExecutionControl.NotImplementedException("Implement me!");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }

    private Header getHeader(String function){
        Header header = new Header();
        header.setFunction(function);
        header.setService("product");
        header.setSession(RequestContextHolder.currentRequestAttributes().getSessionId());
        header.setVersion("1.0");
        return header;
    }
}