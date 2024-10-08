package com.truecaller.excersice.feature_ram.components.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.truecaller.excersice.feature_ram.ui.theme.ColorAction

@Composable
fun CharacterNameComponent(name: String) {
	Text(
		text = name,
		fontSize = 42.sp,
		lineHeight = 42.sp,
		fontWeight = FontWeight.Bold,
		color = ColorAction
	)
}