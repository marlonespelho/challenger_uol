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
    fun getAll(): ResponseEntity<MutableList<SendEntity>> {
        val sends = this.sendService.getAll()
        return ResponseEntity.ok(sends)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: UUID): ResponseEntity<SendEntity>? {
        return sendService.getById(id).map { send -> ResponseEntity.ok(send) }
                .orElse(ResponseEntity.notFound().build())
    }

}