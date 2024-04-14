package com.clutchit.emotionalintelligencecoexam.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.clutchit.emotionalintelligencecoexam.R
import com.clutchit.emotionalintelligencecoexam.ui.theme.Gray
import com.clutchit.emotionalintelligencecoexam.utils.EMPTY_CONTENT_ICON_SIZE_120DP

@Composable
fun EmptyContent() {
    val modifier = Modifier
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(EMPTY_CONTENT_ICON_SIZE_120DP),
            painter = painterResource(id = R.drawable.ic_sad_face),
            contentDescription = stringResource(id = R.string.ic_sad_face),
            tint = Gray
        )
        Text(
            text = stringResource(id = R.string.empty_content),
            color = Gray,
            style = MaterialTheme.typography.bodySmall
        )
    }
}