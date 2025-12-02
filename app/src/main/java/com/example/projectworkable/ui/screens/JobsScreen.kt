package com.example.projectworkable.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.projectworkable.ui.components.JobCard
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectworkable.R

data class Job(
    val title: String,
    val description: String,
    val detail: String,
    val companyLogo: Painter,
    val tag: String
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun JobsScreen() {
    val jobs = listOf(
        Job(
            title = "Software Engineer",
            description = "Join TechNova Solutions as a Software Engineer and help build high-performance applications used by thousands of customers.",
            detail = "Work with Kotlin, Java, and cloud technologies to design and implement scalable features.",
            companyLogo = painterResource(id = R.drawable.ic_temporary),
            tag = "Engineering"
        ),
        Job(
            title = "Product Manager",
            description = "Lead the development of next-generation digital products at VisionPath Labs.",
            detail = "Coordinate with engineering, design, and marketing teams while driving product strategy.",
            companyLogo = painterResource(id = R.drawable.ic_temporary),
            tag = "Product"
        ),
        Job(
            title = "Head Chef",
            description = "Aurora Bistro seeks an experienced Head Chef to manage kitchen staff and create innovative dishes.",
            detail = "Oversee daily kitchen operations, menu creation, and food quality control.",
            companyLogo = painterResource(id = R.drawable.ic_temporary),
            tag = "Culinary"
        ),
        Job(
            title = "Graphic Designer",
            description = "Create stunning visual assets for marketing campaigns as part of PixelCraft Media’s creative team.",
            detail = "Produce digital ads, social media graphics, and brand materials using Adobe Creative Suite.",
            companyLogo = painterResource(id = R.drawable.ic_temporary),
            tag = "Design"
        )
    )

    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /** ---------------- HEADER ---------------- */
        item {
            AnimatedVisibility(
                visible = visible,
                enter = slideInVertically(animationSpec = tween(600)) +
                        fadeIn(animationSpec = tween(600))
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_accessibility),
                        contentDescription = "WorkAble Logo",
                        modifier = Modifier.size(80.dp),
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "WorkAble Jobs",
                        fontSize = 32.sp,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Latest opportunities picked for you",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
        }

        /** ---------------- JOB CARDS LIST ---------------- */
        items(jobs) { job ->
            JobCard(
                title = job.title,
                description = job.description,
                detail = job.detail,
                image = job.companyLogo,
                tag = job.tag,
                onClick = { /* Handle job click */ }
            )
        }
    }
}

