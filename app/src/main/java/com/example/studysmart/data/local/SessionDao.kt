package com.example.studysmart.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.studysmart.domain.model.Session
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {

    @Insert
    suspend fun insertSession(session: Session)

    @Delete
    suspend fun deleteSession(session: Session)

    @Query("SELECT * FROM Session")
    fun getAllSessions(): Flow<List<Session>>

    @Query("SELECT * FROM Session WHERE sessionSubjectId = :subjectId")
    fun getRecentSessionsForSubject(subjectId: Int): Flow<List<Session>>

    @Query("SELECT SUM(duration) FROM Session")
    fun getTotalSessionsDuration(): Flow<Long>

    @Query("SELECT SUM(duration) FROM Session WHERE sessionSubjectId = :subjectId")
    fun getTotalSessionsDurationBySubjectId(subjectId: Int): Flow<Long>

    @Query("DELETE FROM Session WHERE sessionSubjectId = :subjectId")
    fun deleteSessionsBySubjectId(subjectId: Int)
}