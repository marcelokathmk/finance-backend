package pt.com.financebackend.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import pt.com.financebackend.entity.Product;
import pt.com.financebackend.model.dto.ProductDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductConverter {

    public static ProductDTO fromEntityToDTO(Product product){
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product, dto, "");
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

    public static Product fromDTOToEntity(ProductDTO dto, Product product){
        BeanUtils.copyProperties(dto, product, getNullPropertiesToIgnore(dto));
        return product;
    }

    private static String[] getNullPropertiesToIgnore(ProductDTO source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null){
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
