package brandkon.Brand;

import brandkon.Category.Category;
import jakarta.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageUrl;
    private String guidelines;

    @ManyToOne
    private Category category;


    public Brand() {
    }

    public Brand(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }




    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGuidelines() {
        return guidelines;
    }
}
