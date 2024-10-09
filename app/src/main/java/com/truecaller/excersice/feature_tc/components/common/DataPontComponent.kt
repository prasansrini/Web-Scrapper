package com.truecaller.excersice.feature_tc.components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.truecaller.excersice.feature_tc.ui.theme.ColorAction
import com.truecaller.excersice.feature_tc.ui.theme.ColorPrimary

data class DataPoint(
    val character: String, val wordOccurrence: String? = null
)

@Composable
fun DataPointComponent(dataPoint: DataPoint) {
    Column(
        modifier = Modifier
            .border(
                width = 2.dp, color = ColorAction, shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = dataPoint.character,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = ColorPrimary
        )
    }
}

@Composable
fun DataPointWordCountComponent(dataPoint: DataPoint) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp, color = ColorAction, shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = dataPoint.character + ": ",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = ColorPrimary,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = when {
                dataPoint.wordOccurrence?.toInt() == 1 -> "${dataPoint.wordOccurrence} occurrence"
                else -> "${dataPoint.wordOccurrence} occurrences"
            }, fontSize = 14.sp, fontWeight = FontWeight.Normal, color = ColorPrimary
        )
    }
}