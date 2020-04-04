package com.espelho.challenger.uol.controllers

import com.espelho.challenger.uol.repositories.ProductRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = ["*"])
class ProductController(private val productRepository: ProductRepository) {

    fun getAll() {

    }

}