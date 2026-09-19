package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AppDatabase
import com.example.data.RegistrationEntity
import com.example.data.RegistrationRepository
import com.example.ui.components.TechCard
import com.example.ui.theme.CyberCyan
import com.example.ui.theme.CyberGreen
import com.example.ui.theme.TechBackground
import com.example.ui.theme.TechCardBorder
import com.example.ui.theme.TechSurface
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    initialCourse: String? = null,
    onRegistrationCompleted: () -> Unit = {}
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val repository = remember {
        RegistrationRepository(AppDatabase.getDatabase(context).registrationDao())
    }

    val courseOptions = listOf(
        "Cyber Security",
        "Ethical Hacking",
        "Web Development",
        "Python",
        "Linux",
        "Networking",
        "Database"
    )

    val educationOptions = listOf(
        "High School / Secondary",
        "Undergraduate Student",
        "Graduate / Post-Graduate",
        "Working Professional",
        "Self-Learner / Other"
    )

    val learningLevelOptions = listOf(
        "Beginner (No experience)",
        "Intermediate (Some basics)",
        "Advanced (Refining skills)"
    )

    val learningModeOptions = listOf(
        "Online Self-Paced",
        "Live Interactive Batches",
        "Weekend Fast-Track"
    )

    // Form fields
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var selectedCourse by remember {
        mutableStateOf(
            if (!initialCourse.isNullOrEmpty() && courseOptions.contains(initialCourse)) {
                initialCourse
            } else {
                courseOptions.first()
            }
        )
    }
    var currentEducation by remember { mutableStateOf(educationOptions[1]) }
    var learningLevel by remember { mutableStateOf(learningLevelOptions[0]) }
    var preferredLearningMode by remember { mutableStateOf(learningModeOptions[0]) }
    var message by remember { mutableStateOf("") }

    // Dropdown expanded states
    var courseExpanded by remember { mutableStateOf(false) }
    var educationExpanded by remember { mutableStateOf(false) }
    var levelExpanded by remember { mutableStateOf(false) }
    var modeExpanded by remember { mutableStateOf(false) }

    // Validation and submission state
    var validationError by remember { mutableStateOf<String?>(null) }
    var isSubmittedSuccessfully by remember { mutableStateOf(false) }
    var submittedDetails by remember { mutableStateOf<RegistrationEntity?>(null) }

    fun validateForm(): Boolean {
        if (fullName.trim().isEmpty()) {
            validationError = "Please enter your Full Name."
            return false
        }
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        if (email.trim().isEmpty() || !emailRegex.matches(email.trim())) {
            validationError = "Please enter a valid email address (e.g. name@domain.com)."
            return false
        }
        val cleanPhone = mobileNumber.filter { it.isDigit() || it == '+' }
        if (cleanPhone.length < 8) {
            validationError = "Please enter a valid mobile number with at least 8 digits."
            return false
        }
        if (age.trim().isEmpty()) {
            validationError = "Please enter your age."
            return false
        }
        if (city.trim().isEmpty()) {
            validationError = "Please enter your city."
            return false
        }
        if (selectedCourse.trim().isEmpty()) {
            validationError = "Please select a course."
            return false
        }
        validationError = null
        return true
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(TechBackground)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                Text(
                    text = "Student Registration",
                    color = TextPrimary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Register for upcoming educational technology batches & courses",
                    color = TextSecondary,
                    fontSize = 13.sp
                )
            }
        }

        if (isSubmittedSuccessfully && submittedDetails != null) {
            item {
                TechCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    accentGlow = CyberGreen,
                    contentPadding = 20.dp
                ) {
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF0F3222))
                            .border(1.5.dp, CyberGreen, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Success",
                            tint = CyberGreen,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Registration request prepared successfully.",
                        color = CyberGreen,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Your application for ${submittedDetails?.course} has been recorded locally. The architecture is prepared to synchronize with Google Forms / Firebase / Supabase backend when connected.",
                        color = TextSecondary,
                        fontSize = 12.sp,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Details Breakdown
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF0C192E))
                            .padding(12.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(text = "Applicant: ${submittedDetails?.fullName}", color = TextPrimary, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                            Text(text = "Email: ${submittedDetails?.email}", color = CyberCyan, fontSize = 12.sp)
                            Text(text = "Phone: ${submittedDetails?.mobileNumber}", color = TextSecondary, fontSize = 12.sp)
                            Text(text = "Location: ${submittedDetails?.city} (Age: ${submittedDetails?.age})", color = TextSecondary, fontSize = 12.sp)
                            Text(text = "Course: ${submittedDetails?.course}", color = CyberGreen, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                            Text(text = "Mode: ${submittedDetails?.preferredLearningMode}", color = TextMuted, fontSize = 11.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            isSubmittedSuccessfully = false
                            submittedDetails = null
                            fullName = ""
                            email = ""
                            mobileNumber = ""
                            age = ""
                            city = ""
                            message = ""
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF132845)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Refresh, contentDescription = null, tint = CyberCyan, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Submit Another Registration", color = CyberCyan, fontSize = 13.sp)
                        }
                    }
                }
            }
        } else {
            // Form Card
            item {
                TechCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    accentGlow = CyberCyan,
                    contentPadding = 18.dp
                ) {
                    // Full Name
                    FormLabel("Full Name *")
                    OutlinedTextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("e.g. Nasir Khan", color = TextMuted, fontSize = 13.sp) },
                        shape = RoundedCornerShape(10.dp),
                        colors = formFieldColors(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Email
                    FormLabel("Email Address *")
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("e.g. student@example.com", color = TextMuted, fontSize = 13.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        shape = RoundedCornerShape(10.dp),
                        colors = formFieldColors(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Mobile Number
                    FormLabel("Mobile Number *")
                    OutlinedTextField(
                        value = mobileNumber,
                        onValueChange = { mobileNumber = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("e.g. +91 9528935578", color = TextMuted, fontSize = 13.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        shape = RoundedCornerShape(10.dp),
                        colors = formFieldColors(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Age & City Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            FormLabel("Age *")
                            OutlinedTextField(
                                value = age,
                                onValueChange = { age = it },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = { Text("e.g. 21", color = TextMuted, fontSize = 13.sp) },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                shape = RoundedCornerShape(10.dp),
                                colors = formFieldColors(),
                                singleLine = true
                            )
                        }

                        Column(modifier = Modifier.weight(1.5f)) {
                            FormLabel("City *")
                            OutlinedTextField(
                                value = city,
                                onValueChange = { city = it },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = { Text("e.g. New Delhi", color = TextMuted, fontSize = 13.sp) },
                                shape = RoundedCornerShape(10.dp),
                                colors = formFieldColors(),
                                singleLine = true
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Course Dropdown
                    FormLabel("Selected Course *")
                    ExposedDropdownMenuBox(
                        expanded = courseExpanded,
                        onExpandedChange = { courseExpanded = it }
                    ) {
                        OutlinedTextField(
                            value = selectedCourse,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = courseExpanded)
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = formFieldColors()
                        )
                        ExposedDropdownMenu(
                            expanded = courseExpanded,
                            onDismissRequest = { courseExpanded = false },
                            modifier = Modifier.background(TechSurface)
                        ) {
                            courseOptions.forEach { course ->
                                DropdownMenuItem(
                                    text = { Text(course, color = TextPrimary, fontSize = 13.sp) },
                                    onClick = {
                                        selectedCourse = course
                                        courseExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Current Education
                    FormLabel("Current Education")
                    ExposedDropdownMenuBox(
                        expanded = educationExpanded,
                        onExpandedChange = { educationExpanded = it }
                    ) {
                        OutlinedTextField(
                            value = currentEducation,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = educationExpanded)
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = formFieldColors()
                        )
                        ExposedDropdownMenu(
                            expanded = educationExpanded,
                            onDismissRequest = { educationExpanded = false },
                            modifier = Modifier.background(TechSurface)
                        ) {
                            educationOptions.forEach { edu ->
                                DropdownMenuItem(
                                    text = { Text(edu, color = TextPrimary, fontSize = 13.sp) },
                                    onClick = {
                                        currentEducation = edu
                                        educationExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Learning Level
                    FormLabel("Learning Level")
                    ExposedDropdownMenuBox(
                        expanded = levelExpanded,
                        onExpandedChange = { levelExpanded = it }
                    ) {
                        OutlinedTextField(
                            value = learningLevel,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = levelExpanded)
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = formFieldColors()
                        )
                        ExposedDropdownMenu(
                            expanded = levelExpanded,
                            onDismissRequest = { levelExpanded = false },
                            modifier = Modifier.background(TechSurface)
                        ) {
                            learningLevelOptions.forEach { lvl ->
                                DropdownMenuItem(
                                    text = { Text(lvl, color = TextPrimary, fontSize = 13.sp) },
                                    onClick = {
                                        learningLevel = lvl
                                        levelExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Preferred Learning Mode
                    FormLabel("Preferred Learning Mode")
                    ExposedDropdownMenuBox(
                        expanded = modeExpanded,
                        onExpandedChange = { modeExpanded = it }
                    ) {
                        OutlinedTextField(
                            value = preferredLearningMode,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = modeExpanded)
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = formFieldColors()
                        )
                        ExposedDropdownMenu(
                            expanded = modeExpanded,
                            onDismissRequest = { modeExpanded = false },
                            modifier = Modifier.background(TechSurface)
                        ) {
                            learningModeOptions.forEach { mode ->
                                DropdownMenuItem(
                                    text = { Text(mode, color = TextPrimary, fontSize = 13.sp) },
                                    onClick = {
                                        preferredLearningMode = mode
                                        modeExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Message (Optional)
                    FormLabel("Message (Optional)")
                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Any specific learning goals or notes...", color = TextMuted, fontSize = 13.sp) },
                        maxLines = 3,
                        shape = RoundedCornerShape(10.dp),
                        colors = formFieldColors()
                    )

                    // Error display
                    if (validationError != null) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF331414))
                                .border(1.dp, Color(0xFFFF5252), RoundedCornerShape(8.dp))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = validationError ?: "",
                                color = Color(0xFFFF8A80),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    // Submit Registration Button
                    Button(
                        onClick = {
                            if (validateForm()) {
                                val entity = RegistrationEntity(
                                    fullName = fullName.trim(),
                                    email = email.trim(),
                                    mobileNumber = mobileNumber.trim(),
                                    age = age.trim(),
                                    city = city.trim(),
                                    course = selectedCourse,
                                    currentEducation = currentEducation,
                                    learningLevel = learningLevel,
                                    preferredLearningMode = preferredLearningMode,
                                    message = message.trim()
                                )
                                coroutineScope.launch {
                                    repository.submitRegistration(entity)
                                    submittedDetails = entity
                                    isSubmittedSuccessfully = true
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = CyberGreen),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = null,
                                tint = Color(0xFF041408),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Submit Registration",
                                color = Color(0xFF041408),
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Architecture Transparency Notice
                    Text(
                        text = "Note: Submission prepares your request locally with architectural support for future cloud syncing.",
                        color = TextMuted,
                        fontSize = 10.sp,
                        lineHeight = 14.sp
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun FormLabel(text: String) {
    Text(
        text = text,
        color = TextPrimary,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
fun formFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedContainerColor = TechSurface,
    unfocusedContainerColor = TechSurface,
    focusedBorderColor = CyberCyan,
    unfocusedBorderColor = TechCardBorder,
    focusedTextColor = TextPrimary,
    unfocusedTextColor = TextPrimary
)
