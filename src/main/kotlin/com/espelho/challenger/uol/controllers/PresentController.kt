package com.espelho.challenger.uol.controllers

import com.espelho.challenger.uol.entities.PresentEntity
import com.espelho.challenger.uol.services.PresentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("api/present")
@CrossOrigin(origins = ["*"])
class PresentController(@Autowired
                        val presentService: PresentService) {

    @GetMapping
    fun getAll() : ResponseEntity<MutableList<PresentEntity>> {
        val presents = this.presentService.getAll()
        return ResponseEntity.ok(presents)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: UUID) : ResponseEntity<PresentEntity>? {
        return presentService.getById(id).map { present -> ResponseEntity.ok(present) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createProduct(@Valid @RequestBody present: PresentEntity) : ResponseEntity<PresentEntity> {
        try{
            var response = this.presentService.save(present);
            return ResponseEntity.ok(response)
        }catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @PutMapping
    fun updateProduct(@Valid @RequestBody present: PresentEntity) : ResponseEntity<PresentEntity> {
        try {
            var response = this.presentService.save(present);
            return ResponseEntity.ok(response)
        }catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping()
    fun deleteProduct(@Valid @RequestBody present: PresentEntity): ResponseEntity<String> {
        try {
            this.presentService.delete(present.id)
            return ResponseEntity.ok("Deleted")
        } catch (exception: EmptyResultDataAccessException) {
            return ResponseEntity.notFound().build()
        } catch (exception: Exception) {
            return ResponseEntity.badRequest().build()
        }

    }
    
}