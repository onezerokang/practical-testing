package sample.cafekiosk.spring.api.service.product.response;

import lombok.Builder;
import lombok.Getter;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

@Getter
public class ProductResponse {
    private Long id;

    private String productNumber;

    private String name;

    private int price;

    private ProductType type;

    private ProductSellingStatus sellingStatus;

    @Builder
    private ProductResponse(Long id, String productNumber, String name, int price, ProductType type, ProductSellingStatus sellingStatus) {
        this.id = id;
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.type = type;
        this.sellingStatus = sellingStatus;
    }

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productNumber(product.getProductNumber())
                .name(product.getName())
                .price(product.getPrice())
                .type(product.getType())
                .sellingStatus(product.getSellingStatus())
                .build();
    }
}
