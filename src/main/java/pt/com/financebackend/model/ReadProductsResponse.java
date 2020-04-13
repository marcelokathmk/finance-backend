package pt.com.financebackend.model;

import lombok.Getter;
import lombok.Setter;
import pt.com.financebackend.model.dto.ProductDTO;

import java.util.List;

@Getter
@Setter
public class ReadProductsResponse {

    private Header header;

    private List<ProductDTO> products;
}
