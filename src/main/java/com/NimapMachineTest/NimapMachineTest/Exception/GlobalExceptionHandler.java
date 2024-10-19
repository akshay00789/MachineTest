package com.NimapMachineTest.NimapMachineTest.Exception;

import com.NimapMachineTest.NimapMachineTest.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<BaseResponse<?>> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        BaseResponse<?> response = new BaseResponse<>(
                HttpStatus.NOT_FOUND.value(),
                "Category not found",
                exception.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<BaseResponse<?>> handleProductNotFoundException(ProductNotFoundException exception) {
        BaseResponse<?> response = new BaseResponse<>(
                HttpStatus.NOT_FOUND.value(),
                "Product not found",
                exception.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    // You can add more exception handlers for other cases if needed
}
