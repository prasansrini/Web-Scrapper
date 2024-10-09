package com.truecaller.excersice.feature_ram.presentation.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.truecaller.excersice.feature_ram.components.common.DataPointComponent
import com.truecaller.excersice.feature_ram.components.common.DataPointWordCountComponent
import com.truecaller.excersice.feature_ram.components.common.LoadingState
import com.truecaller.excersice.feature_ram.ui.theme.ColorPrimary
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
    } ?: LoadingState()
}

@Composable
fun MainWordCountComponent(map: Map<String, Int>) {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(all = 8.dp)
            .border(
                width = 2.dp, color = PurpleGrey40, shape = RoundedCornerShape(8.dp)
            )
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TruecallerWordCounterRequest",
            fontSize = 12.sp,
            color = blue,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(all = 4.dp)
        )

        Spacer(modifier = Modifier.padding(all = 8.dp))

        LazyColumn {
            map.forEach { (key, value) ->
                item {
                    Row(
                        modifier = Modifier
                            .padding(all = 12.dp)
//                            .height(48.dp)
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
