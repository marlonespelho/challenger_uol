package com.espelho.challenger.uol.controllers

import com.espelho.challenger.uol.entities.GiftEntity
import com.espelho.challenger.uol.services.GiftService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("api/gift")
@CrossOrigin(origins = ["*"])
class GiftController(@Autowired val giftService: GiftService) {
    @GetMapping
    fun getGifts() : ResponseEntity<MutableList<GiftEntity>> {
        val presents = this.giftService.getGifts()
        return ResponseEntity.ok(presents)
    }

    @GetMapping("/{id}")
    fun getGift(@PathVariable(value = "id") id: UUID) : ResponseEntity<GiftEntity>? {
        return giftService.getGifts(id).map { present -> ResponseEntity.ok(present) }
                .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/product/{id}")
    fun getGiftsByProductId(@PathVariable(value = "id") productId: UUID) : ResponseEntity<List<GiftEntity>>? {
        return giftService.getGiftsByProducts(productId).map { present -> ResponseEntity.ok(present) }
                .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/product/name{name}")
    fun getGiftsByProductName(@PathVariable(value = "name") nameProduct: String) : ResponseEntity<List<GiftEntity>>? {
        return giftService.getGiftsByProducts(nameProduct).map { present -> ResponseEntity.ok(present) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createGift(@Valid @RequestBody present: GiftEntity) : ResponseEntity<GiftEntity> {
        try{
            var response = this.giftService.save(present);
            return ResponseEntity.ok(response)
        }catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @PutMapping
    fun updateGift(@Valid @RequestBody present: GiftEntity) : ResponseEntity<GiftEntity> {
        try {
            var response = this.giftService.save(present);
            return ResponseEntity.ok(response)
        }catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping()
    fun deleteGift(@Valid @RequestBody present: GiftEntity): ResponseEntity<String> {
        try {
            this.giftService.delete(present.id)
            return ResponseEntity.ok("Deleted")
        } catch (exception: EmptyResultDataAccessException) {
            return ResponseEntity.notFound().build()
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }

    }

}