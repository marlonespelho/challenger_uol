package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.PresentEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PresentRepository : JpaRepository<PresentEntity, UUID> {
}