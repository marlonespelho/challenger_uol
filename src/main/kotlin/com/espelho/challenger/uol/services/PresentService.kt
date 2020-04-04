package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.PresentEntity
import com.espelho.challenger.uol.repositories.PresentRepository
import java.util.*

class PresentService(private val presentRepository: PresentRepository) {
    fun save(present: PresentEntity) {
        this.presentRepository.save(present);
    }

    fun delete(id : UUID) {
        return this.presentRepository.deleteById(id);
    }

    fun getAll(): MutableList<PresentEntity> {
        return this.presentRepository.findAll();
    }

    fun getById(id: UUID): Optional<PresentEntity> {
        return this.presentRepository.findById(id);
    }

    fun getByProductId(productId: UUID): Optional<List<PresentEntity>> {
        return this.presentRepository.findByProductId(productId);
    }
}