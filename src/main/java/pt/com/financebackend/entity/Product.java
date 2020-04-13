package pt.com.financebackend.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id_product")
    private Long id;

    @Column(name = "ds_product", nullable = false)
    private String name;

    @Column(name = "ds_image_url")
    private String imageUrl;

    @Column(name = "ds_manufacturer")
    private String manufacturer;

    @Column(name = "ds_category")
    private String category;

    @Column(name = "ds_family")
    private String family;

    @Column(name = "ds_device_code", nullable = false)
    private String deviceCode;

    @Column(name = "is_status", columnDefinition = "INT(1) NOT NULL DEFAULT 1")
    private Boolean status;

    @Column(name = "dt_created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "dt_update_at")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "ds_country", nullable = false)
    private String country;

    @Column(name = "ds_msrp")
    private String msrp;

    @Column(name = "ds_currency")
    private String currency;

    @Column(name = "ds_tags")
    private String tags;

    @Column(name = "ds_specs", columnDefinition="json")
    private String specs;
}
