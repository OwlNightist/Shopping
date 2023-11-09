package com.example.shopping.exception;

import com.example.shopping.model.CustomError;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopException extends RuntimeException{
    HttpStatus status;
    CustomError error;

    public static RuntimeException notFoundException(String message) {
        return ShopException.builder()
                .status(HttpStatus.NOT_FOUND)
                .error(CustomError.builder()
                        .code("404")
                        .message(message)
                        .build())
                .build();
    }

}
