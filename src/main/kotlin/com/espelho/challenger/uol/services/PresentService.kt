package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.PresentEntity
import com.espelho.challenger.uol.repositories.PresentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PresentService(@Autowired val presentRepository: PresentRepository,
                     @Autowired val sendService: SendService) {

    fun save(present: PresentEntity): PresentEntity {
        this.sendService.createSends(present)
        return this.presentRepository.save(present)
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