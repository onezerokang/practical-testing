package sample.cafekiosk.unit.beverages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AmericanoTest {
    @DisplayName("아메리카노 테스트")
    @Test
    void getName() {
        Americano americano = new Americano();

        assertThat(americano.getName()).isEqualTo("아메리카노");
    }

}