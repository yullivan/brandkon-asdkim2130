package brandkon.Category;

import brandkon.Brand.Brand;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;
    private String imageUrl;

    @CreatedDate
    @Column(nullable = false)  //데이터베이스 테이블을 만들 때 null이 되지 않게 설정(Jpa를 거치지 않으면 H2데이터베이스에서 column값이 null로 나옴)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)  //데이터베이스 테이블을 만들 때 null이 되지 않게 설정
    private LocalDateTime updatedAt;

    public Category() {
    }


    public Category(Long id, String name, String slug, String imageUrl) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
    }

    public Category(String name, String slug, String imageUrl) {
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
    }

    public void changeNameSlugImageUrl(String name, String slug, String imageUrl){
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
    }




    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
