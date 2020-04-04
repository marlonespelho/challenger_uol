package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.SendEntity
import com.espelho.challenger.uol.repositories.SendRepository
import java.util.*

class SendService(private val sendRepository: SendRepository) {

    fun save(send: SendEntity) {
        this.sendRepository.save(send);
    }

    fun delete(id : UUID) {
        return this.sendRepository.deleteById(id);
    }

    fun getAll(): MutableList<SendEntity> {
        return this.sendRepository.findAll();
    }

    fun getById(id: UUID): Optional<SendEntity> {
        return this.sendRepository.findById(id);
    }
    
}