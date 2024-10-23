package com.camels.product_service.service;

import com.camels.product_service.dto.ProductDto;
import com.camels.product_service.dto.SaveProductDto;
import com.camels.product_service.dto.UpdateProductDto;

import java.util.List;

public interface IProductService {
    SaveProductDto saveProduct(SaveProductDto saveProductDto);
    UpdateProductDto updateProduct(UpdateProductDto updateProductDto, Long id);
    List<ProductDto> getAllProducts();
    ProductDto getProduct(Long id);
    void deleteProduct(Long id);
}
