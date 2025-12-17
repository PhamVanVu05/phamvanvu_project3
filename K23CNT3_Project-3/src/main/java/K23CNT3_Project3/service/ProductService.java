package K23CNT3_Project3.service;

import K23CNT3_Project3.model.entity.Product;
import K23CNT3_Project3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // THÊM PHƯƠNG THỨC getAllProducts()
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Product createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setDiscountPrice(productDetails.getDiscountPrice());
            product.setGender(productDetails.getGender());
            product.setStockQuantity(productDetails.getStockQuantity());
            product.setImageUrl(productDetails.getImageUrl());
            product.setBrandId(productDetails.getBrandId());
            product.setCategoryId(productDetails.getCategoryId());
            product.setIsFeatured(productDetails.getIsFeatured());
            product.setUpdatedAt(LocalDateTime.now());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // THÊM PHƯƠNG THỨC getFeaturedProducts()
    public List<Product> getFeaturedProducts() {
        // Tạm thời lấy 8 sản phẩm đầu tiên
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().limit(8).toList();
    }

    public List<Product> searchProducts(String keyword) {
        // Tạm thời filter bằng code
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        p.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}