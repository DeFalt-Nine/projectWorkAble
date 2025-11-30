package com.example.projectworkable.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String = "",
    @SerialName("full_name")
    val fullName: String = "",
    val email: String = "",
    val phone: String? = null,
    val location: String? = null,
    @SerialName("resume_link")
    val resumeLink: String? = null,
    val skills: List<String>? = null,
    @SerialName("experience_years")
    val experienceYears: Int? = null,
    @SerialName("education_level")
    val educationLevel: String? = null,
    @SerialName("physical_needs")
    val physicalNeeds: List<String>? = null,
    @SerialName("assistive_tools")
    val assistiveTools: List<String>? = null,
    @SerialName("job_preferences")
    val jobPreferences: List<String>? = null,
    @SerialName("remote_preference")
    val remotePreference: Boolean = false,
    @SerialName("desired_salary_range")
    val desiredSalaryRange: String? = null,
    @SerialName("applied_jobs")
    val appliedJobs: List<Long>? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("updated_at")
    val updatedAt: String? = null
)