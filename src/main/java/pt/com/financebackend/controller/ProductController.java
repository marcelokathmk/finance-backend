package pt.com.financebackend.controller;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.financebackend.model.dto.ProductDTO;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @PostMapping(value = "/create")
    public ResponseEntity<Void> create(@RequestBody ProductDTO productDTO){
        try {
            throw new ExecutionControl.NotImplementedException("Implement me!");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
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
}
