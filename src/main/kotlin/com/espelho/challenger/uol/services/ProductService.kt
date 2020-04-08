package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.ProductEntity
import com.espelho.challenger.uol.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
        @Autowired
        private val productRepository: ProductRepository) {

    fun save(product: ProductEntity): ProductEntity {
       return this.productRepository.save(product);
    }

    fun delete(id : UUID) {
        return this.productRepository.deleteById(id);
    }

    fun getProducts(): List<ProductEntity> {
        return this.productRepository.findAll();
    }

    fun getProducts(id: UUID): Optional<ProductEntity> {
        return this.productRepository.findById(id);
    }

    fun getProducts(name: String): Optional<List<ProductEntity>> {
        return this.productRepository.findByName(name);
    }

}