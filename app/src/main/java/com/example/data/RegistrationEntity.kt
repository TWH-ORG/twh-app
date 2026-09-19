package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_registrations")
data class RegistrationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val fullName: String,
    val email: String,
    val mobileNumber: String,
    val age: String,
    val city: String,
    val course: String,
    val currentEducation: String,
    val learningLevel: String,
    val preferredLearningMode: String,
    val message: String,
    val timestamp: Long = System.currentTimeMillis(),
    val syncStatus: String = "LOCAL_PREPARED" // Prepared for future Google Form / Firebase / Supabase backend sync
)
