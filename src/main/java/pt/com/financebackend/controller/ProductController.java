package pt.com.financebackend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.financebackend.component.Messages;
import pt.com.financebackend.converter.ProductConverter;
import pt.com.financebackend.entity.Product;
import pt.com.financebackend.model.Header;
import pt.com.financebackend.model.ProductResponse;
import pt.com.financebackend.model.ReadProductsResponse;
import pt.com.financebackend.model.dto.ProductDTO;
import pt.com.financebackend.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@Api(tags = {"Product"})
public class ProductController extends BaseController{

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @Autowired
    private Messages messages;

    /**
     * Operation responsible for create a new product.
     * @param productDTO - Request body, that contains fields necessaries to create a product.
     * @return product created.
     */
    @ApiOperation(value = "Operation responsible for create a new product.")
    @PostMapping(value = "/create")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductDTO productDTO){
        logger.info("Starting the process to create a new product.");
        ProductResponse response = new ProductResponse();

        Product newProduct = service.saveProduct(productDTO);
        String message = newProduct != null ?
                messages.getMessage("product.created.sucess") :
                messages.getMessage("product.created.error");

        response.setHeader(getHeader("product","create", message));
        response.setProduct(ProductConverter.fromEntityToDTO(newProduct));
        logger.info("Product id "+ newProduct.getId() +" created sucessfully. Process finished.");
        return ResponseEntity.ok().body(response);
    }

    /**
     * Operation responsible to read products, that match with parameters received.
     * @param coutry - Country of the Product.
     * @param deviceCode - Device code of the Product.
     * @return products found or message that products not found.
     */
    @ApiOperation(value = "Operation responsible to read products, that match with parameters received.")
    @GetMapping(value = "/read")
    public ResponseEntity<ReadProductsResponse> read(@RequestParam(name = "ds_country") String coutry,
                                                     @RequestParam(name = "ds_device_code") String deviceCode){
        logger.info("Starting the process to read products. Parameters received:");
        logger.info("ds_country: "+ coutry);
        logger.info("ds_device_code: "+ deviceCode);
        ReadProductsResponse response = new ReadProductsResponse();

        List<Product> products = service.listProductsByDeviceCodeAndCountry(deviceCode, coutry);
        String message = products != null && !products.isEmpty() ?
                messages.getMessage("product.read", products.size()) :
                messages.getMessage("product.read.not_found");

        response.setHeader(getHeader("product","read", message));
        response.setProducts(ProductConverter.fromEntityToDTO(products));
        logger.info(products.size() +" product(s) found. Process finished.");
        return ResponseEntity.ok().body(response);
    }

    /**
     * Operation responsible to update the fields of the specific product, with identifier is passed by parameter.
     * @param id - Product identification
     * @param productDTO - Request body, contain field values that are gonna change in the product.
     * @return product updated, or throw exception when product identifier is not valid.
     */
    @ApiOperation(value = "Operation responsible to update the fields of the specific product, with identifier is passed by parameter.")
    @PutMapping(value = "/update")
    public ResponseEntity<ProductResponse> update(@RequestParam Long id, @RequestBody ProductDTO productDTO){
        logger.info("Starting process to update product. Product identifier: "+ id);
        ProductResponse response = new ProductResponse();

        Product productUpdated = service.updateProduct(id, productDTO);
        String message = messages.getMessage("product.udpate.sucess", productUpdated.getId());

        response.setHeader(getHeader("product","update", message));
        response.setProduct(ProductConverter.fromEntityToDTO(productUpdated));
        logger.info("Product "+ id + " updated sucessfully. Process finished.");
        return ResponseEntity.ok().body(response);
    }

    /**
     * Operation responsible to delete logically the product, changing his status to 0 in the database.
     * @param id - Product identification
     * @return operation result.
     */
    @ApiOperation(value = "Operation responsible to delete logically the product, changing his status to 0 in the database.")
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Header> delete(@RequestParam Long id){
        logger.info("Starting process to delete product. Product identifier: "+ id);
        service.deleteProduct(id);
        logger.info("Product "+ id + " deleted. Process finished.");
        return ResponseEntity.ok().body(getHeader("product","delete", messages.getMessage("prodcut.delete", id)));
    }
}
