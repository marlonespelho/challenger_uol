package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.SendEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SendRepository : JpaRepository<SendEntity, UUID> {
}