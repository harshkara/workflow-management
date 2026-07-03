package com.productService.controller;

import com.common.dto.ResponseDto;
import com.productService.entity.Product;
import com.productService.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> get() {
        List<Product> products = productService.getAllProducts();
        log.info("Product list fetched successfully.");
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(products));
    }

}
