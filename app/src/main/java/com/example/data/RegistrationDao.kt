package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RegistrationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRegistration(registration: RegistrationEntity): Long

    @Query("SELECT * FROM student_registrations ORDER BY timestamp DESC")
    fun getAllRegistrations(): Flow<List<RegistrationEntity>>

    @Query("SELECT COUNT(*) FROM student_registrations")
    fun getRegistrationCount(): Flow<Int>
}
