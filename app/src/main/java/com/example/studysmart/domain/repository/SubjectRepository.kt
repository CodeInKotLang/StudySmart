package com.example.studysmart.domain.repository

import com.example.studysmart.domain.model.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectRepository {

    suspend fun upsertSubject(subject: Subject)

    fun getTotalSubjectCount(): Flow<Int>

    fun getTotalGoalHours(): Flow<Float>

    suspend fun deleteSubject(subjectInt: Int)

    suspend fun getSubjectById(subjectInt: Int): Subject?

    fun getAllSubjects(): Flow<List<Subject>>
}