package pt.com.financebackend.model;

import lombok.Getter;
import lombok.Setter;
import pt.com.financebackend.model.dto.ProductDTO;

@Getter
@Setter
public class ProductResponse {

    private Header header;

    private ProductDTO product;
}
