package brandkon.Product;

import brandkon.Brand.Brand;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String brandName;
    String productName;
    int price;
    String imageUrl;

    @ManyToOne
    Brand brand;

    public Product() {
    }

    public Product(Long id, String brandName, String productName, int price, String imageUrl) {
        this.id = id;
        this.brandName = brandName;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
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
}
