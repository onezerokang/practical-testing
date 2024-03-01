package sample.cafekiosk.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverages.Americano;
import sample.cafekiosk.unit.beverages.Latte;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CafeKioskTest {
    @DisplayName("키오스크에 상품을 추가할 수 있다.")
    @Test
    void add() {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();

        // when
        cafeKiosk.add(new Americano());

        //then
        assertThat(cafeKiosk.getBeverages()).hasSize(1);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @DisplayName("음료는 여러잔 주문할 수 있다.")
    @Test
    void addSeveralBeverages() {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        // when
        cafeKiosk.add(americano, 2);

        //then
        assertThat(cafeKiosk.getBeverages().get(0)).isEqualTo(americano);
        assertThat(cafeKiosk.getBeverages().get(1)).isEqualTo(americano);
    }

    @DisplayName("음료를 0잔 이하로 주문할 경우 예외를 던진다.")
    @Test
    void addZeroBeverages() {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        // when then
        assertThatThrownBy(() -> cafeKiosk.add(americano, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 한 잔 이상 주문하실 수 있습니다.");
    }

    @DisplayName("키오스크에서 상품을 삭제할 수 있다.")
    @Test
    void remove() {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano);

        // when
        cafeKiosk.remove(americano);

        //then
        assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    @DisplayName("키오스크의 모든 상품을 삭제할 수 있다.")
    @Test
    void clear() {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());

        // when
        cafeKiosk.clear();

        //then
        assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    @DisplayName("키오스크에서는 주문을 생성할 수 있다.")
    @Test
    void createOrderWithCurrentTime() {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano);

        // when
        Order order = cafeKiosk.createOrder(LocalDateTime.of(2023, 1, 17, 10, 0));

        //then
        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @DisplayName("카페 운영시간이 아닐 때는 주문할 수 없다.")
    @Test
    void createOrderWithOutsideOpenTime() {
        // given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano);

        // when then
        assertThatThrownBy(() -> cafeKiosk.createOrder(LocalDateTime.of(2023, 1, 17, 9, 59)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 시간이 아닙니다. 관리자에게 문의하세요.");
    }
}