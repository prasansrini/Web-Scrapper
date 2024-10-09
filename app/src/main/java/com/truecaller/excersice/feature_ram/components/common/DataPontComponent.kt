package com.truecaller.excersice.feature_ram.components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.truecaller.excersice.feature_ram.ui.theme.ColorAction
import com.truecaller.excersice.feature_ram.ui.theme.ColorPrimary

data class DataPoint(
    val data: String, val value: String? = null
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
            text = dataPoint.data,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = ColorPrimary
        )
    }
}

@Composable
fun DataPointWordCountComponent(dataPoint: DataPoint) {
    Row(
        modifier = Modifier
            .border(
                width = 2.dp, color = ColorAction, shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = dataPoint.data,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = ColorPrimary
        )

        Text(
            text = ": ",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = ColorPrimary
        )

        Text(
            text = dataPoint.value!!,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = ColorPrimary
        )
    }
}