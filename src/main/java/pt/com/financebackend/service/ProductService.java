package pt.com.financebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.financebackend.converter.ProductConverter;
import pt.com.financebackend.entity.Product;
import pt.com.financebackend.exception.ObjectNotFoundException;
import pt.com.financebackend.model.dto.ProductDTO;
import pt.com.financebackend.repository.CustomProductRepository;
import pt.com.financebackend.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private CustomProductRepository repository;

    public Product saveProduct(ProductDTO dto){
         return repository.save(ProductConverter.fromDTOToEntity(dto));
    }

    public List<Product> listProductsByDeviceCodeAndCountry(String deviceCode, String country){
        return repository.findByDeviceCodeAndCountry(deviceCode, country);
    }

    public void deleteProduct(Long id){
        repository.deleteById(id);
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> product = repository.findById(id);
        product.ifPresent(p -> {
            repository.save(ProductConverter.fromDTOToEntity(productDTO, p));
        });
        product.orElseThrow(() -> new ObjectNotFoundException("Product not found! id: "+ id));

        return repository.findById(id).get();
    }
}
