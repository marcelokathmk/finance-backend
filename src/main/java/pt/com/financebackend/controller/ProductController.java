package pt.com.financebackend.controller;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.financebackend.component.Messages;
import pt.com.financebackend.converter.ProductConverter;
import pt.com.financebackend.entity.Product;
import pt.com.financebackend.model.CreateProductResponse;
import pt.com.financebackend.model.Header;
import pt.com.financebackend.model.ReadProductsResponse;
import pt.com.financebackend.model.dto.ProductDTO;
import pt.com.financebackend.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController extends BaseController{

    @Autowired
    private ProductService service;

    @Autowired
    private Messages messages;

    @PostMapping(value = "/create")
    public ResponseEntity<CreateProductResponse> create(@RequestBody ProductDTO productDTO){
        CreateProductResponse response = new CreateProductResponse();

        Product newProduct = service.saveProduct(productDTO);
        String message = newProduct != null ?
                messages.getMessage("product.created.sucess") :
                messages.getMessage("product.created.error");

        response.setHeader(getHeader("product","create", message));
        response.setProduct(ProductConverter.fromEntityToDTO(newProduct));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<ReadProductsResponse> read(@RequestParam(name = "ds_country") String coutry,
                                                     @RequestParam(name = "ds_device_code") String deviceCode){
        ReadProductsResponse response = new ReadProductsResponse();

        List<Product> products = service.listProductsByDeviceCodeAndCountry(deviceCode, coutry);
        String message = products != null && !products.isEmpty() ?
                messages.getMessage("product.read", products.size()) :
                messages.getMessage("product.read.not_found");

        response.setHeader(getHeader("product","read", message));
        response.setProducts(ProductConverter.fromEntityToDTO(products));
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
    public ResponseEntity<Header> delete(@RequestParam Long id){
        service.deleteProduct(id);
        return ResponseEntity.ok().body(getHeader("product","delete", messages.getMessage("prodcut.delete", id)));
    }
}
