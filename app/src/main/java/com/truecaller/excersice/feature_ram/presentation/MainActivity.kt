package com.truecaller.excersice.feature_ram.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.truecaller.excersice.feature_ram.presentation.components.Every15thCharacterComponent
import com.truecaller.excersice.feature_ram.ui.theme.TrueCallerAppTheme
import com.truecaller.excersice.feature_ram.presentation.components.First15thCharacterComponent
import com.truecaller.excersice.feature_ram.presentation.components.WordCountComponent
import com.truecaller.excersice.feature_ram.ui.theme.ColorPrimary
import com.truecaller.excersice.feature_ram.ui.theme.PurpleGrey40
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TrueCallerAppTheme {
                Column {
                    First15thCharacterComponent()
                    Spacer(modifier = Modifier.padding(all = 8.dp))
                    Every15thCharacterComponent()
                    Spacer(modifier = Modifier.padding(all = 8.dp))
                    WordCountComponent()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainItem() {
    TrueCallerAppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "15th character",
                fontSize = 32.sp,
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
    }
}
