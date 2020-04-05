package com.espelho.challenger.uol.controllers

import com.espelho.challenger.uol.entities.PriceRuleEntity
import com.espelho.challenger.uol.services.PriceRuleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("api/price-rules")
@CrossOrigin(origins = ["*"])
class PriceRulesController(@Autowired private val priceRuleService: PriceRuleService) {

    @GetMapping
    fun getAll(): ResponseEntity<MutableList<PriceRuleEntity>> {
        val priceRules = this.priceRuleService.getAll()
        return ResponseEntity.ok(priceRules)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: UUID): ResponseEntity<PriceRuleEntity>? {
        return priceRuleService.getById(id).map { priceRule -> ResponseEntity.ok(priceRule) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createShippingCompany(@Valid @RequestBody priceRuleEntity: PriceRuleEntity):
            ResponseEntity<PriceRuleEntity> {
        try {
            var response = this.priceRuleService.save(priceRuleEntity)
            return ResponseEntity.ok(response)
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @PutMapping
    fun updateShippingCompany(@Valid @RequestBody priceRuleEntity: PriceRuleEntity):
            ResponseEntity<PriceRuleEntity> {
        try {
            var response = this.priceRuleService.save(priceRuleEntity)
            return ResponseEntity.ok(response)
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping()
    fun deleteShippingCompany(@Valid @RequestBody priceRuleEntity: PriceRuleEntity): ResponseEntity<String> {
        try {
            this.priceRuleService.delete(priceRuleEntity.id)
            return ResponseEntity.ok("Deleted")
        } catch (exception: EmptyResultDataAccessException) {
            return ResponseEntity.notFound().build()
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }
    
}