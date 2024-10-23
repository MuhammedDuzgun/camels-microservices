package com.camels.product_service.service.impl;

import com.camels.product_service.dto.ProductDto;
import com.camels.product_service.dto.SaveProductDto;
import com.camels.product_service.dto.UpdateProductDto;
import com.camels.product_service.entity.Product;
import com.camels.product_service.repository.IProductRepository;
import com.camels.product_service.service.IProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductService implements IProductService {

    private IProductRepository productRepository;
    private ModelMapper modelMapper;

    @Override
    public SaveProductDto saveProduct(SaveProductDto saveProductDto) {
        Product product = modelMapper.map(saveProductDto, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, SaveProductDto.class);
    }

    @Override
    public UpdateProductDto updateProduct(UpdateProductDto updateProductDto, Long id) {
        Product product = productRepository.findById(id).get();

        product.setName(updateProductDto.getName());
        product.setDescription(updateProductDto.getDescription());
        product.setPrice(updateProductDto.getPrice());
        product.setCategoryId(updateProductDto.getCategoryId());
        product.setStockQuantity(updateProductDto.getStockQuantity());
        product.setImageUrl(updateProductDto.getImageUrl());

        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, UpdateProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(modelMapper.map(product, ProductDto.class));
        }
        return productDtos;
    }

    @Override
    public ProductDto getProduct(Long id) {
        Product product = productRepository.findById(id).get();
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}
