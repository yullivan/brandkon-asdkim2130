package brandkon.Brand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    //브랜드 목록 조회
    @GetMapping("/brands")
    public void getBrandList(@RequestParam(required = false) String category){
        brandService.listAllBrand();
    }

    // 브랜드 상세 조회
    @GetMapping("brands/{brandId}")
    public void getBrandDetail (@PathVariable Long id){
        brandService.brandDetail(id);
    }

}
