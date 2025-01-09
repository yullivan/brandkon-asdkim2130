package brandkon.Product;

import brandkon.Brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBrandId(Long brandId);

    // 판매량이 많은 상품 상위 5개를 조회 (판매량이 많은 순서대로)
    List<Product> findTop5ByOrderBySalesVolumeDesc();
}
