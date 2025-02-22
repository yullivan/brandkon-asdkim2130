package brandkon.Product;

import brandkon.Brand.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 목록 조회
    @GetMapping("/products")
    public List<ProductResponse> getProductsList (@RequestParam(required = false) Long brandId){
        return productService.listAllProducts(brandId);
    }

    // 상품 상세 조회
    @GetMapping("/products/{productId}")
    public ProductDetailResponse getDetailProduct (@PathVariable(name = "productId") Long id){
        return productService.productDetail(id);
    }

    // 인기 상품 조회
    @GetMapping("/products/popular")
    public List<ProductResponse> getPopularProducts(@RequestParam(required = false) Long categoryId,
                                                    @RequestParam(required = false) Long brandId){
        return productService.top5PopularProducts();
    }


}
