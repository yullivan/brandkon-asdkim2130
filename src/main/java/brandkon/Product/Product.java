package brandkon.Product;

import brandkon.Brand.Brand;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;  //Brand에 name이 있기 때문에 Product에 brandName을 쓸 필요도 없고, 관련도 없다.(중복데이터)
    private String productName;
    private int price;
    private String imageUrl;
    private int expirationDays;
    private int salesVolume;

    @ManyToOne
    private Brand brand;




    public Product() {
    }

    public Product(Long id, String brandName, String productName, int price, String imageUrl) {
        this.id = id;
        this.brandName = brandName;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(Long id, String productName, int price, Brand brand, int expirationDays) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.brand = brand;
        this.expirationDays = expirationDays;
    }

    //getter
    public Long getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getExpirationDays() {
        return expirationDays;
    }
}
