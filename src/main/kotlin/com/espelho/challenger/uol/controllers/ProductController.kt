package com.espelho.challenger.uol.controllers

import com.espelho.challenger.uol.entities.ProductEntity
import com.espelho.challenger.uol.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = ["*"])
class ProductController(@Autowired private val productService: ProductService) {

    @GetMapping
    fun getProducts() : ResponseEntity<List<ProductEntity>> {
        val products = this.productService.getProducts()
        return ResponseEntity.ok(products)
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable(value = "id") id: UUID) : ResponseEntity<ProductEntity>? {
        return productService.getProducts(id).map { product -> ResponseEntity.ok(product) }
                .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/name/{name}")
    fun getProducts(@PathVariable(value = "name") name: String) : ResponseEntity<List<ProductEntity>>? {
        return productService.getProducts(name).map { products -> ResponseEntity.ok().body(products) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createProduct(@Valid @RequestBody product: ProductEntity) : ResponseEntity<ProductEntity>{
        try{
            var response = this.productService.save(product);
            return ResponseEntity.ok(response);
        }catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @PutMapping
    fun updateProduct(@Valid @RequestBody product: ProductEntity) : ResponseEntity<ProductEntity>{
        try {
            var response = this.productService.save(product);
            return ResponseEntity.ok(response);
        }catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping()
    fun deleteProduct(@Valid @RequestBody product: ProductEntity): ResponseEntity<String> {
        try {
            this.productService.delete(product.id)
            return ResponseEntity.ok("Deleted")
        } catch (exception: EmptyResultDataAccessException) {
            return ResponseEntity.notFound().build()
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

}