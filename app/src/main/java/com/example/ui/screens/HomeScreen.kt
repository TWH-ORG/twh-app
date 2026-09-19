package com.example.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.CompassCalibration
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CourseItem
import com.example.data.CourseRepository
import com.example.ui.components.TechCard
import com.example.ui.components.openExternalUri
import com.example.ui.navigation.InstituteContact
import com.example.ui.navigation.NavDestinations
import com.example.ui.theme.CyberCyan
import com.example.ui.theme.CyberGreen
import com.example.ui.theme.LevelBeginner
import com.example.ui.theme.TechBackground
import com.example.ui.theme.TechCardBorder
import com.example.ui.theme.TechSurface
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    onNavigateToCourses: () -> Unit,
    onNavigateToFreeLearning: () -> Unit,
    onNavigateToCourseDetail: (String) -> Unit,
    onNavigateToRegister: (String?) -> Unit
) {
    val context = LocalContext.current
    val courses = CourseRepository.courses

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(TechBackground)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            HeroSection(
                onExploreCourses = onNavigateToCourses,
                onStartLearning = onNavigateToFreeLearning
            )
        }

        // Section: Why TWH ORG?
        item {
            SectionHeader(
                title = "Why TWH ORG?",
                subtitle = "Engineered for practical comprehension and digital mastery"
            )
            Spacer(modifier = Modifier.height(12.dp))
            WhyTwhOrgGrid()
        }

        // Section: Popular Courses
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SectionHeader(
                    title = "Popular Courses",
                    subtitle = "Foundational & career-ready curricula"
                )
                Text(
                    text = "View All (${courses.size})",
                    color = CyberCyan,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable { onNavigateToCourses() }
                )
            }
        }

        items(courses) { course ->
            CourseCard(
                course = course,
                onViewCourse = { onNavigateToCourseDetail(course.id) },
                onRegister = { onNavigateToRegister(course.title) }
            )
        }

        // Section: Free Learning
        item {
            FreeLearningPromoCard(onExplore = onNavigateToFreeLearning)
        }

        // Section: YouTube
        item {
            YouTubePromoCard(
                onVisit = { openExternalUri(context, InstituteContact.YOUTUBE_URL) }
            )
        }

        // Section: Instagram
        item {
            InstagramPromoCard(
                onFollow = { openExternalUri(context, InstituteContact.INSTAGRAM_URL) }
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun HeroSection(
    onExploreCourses: () -> Unit,
    onStartLearning: () -> Unit
) {
    TechCard(
        modifier = Modifier.fillMaxWidth(),
        accentGlow = CyberCyan,
        shape = RoundedCornerShape(20.dp),
        contentPadding = 20.dp
    ) {
        // Tagline badge
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF0F2642))
                .border(1.dp, CyberCyan.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(CyberGreen)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "TWH ORG INSTITUTE",
                color = CyberCyan,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Hero Heading
        Text(
            text = "Learn Technology. Build Skills. Shape Your Future.",
            color = TextPrimary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 30.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Hero Description
        Text(
            text = "TWH ORG is a technology-focused learning platform helping students build practical skills in Cyber Security, Ethical Hacking, Web Development, Python, Linux, Networking and Database technologies.",
            color = TextSecondary,
            fontSize = 13.sp,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Cybersecurity / Technology Vector Art Illustration
        TechIllustrationCanvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Call to action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = onExploreCourses,
                colors = ButtonDefaults.buttonColors(containerColor = CyberGreen),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Explore Courses",
                    color = Color(0xFF07140B),
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            }

            OutlinedButton(
                onClick = onStartLearning,
                border = androidx.compose.foundation.BorderStroke(1.dp, CyberCyan),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Start Learning",
                    color = CyberCyan,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
fun TechIllustrationCanvas(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFF0B1626))
            .border(1.dp, TechCardBorder.copy(alpha = 0.6f), RoundedCornerShape(14.dp))
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width * 0.5f, size.height * 0.5f)

            // Radial Glow
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0x3300E5FF), Color(0x1000E676), Color.Transparent),
                    center = center,
                    radius = size.height * 0.7f
                ),
                center = center,
                radius = size.height * 0.7f
            )

            // Background circuit traces
            val circuit1 = Path().apply {
                moveTo(20f, size.height * 0.5f)
                lineTo(size.width * 0.35f, size.height * 0.5f)
                lineTo(size.width * 0.42f, size.height * 0.3f)
            }
            drawPath(circuit1, color = Color(0x3000E5FF), style = Stroke(width = 2f))

            val circuit2 = Path().apply {
                moveTo(size.width - 20f, size.height * 0.5f)
                lineTo(size.width * 0.65f, size.height * 0.5f)
                lineTo(size.width * 0.58f, size.height * 0.7f)
            }
            drawPath(circuit2, color = Color(0x3000E676), style = Stroke(width = 2f))

            // Cyber Defense Hex Shield in Center
            val shieldPath = Path().apply {
                val cx = center.x
                val cy = center.y
                moveTo(cx, cy - 35f)
                lineTo(cx + 30f, cy - 18f)
                lineTo(cx + 30f, cy + 18f)
                lineTo(cx, cy + 38f)
                lineTo(cx - 30f, cy + 18f)
                lineTo(cx - 30f, cy - 18f)
                close()
            }
            drawPath(
                path = shieldPath,
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF132A4A), Color(0xFF0A182B))
                )
            )
            drawPath(
                path = shieldPath,
                color = CyberCyan,
                style = Stroke(width = 2f)
            )

            // Center Security Node
            drawCircle(
                color = CyberGreen,
                radius = 6f,
                center = center
            )

            // Circuit Node Dots
            drawCircle(color = CyberCyan, radius = 4f, center = Offset(size.width * 0.35f, size.height * 0.5f))
            drawCircle(color = CyberGreen, radius = 4f, center = Offset(size.width * 0.65f, size.height * 0.5f))
        }

        // Overlay Tech Badges
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TechMiniBadge(label = "Cyber Defense", iconColor = CyberGreen)
            TechMiniBadge(label = "Hands-on Code", iconColor = CyberCyan)
        }
    }
}

@Composable
fun TechMiniBadge(label: String, iconColor: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xCC07111E))
            .border(1.dp, TechCardBorder, RoundedCornerShape(6.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .clip(CircleShape)
                .background(iconColor)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = label, color = TextPrimary, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun WhyTwhOrgGrid() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            WhyCard(
                title = "Practical Learning",
                description = "Direct hands-on lab exercises and real system configurations.",
                icon = Icons.Default.Build,
                accent = CyberGreen,
                modifier = Modifier.weight(1f)
            )
            WhyCard(
                title = "Technology Skills",
                description = "Master modern command line, scripting, and defensive tooling.",
                icon = Icons.Default.Code,
                accent = CyberCyan,
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            WhyCard(
                title = "Beginner Friendly",
                description = "Gentle step-by-step progressions with no complex prerequisites.",
                icon = Icons.Default.School,
                accent = CyberCyan,
                modifier = Modifier.weight(1f)
            )
            WhyCard(
                title = "Career-Oriented Skills",
                description = "Aligned with actual industry standards and technical demands.",
                icon = Icons.Default.TrendingUp,
                accent = CyberGreen,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun WhyCard(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    accent: Color,
    modifier: Modifier = Modifier
) {
    TechCard(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        contentPadding = 14.dp,
        accentGlow = accent
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF132742))
                .border(1.dp, accent.copy(alpha = 0.5f), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = accent,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = title,
            color = TextPrimary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = description,
            color = TextSecondary,
            fontSize = 11.sp,
            lineHeight = 16.sp
        )
    }
}

@Composable
fun CourseCard(
    course: CourseItem,
    onViewCourse: () -> Unit,
    onRegister: () -> Unit
) {
    TechCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        contentPadding = 16.dp,
        accentGlow = CyberGreen
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF132844))
                    .border(1.dp, CyberCyan.copy(alpha = 0.5f), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = course.icon,
                    contentDescription = course.title,
                    tint = CyberGreen,
                    modifier = Modifier.size(26.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = course.title,
                    color = TextPrimary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF10283A))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = course.level,
                            color = LevelBeginner,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${course.modulesCount} Modules",
                        color = TextMuted,
                        fontSize = 11.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = course.shortDescription,
            color = TextSecondary,
            fontSize = 12.sp,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = onViewCourse,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF142B47)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "View Course",
                    color = CyberCyan,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Button(
                onClick = onRegister,
                colors = ButtonDefaults.buttonColors(containerColor = CyberGreen),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Register",
                    color = Color(0xFF06140A),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun FreeLearningPromoCard(onExplore: () -> Unit) {
    TechCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        accentGlow = CyberCyan,
        contentPadding = 16.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF102842))
                    .border(1.dp, CyberCyan, RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AutoStories,
                    contentDescription = "Free Learning",
                    tint = CyberCyan,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "Start Learning for Free",
                    color = TextPrimary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Open access guides & structured tech topics",
                    color = TextSecondary,
                    fontSize = 11.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onExplore,
            colors = ButtonDefaults.buttonColors(containerColor = CyberCyan),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Explore Free Learning",
                color = Color(0xFF061420),
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun YouTubePromoCard(onVisit: () -> Unit) {
    TechCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        accentGlow = Color(0xFFFF3D00),
        contentPadding = 16.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF331414))
                    .border(1.dp, Color(0xFFFF5252), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "YouTube",
                    tint = Color(0xFFFF5252),
                    modifier = Modifier.size(28.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "Learn With TWH ORG",
                    color = TextPrimary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Official video tutorials & cyber sessions",
                    color = TextSecondary,
                    fontSize = 11.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onVisit,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE50914)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Visit YouTube Channel",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
fun InstagramPromoCard(onFollow: () -> Unit) {
    TechCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        accentGlow = Color(0xFFE1306C),
        contentPadding = 16.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF35122B))
                    .border(1.dp, Color(0xFFE1306C), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Instagram",
                    tint = Color(0xFFE1306C),
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "Follow TWH ORG",
                    color = TextPrimary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Stay updated with digital announcements",
                    color = TextSecondary,
                    fontSize = 11.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onFollow,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC13584)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Follow on Instagram",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun SectionHeader(title: String, subtitle: String) {
    Column {
        Text(
            text = title,
            color = TextPrimary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = subtitle,
            color = TextSecondary,
            fontSize = 12.sp
        )
    }
}
