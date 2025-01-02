package brandkon.Product;

import brandkon.Brand.Brand;
import brandkon.Brand.BrandRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    //상품목록조회(brandId 확인하기)
    public List<ProductResponse> listAllProducts(Long brandId){
        if(brandId != null){
            return productRepository.findByBrandId(brandId).stream()
                    .map(product -> new ProductResponse(
                            product.getId(),
                            product.getBrandName(),
                            product.getProductName(),
                            product.getPrice(),
                            product.getImageUrl())).toList();
        }else
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getBrandName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl())).toList();


    }



}
