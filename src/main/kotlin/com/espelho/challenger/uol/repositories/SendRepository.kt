package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.SendEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SendRepository : JpaRepository<SendEntity, UUID> {
    fun findByOrderByGiftProductNameAscSendValueAsc(): Optional<List<SendEntity>>
    fun findByGiftProductNameOrderByGiftProductNameAscSendValueAsc(giftProductName: String): Optional<List<SendEntity>>
    fun findByGiftProductIdOrderByGiftProductNameAscSendValueAsc(giftProductId: UUID): Optional<List<SendEntity>>
}