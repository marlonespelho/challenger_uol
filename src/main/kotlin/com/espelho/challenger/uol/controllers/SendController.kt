package com.espelho.challenger.uol.controllers

import com.espelho.challenger.uol.entities.SendEntity
import com.espelho.challenger.uol.entities.ShippingCompanyEntity
import com.espelho.challenger.uol.services.SendService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/send")
@CrossOrigin(origins = ["*"])
class SendController(@Autowired private val sendService: SendService) {
    @GetMapping
    fun getSends(): ResponseEntity<Optional<List<SendEntity>>> {
        val sends = this.sendService.getSends()
        return ResponseEntity.ok(sends)
    }

    @GetMapping("/{id}")
    fun getSend(@PathVariable(value = "id") id: UUID): ResponseEntity<SendEntity>? {
        return sendService.getSends(id).map { send -> ResponseEntity.ok(send) }
                .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/product/{id}")
    fun getSendsByProductId(@PathVariable(value = "id") productId: UUID): ResponseEntity<List<SendEntity>>? {
        return sendService.getSendsByProduct(productId).map{ send -> ResponseEntity.ok(send) }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/product/name/{name}")
    fun getSendsByProductName(@PathVariable(value = "name") productName: String): ResponseEntity<List<SendEntity>>? {
        return sendService.getSendsByProduct(productName).map{ send -> ResponseEntity.ok().body(send) }
                .orElse(ResponseEntity.notFound().build())
    }

}