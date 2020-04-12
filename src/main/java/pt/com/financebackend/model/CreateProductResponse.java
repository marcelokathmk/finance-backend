package pt.com.financebackend.model;

import lombok.Getter;
import lombok.Setter;
import pt.com.financebackend.model.dto.ProductDTO;

@Getter
@Setter
public class CreateProductResponse {

    private Header header;

    private ProductDTO product;
}
