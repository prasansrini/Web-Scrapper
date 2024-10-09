package com.truecaller.excersice.feature_ram.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.truecaller.excersice.feature_ram.components.common.DataPoint
import com.truecaller.excersice.feature_ram.components.common.DataPointWordCountComponent
import com.truecaller.excersice.feature_ram.components.common.LoadingState
import com.truecaller.excersice.feature_ram.ui.theme.PurpleGrey40
import com.truecaller.excersice.feature_ram.ui.theme.blue

@Composable
fun WordCountComponent(
    viewModel: TrueCallerViewModel = hiltViewModel()
) {
    var characterAt15State by remember {
        mutableStateOf<Map<String, Int>?>(null)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchWordCount {
            characterAt15State = it
        }
    }

    characterAt15State?.let {
        MainWordCountComponent(it)
    }
}

@Composable
fun MainWordCountComponent(map: Map<String, Int>) {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(8.dp)
            .border(
                width = 2.dp, color = PurpleGrey40, shape = RoundedCornerShape(8.dp)
            )
            .padding(all = 16.dp)
    ) {
        Text(
            text = "TruecallerWordCounterRequest",
            fontSize = 12.sp,
            color = blue,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(all = 4.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.padding(all = 8.dp))

        LazyColumn {
            map.forEach { (key, value) ->
                item {
                    Column(
                        modifier = Modifier.padding(all = 12.dp)
                    ) {
                        DataPointWordCountComponent(
                            dataPoint = DataPoint(key, value.toString())
                        )
                    }
                }
            }
        }
    }
}
