package pt.com.financebackend.converter;

import org.springframework.beans.BeanUtils;
import pt.com.financebackend.entity.Product;
import pt.com.financebackend.model.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    public static ProductDTO fromEntityToDTO(Product product){
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

    public static Product fromDTOToEntity(ProductDTO dto){
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }

    public static List<ProductDTO> fromEntityToDTO(List<Product> products){
        return products.stream().map(
                product -> fromEntityToDTO(product)).collect(Collectors.toList());
    }
}
