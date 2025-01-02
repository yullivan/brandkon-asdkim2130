package brandkon.Product;

import brandkon.Brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBrandId(Long brandId);

}
