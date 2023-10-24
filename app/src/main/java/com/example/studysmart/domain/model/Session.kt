package com.example.studysmart.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Session(
    val relatedToSubject: String,
    val date: Long,
    val duration: Long,
    val sessionSubjectId: Int,
    @PrimaryKey(autoGenerate = true)
    val sessionId: Int? = null
)
