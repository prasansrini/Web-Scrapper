package com.truecaller.excersice.feature_ram.presentation.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.truecaller.excersice.feature_ram.ui.theme.TrueCallerAppTheme
import com.truecaller.excersice.feature_ram.ui.theme.ColorTextPrimary
import com.truecaller.network.models.domain.CharacterStatus

@Composable
fun CharacterStatusComponent(characterStatus: CharacterStatus) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier
			.border(
				width = 1.dp,
				color = characterStatus.color,
				shape = RoundedCornerShape(12.dp)
			)
			.padding(
				horizontal = 12.dp,
				vertical = 4.dp
			)
	) {
		Text(
			text = "Status: ${characterStatus.displayName}",
			fontSize = 20.sp,
			color = ColorTextPrimary
		)
	}
}

@Preview
@Composable
fun CharacterStatusComponentPreviewAlive() {
	TrueCallerAppTheme {
		CharacterStatusComponent(characterStatus = CharacterStatus.Alive)
	}
}