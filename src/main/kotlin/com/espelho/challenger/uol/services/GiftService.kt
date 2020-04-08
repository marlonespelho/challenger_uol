package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.GiftEntity
import com.espelho.challenger.uol.repositories.GiftRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class GiftService(@Autowired val giftRepository: GiftRepository,
                  @Autowired val sendService: SendService) {

    fun save(gift: GiftEntity): GiftEntity {
        val response = this.giftRepository.save(gift)
        this.sendService.createSends(response)
        return response
    }

    fun delete(id : UUID) {
        return this.giftRepository.deleteById(id)
    }

    fun getGifts(): MutableList<GiftEntity> {
        return this.giftRepository.findAll()
    }

    fun getGifts(id: UUID): Optional<GiftEntity> {
        return this.giftRepository.findById(id)
    }

    fun getGiftsByProducts(productId: UUID): Optional<List<GiftEntity>> {
        return this.giftRepository.findByProductId(productId)
    }

    fun getGiftsByProducts(productName: String): Optional<List<GiftEntity>> {
        return this.giftRepository.findByProductName(productName)
    }
}