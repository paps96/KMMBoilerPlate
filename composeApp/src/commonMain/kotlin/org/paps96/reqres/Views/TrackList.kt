package org.paps96.reqres.Views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.example.TracksData

@Composable
fun TracksList(tracksData: TracksData, paddingValues: PaddingValues, onTrackSelected: (Pair<String?, List<String>>) -> Unit) {
    val albumAndArtistNames = getAlbumAndArtistNames(tracksData)
    val selectedTrackIndex = remember { mutableStateOf<Int?>(null) }

    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(paddingValues)
    ) {
        items(albumAndArtistNames) { (albumName, artistNames) ->
            val index = albumAndArtistNames.indexOf(Pair(albumName, artistNames))
            TrackCard(albumName = albumName, artistNames = artistNames) {
                selectedTrackIndex.value = index
                onTrackSelected(Pair(albumName, artistNames))
            }
        }
    }
}

fun getAlbumAndArtistNames(tracksData: TracksData): List<Pair<String?, List<String>>> {
    return tracksData.tracks.map { track ->
        Pair(track.albumName, track.artistName)
    }
}
