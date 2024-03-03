package sample.cafekiosk.spring.api.controller.order;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sample.cafekiosk.spring.api.ApiResponse;
import sample.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import sample.cafekiosk.spring.api.service.order.OrderService;
import sample.cafekiosk.spring.api.service.order.response.OrderResponse;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/api/v1/orders/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<OrderResponse> createOrder(@Valid @RequestBody OrderCreateRequest request) {
        LocalDateTime registeredDateTime = LocalDateTime.now();
        return ApiResponse.of(HttpStatus.CREATED, orderService.createOrder(request.toServiceRequest(), registeredDateTime));
    }
}
