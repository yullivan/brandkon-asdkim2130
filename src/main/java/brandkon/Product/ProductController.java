package brandkon.Product;

import brandkon.Brand.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 목록 조회
    @GetMapping("/products")
    public void getProductsList (@RequestParam(required = false) Long brandId){
        productService.listAllProducts(brandId);
    }

    // 상품 상세 조회
    @GetMapping("/products/{productId}")
    public void getDetailProduct (@PathVariable(name = "productId") Long id){
        productService.productDetail(id);
    }

    @GetMapping("/products/popular")
    public void getPopularProducts(@RequestParam(required = false) Long categoryId,
                                   @RequestParam(required = false) Long brandId){
        productService.top5PopularProducts();
    }


}
