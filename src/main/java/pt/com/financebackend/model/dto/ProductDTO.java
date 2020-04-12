package pt.com.financebackend.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private String imageUrl;

    private String manufacturer;

    private String category;

    private String family;

    private String deviceCode;

    private Boolean status;

    private Date createdAt;

    private Date updatedAt;

    private String country;

    private String msrp;

    private String currency;

    private String tags;

    private String specs;
}
