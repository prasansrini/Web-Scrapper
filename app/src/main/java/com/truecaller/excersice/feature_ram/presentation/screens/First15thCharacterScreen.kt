package com.truecaller.excersice.feature_ram.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.truecaller.excersice.feature_ram.components.common.CharacterImage
import com.truecaller.excersice.feature_ram.components.common.CharacterNameComponent
import com.truecaller.excersice.feature_ram.components.common.DataPoint
import com.truecaller.excersice.feature_ram.components.common.DataPointEpisodeComponent
import com.truecaller.excersice.feature_ram.components.common.LoadingState
import com.truecaller.excersice.feature_ram.components.episode.EpisodeRowComponent
import com.truecaller.excersice.feature_ram.ui.theme.ColorAction
import com.truecaller.excersice.feature_ram.ui.theme.ColorPrimary
import com.truecaller.excersice.feature_ram.ui.theme.ColorSurface
import com.truecaller.excersice.feature_ram.ui.theme.ColorTextPrimary
import com.truecaller.excersice.feature_ram.ui.theme.PurpleGrey40
import com.truecaller.excersice.feature_ram.ui.theme.blue
import com.truecaller.network.models.domain.Character
import com.truecaller.network.models.domain.Episode

@Composable
fun First15thCharacterScreen(
    viewModel: TrueCallerViewModel = hiltViewModel()
) {
    var characterAt15State by remember {
        mutableStateOf<String?>(null)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.fetch15thCharacter {
            characterAt15State = it
        }
    }

    characterAt15State?.let {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .border(
                    width = 2.dp, color = PurpleGrey40, shape = RoundedCornerShape(8.dp)
                )
                .padding(all = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Truecaller15thCharacterRequest",
                fontSize = 12.sp,
                color = blue,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(all = 4.dp)
            )

            Spacer(modifier = Modifier.padding(all = 8.dp))

            Text(
                text = "15th character is \"$it\"",
                fontSize = 24.sp,
                color = ColorPrimary,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .border(
                        width = 2.dp, color = PurpleGrey40, shape = RoundedCornerShape(8.dp)
                    )
                    .padding(all = 4.dp)
            )
        }
    } ?: LoadingState()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(character: Character, episodes: List<Episode>) {

    val episodeBySeasonMap = episodes.groupBy {
        it.seasonNumber
    }

    LazyColumn(
        contentPadding = PaddingValues(all = 16.dp),
        modifier = Modifier.background(color = ColorPrimary)
    ) {
        item { CharacterNameComponent(name = character.name) }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item { CharacterImage(imageUrl = character.imageUrl) }

        item {
            LazyRow {
                episodeBySeasonMap.forEach { mapEntry ->
                    val title = "Season ${mapEntry.key}"
                    val description = "${mapEntry.value.size} eps"

                    item {
                        Row(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            DataPointEpisodeComponent(
                                dataPoint = DataPoint(
                                    title, description
                                )
                            )
                        }
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        episodeBySeasonMap.forEach { mapEntry ->

            stickyHeader { SeasonNumber(seasonNumber = mapEntry.key) }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            items(mapEntry.value) { episode ->
                EpisodeRowComponent(episode = episode)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun SeasonNumber(seasonNumber: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp, bottom = 16.dp
            )
            .background(color = ColorPrimary)
    ) {
        Text(
            text = "Season $seasonNumber",
            fontSize = 32.sp,
            color = ColorTextPrimary,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp, color = ColorSurface, shape = RoundedCornerShape(8.dp)
                )
                .padding(vertical = 4.dp)
        )
    }
}
