package org.paps96.reqres.Views


import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import org.paps96.reqres.ViewModels.WelcomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(viewModel: WelcomeScreenViewModel) {
    Screen {
        val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
        Scaffold(
            topBar = { MyTopBar(scrollBehavior, onSettingsClick = { println("Top bar button") }) },
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) { padding ->
            val tracksData by viewModel.tracksData.collectAsState()
            val isLoading by viewModel.isLoading.collectAsState()

            if (isLoading) {
                CircularProgressIndicator()
            } else {
                tracksData?.let { data ->
                    TracksList(tracksData = data, paddingValues = padding) { selectedTrack ->
                        println("Selected track: $selectedTrack")
                    }
                } ?: run {
                    Text("No hay datos disponibles.")
                }
            }
        }
    }
}