package com.espelho.challenger.uol.controllers

import com.espelho.challenger.uol.entities.ProductEntity
import com.espelho.challenger.uol.entities.ShippingCompanyEntity
import com.espelho.challenger.uol.services.ShippingCompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("api/shipping-company")
@CrossOrigin(origins = ["*"])
class ShippingCompanyController(@Autowired private val shippingCompanyService: ShippingCompanyService) {

    @GetMapping
    fun getShippingCompanies(): ResponseEntity<MutableList<ShippingCompanyEntity>> {
        val shippingCompanies = this.shippingCompanyService.getShippingCompanies()
        return ResponseEntity.ok(shippingCompanies)
    }

    @GetMapping("/{id}")
    fun getShippingCompany(@PathVariable(value = "id") id: UUID): ResponseEntity<ShippingCompanyEntity>? {
        return shippingCompanyService.getShippingCompanies(id).map { shippingCompany -> ResponseEntity.ok(shippingCompany) }
                .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/name/{name}")
    fun getShippingCompanies(@PathVariable(value = "name") name: String): ResponseEntity<List<ShippingCompanyEntity>>? {
        return shippingCompanyService.getShippingCompanies(name).map { shippingCompany -> ResponseEntity.ok().body(shippingCompany) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createShippingCompany(@Valid @RequestBody shippingCompany: ShippingCompanyEntity):
            ResponseEntity<ShippingCompanyEntity> {
        try {
            var response = this.shippingCompanyService.save(shippingCompany)
            return ResponseEntity.ok(response)
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @PutMapping
    fun updateShippingCompany(@Valid @RequestBody shippingCompany: ShippingCompanyEntity):
            ResponseEntity<ShippingCompanyEntity> {
        try {
            var response = this.shippingCompanyService.save(shippingCompany)
            return ResponseEntity.ok(response)
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping()
    fun deleteShippingCompany(@Valid @RequestBody shippingCompany: ShippingCompanyEntity): ResponseEntity<String> {
        try {
            this.shippingCompanyService.delete(shippingCompany.id)
            return ResponseEntity.ok("Deleted")
        } catch (exception: EmptyResultDataAccessException) {
            return ResponseEntity.notFound().build()
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

}