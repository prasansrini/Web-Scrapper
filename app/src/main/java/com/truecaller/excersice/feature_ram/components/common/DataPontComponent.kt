package com.truecaller.excersice.feature_ram.components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.truecaller.excersice.feature_ram.ui.theme.ColorAction
import com.truecaller.excersice.feature_ram.ui.theme.ColorTextPrimary

data class DataPoint(
		val title: String, val description: String
)

@Composable
fun DataPointComponent(dataPoint: DataPoint) {
	Column {
		Text(
			text = dataPoint.title,
			fontSize = 14.sp,
			fontWeight = FontWeight.Bold,
			color = ColorAction
		)
		Text(
			text = dataPoint.description,
			fontSize = 24.sp,
			color = ColorTextPrimary
		)
	}
}

@Composable
fun DataPointEpisodeComponent(dataPoint: DataPoint) {
	Column(
		modifier = Modifier
			.border(
				width = 2.dp,
				color = ColorAction,
				shape = RoundedCornerShape(size = 12.dp)
			)
			.padding(12.dp)
	) {
		Text(
			text = dataPoint.title,
			fontSize = 14.sp,
			fontWeight = FontWeight.Bold,
			color = ColorAction
		)
		Text(
			text = dataPoint.description,
			fontSize = 24.sp,
			color = ColorTextPrimary
		)
	}
}

@Preview
@Composable
fun DataPointPreview(modifier: Modifier = Modifier) {
	DataPointEpisodeComponent(
		DataPoint(
			"Last known location",
			"Location"
		)
	)
}