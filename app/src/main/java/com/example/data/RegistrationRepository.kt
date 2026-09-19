package com.example.data

import kotlinx.coroutines.flow.Flow

interface BackendSyncClient {
    suspend fun syncRegistration(registration: RegistrationEntity): Result<Boolean>
}

// Ready for future Google Form / Firebase / Supabase backend connectivity
class PendingBackendSyncClient : BackendSyncClient {
    override suspend fun syncRegistration(registration: RegistrationEntity): Result<Boolean> {
        // Architectural hook ready for external API integration
        return Result.success(true)
    }
}

class RegistrationRepository(
    private val dao: RegistrationDao,
    private val backendClient: BackendSyncClient = PendingBackendSyncClient()
) {
    fun getAllRegistrations(): Flow<List<RegistrationEntity>> = dao.getAllRegistrations()

    suspend fun submitRegistration(registration: RegistrationEntity): Result<Long> {
        return try {
            val id = dao.insertRegistration(registration)
            // Hook for future remote backend sync
            Result.success(id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
