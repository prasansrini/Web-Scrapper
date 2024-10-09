package com.truecaller.excersice.feature_ram.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.truecaller.excersice.feature_ram.components.common.LoadingState
import com.truecaller.excersice.feature_ram.ui.theme.ColorAction
import com.truecaller.excersice.feature_ram.ui.theme.ColorPrimary
import com.truecaller.excersice.feature_ram.ui.theme.PurpleGrey40
import com.truecaller.excersice.feature_ram.ui.theme.blue

@Composable
fun First15thCharacterComponent(
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
        MainCharacterComponent(it)
    } ?: LoadingState()
}

@Composable
fun MainCharacterComponent(characterAtFifteen: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(all = 8.dp)
            .border(
                width = 2.dp, color = PurpleGrey40, shape = RoundedCornerShape(8.dp)
            )
            .padding(all = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
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
            text = "15th character is \"$characterAtFifteen\"",
            fontSize = 16.sp,
            color = ColorPrimary,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp, color = ColorAction, shape = RoundedCornerShape(8.dp)
                )
                .padding(all = 4.dp)
        )
    }
}
