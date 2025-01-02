package brandkon.Product;

public record DetailProductResponse(Long productId,
                                    String productName,
                                    int price,
                                    Brand brand,
                                    int expirationDays)
{
public record Brand(Long id,
                    String name,
                    String guidelines){}

}
