import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.projectworkable.ui.components.JobCard
import androidx.compose.ui.unit.dp
import com.example.projectworkable.R

data class Job(
    val title: String,
    val description: String,
    val companyLogo: Painter,
    val tag: String
)

@Composable
fun JobsScreen() {
    // In a real app, this list would come from a ViewModel or an API call.
    val jobs = listOf(
        Job(
            title = "Software Engineer",
            description = "We are looking for a skilled Software Engineer to join our dynamic team...",
            // Ensure you have these drawables in your res/drawable folder
            companyLogo = painterResource(id = R.drawable.ic_temporary),
            tag = "Engineering"
        ),
        Job(
            title = "Product Manager",
            description = "Lead the development of our next-generation products...",
            companyLogo = painterResource(id = R.drawable.ic_temporary),
            tag = "Product"
        ),
        // --- ADD YOUR NEW JOBS HERE ---
        Job(
            title = "Head Chef",
            description = "Manage our kitchen staff and create innovative new dishes for our menu.",
            companyLogo = painterResource(id = R.drawable.ic_temporary), // Add a new icon
            tag = "Culinary"
        ),
        Job(
            title = "Graphic Designer",
            description = "Create visually stunning graphics for marketing campaigns and our brand.",
            companyLogo = painterResource(id = R.drawable.ic_temporary), // Add a new icon
            tag = "Design"
        )
        // You can add as many jobs as you want here...
    )

    // The LazyColumn will automatically create a card for each job in the list above.
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header Item
        item {
            Column {
                Text(
                    text = stringResource(id = R.string.jobs_screen_title),
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = stringResource(id = R.string.jobs_screen_description))
            }
        }

        // Job Items List - NO CHANGES NEEDED HERE
        items(jobs) { job ->
            JobCard(
                title = job.title,
                description = job.description,
                image = job.companyLogo,
                onClick = { /* Handle click for this specific job */ },
                tag = job.tag
            )
        }
    }
}
