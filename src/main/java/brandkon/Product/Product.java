package brandkon.Product;

import brandkon.Brand.Brand;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;
    private String productName;
    private int price;
    private String imageUrl;
    private int expirationDays;

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
