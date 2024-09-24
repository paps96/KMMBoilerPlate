package org.paps96.reqres.Views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrackCard(albumName: String?, artistNames: List<String>, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Album: $albumName", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Artists: ${artistNames.joinToString(", ")}", style = MaterialTheme.typography.bodySmall)
        }
    }
}