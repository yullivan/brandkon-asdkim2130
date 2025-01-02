package brandkon.Brand;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        Brand brands = brandRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("찾는 브랜드가 존재하지 않습니다."));

        return new BrandDetailResponse(brands.getId(),
                brands.getName(),
                brands.getImageUrl());
    }

}
