package com.example.projectworkable.data.repository

import com.example.projectworkable.model.User
import com.example.projectworkable.data.remote.SupabaseConfig
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.from

class AuthRepository {

    private val client = SupabaseConfig.client

    // Sign up new user
    suspend fun signUp(email: String, password: String, fullName: String): Result<User> {
        return try {
            // Create auth user
            client.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }

            // Create user profile in database
            val userId = client.auth.currentUserOrNull()?.id ?: throw Exception("User ID not found")

            val newUser = User(
                id = userId,
                fullName = fullName,
                email = email
            )

            client.from("users").insert(newUser)

            Result.success(newUser)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Login existing user
    suspend fun login(email: String, password: String): Result<User> {
        return try {
            client.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }

            val userId = client.auth.currentUserOrNull()?.id ?: throw Exception("User not authenticated")

            // Fetch user profile
            val user = client.from("users")
                .select {
                    filter {
                        eq("id", userId)
                    }
                }
                .decodeSingle<User>()

            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Logout
    suspend fun logout(): Result<Unit> {
        return try {
            client.auth.signOut()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Check if user is logged in
    fun isUserLoggedIn(): Boolean {
        return client.auth.currentUserOrNull() != null
    }

    // Get current user
    suspend fun getCurrentUser(): Result<User?> {
        return try {
            val userId = client.auth.currentUserOrNull()?.id
            if (userId != null) {
                val user = client.from("users")
                    .select {
                        filter {
                            eq("id", userId)
                        }
                    }
                    .decodeSingle<User>()
                Result.success(user)
            } else {
                Result.success(null)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}