package brandkon.Brand;

import java.util.List;

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



}
