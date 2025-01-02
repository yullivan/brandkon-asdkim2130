package brandkon.Product;

import brandkon.Brand.Brand;
import brandkon.Brand.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    //상품목록조회(brandId 확인하기)
    public List<ProductResponse> listAllProducts(Long brandId) {
        if (brandId != null) {
            return productRepository.findByBrandId(brandId)
                    .stream()
                    .map(product -> new ProductResponse(
                            product.getId(),
                            product.getBrandName(),
                            product.getProductName(),
                            product.getPrice(),
                            product.getImageUrl()))
                    .toList();
        }
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getBrandName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()))
                .toList();
    }

    public ProductDetailResponse productDetail(Long id) {
        Product products = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

        ProductDetailResponse.Brand brandResponse = new ProductDetailResponse.Brand(
                products.getBrand().getId(),
                products.getBrand().getName(),
                products.getBrand().getGuidelines());


        return new ProductDetailResponse(products.getId(),
                products.getProductName(),
                products.getPrice(),
                brandResponse,
                products.getExpirationDays());
    }

    public List<ProductResponse> top5PopularProducts(){
        List<Product> products = productRepository.findTop5ByOrderBySalesVolumeDesc();

        return products.stream()
                .map(product -> new ProductResponse(
                       product.getId(),
                        product.getBrandName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()
                )).toList();


    }

}
