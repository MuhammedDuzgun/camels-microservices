package com.camels.product_service.controller;

import com.camels.product_service.dto.ProductDto;
import com.camels.product_service.dto.SaveProductDto;
import com.camels.product_service.dto.UpdateProductDto;
import com.camels.product_service.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService productService;

    @PostMapping("/save-product")
    public SaveProductDto saveProduct(@RequestBody SaveProductDto saveProductDto) {
        return productService.saveProduct(saveProductDto);
    }

    @PostMapping("/update-product/{id}")
    public UpdateProductDto updateProduct(@RequestBody UpdateProductDto updateProductDto,
                                          @PathVariable Long id) {
        return productService.updateProduct(updateProductDto, id);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
