package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTypeTest {
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    void containsStockType1() {
        // given
        ProductType productType = ProductType.HANDMADE;

        // when
        boolean result = ProductType.containsStockType(productType);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    void containsStockType2() {
        // given
        ProductType productType = ProductType.BAKERY;

        // when
        boolean result = ProductType.containsStockType(productType);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    void containsStockType3() {
        // given
        ProductType productType1 = ProductType.HANDMADE;
        ProductType productType2 = ProductType.BOTTLE;
        ProductType productType3 = ProductType.BAKERY;


        // when
        boolean result1 = ProductType.containsStockType(productType1);
        boolean result2 = ProductType.containsStockType(productType2);
        boolean result3 = ProductType.containsStockType(productType3);

        //then
        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @CsvSource({"HANDMADE,false", "BOTTLE,true", "BAKERY,true"})
    @ParameterizedTest
    void containsStockType4(ProductType productType, boolean expected) {
        // when
        boolean result = ProductType.containsStockType(productType);

        //then
        assertThat(result).isEqualTo(expected);
    }
}