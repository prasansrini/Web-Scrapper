package com.truecaller.excersice.feature_tc.components.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.truecaller.excersice.feature_tc.ui.theme.blue

@Composable
fun LoadingState(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 128.dp), color = blue
    )
}