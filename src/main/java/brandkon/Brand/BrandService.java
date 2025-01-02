package brandkon.Brand;

import java.util.List;
import java.util.Optional;

public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandResponse> listAllBrand(){
        return brandRepository.findAll().stream()
                .map(brand -> new BrandResponse(brand.getId(),
                        brand.getName(),
                        brand.getImageUrl())).toList();

    }

    public BrandDetailResponse brandDetail(Long id){
        Brand brand = brandRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("찾는 브랜드가 존재하지 않습니다."));

        return new BrandDetailResponse(brand.id,
                brand.name,
                brand.imageUrl);
    }

}
