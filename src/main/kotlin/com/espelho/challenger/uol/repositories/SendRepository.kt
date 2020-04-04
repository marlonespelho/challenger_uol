package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.SendEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SendRepository : JpaRepository<SendEntity, UUID> {
}