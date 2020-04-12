package pt.com.financebackend.controller;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.financebackend.converter.ProductConverter;
import pt.com.financebackend.model.CreateProductResponse;
import pt.com.financebackend.model.ReadProductsResponse;
import pt.com.financebackend.model.dto.ProductDTO;
import pt.com.financebackend.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController extends BaseController{

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
    public ResponseEntity<ReadProductsResponse> read(@RequestParam(name = "ds_country") String coutry,
                                                     @RequestParam(name = "ds_device_code") String deviceCode){
        ReadProductsResponse response = new ReadProductsResponse();
        response.setHeader(getHeader("read"));
        response.setProducts(ProductConverter.fromEntityToDTO(service.listProductsByDeviceCodeAndCountry(deviceCode, coutry)));
        return ResponseEntity.ok().body(response);
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
}
