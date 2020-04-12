package pt.com.financebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.financebackend.converter.ProductConverter;
import pt.com.financebackend.entity.Product;
import pt.com.financebackend.model.dto.ProductDTO;
import pt.com.financebackend.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(ProductDTO dto){
         return repository.save(ProductConverter.fromDTOToEntity(dto));
    }
}
