package com.clutchit.emotionalintelligencecoexam.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.clutchit.emotionalintelligencecoexam.R
import com.clutchit.emotionalintelligencecoexam.data.models.LevelList
import com.clutchit.emotionalintelligencecoexam.ui.screens.components.EmptyContent
import com.clutchit.emotionalintelligencecoexam.ui.screens.components.LoadingContent
import com.clutchit.emotionalintelligencecoexam.ui.screens.chapter.ChapterContent
import com.clutchit.emotionalintelligencecoexam.ui.theme.LightShadow
import com.clutchit.emotionalintelligencecoexam.ui.theme.Purple
import com.clutchit.emotionalintelligencecoexam.util.RequestState
import com.clutchit.emotionalintelligencecoexam.utils.SHADOW_ELEVATION_1DP

@Composable
fun HomeContent(
    levelListState: RequestState<LevelList>
) {
    if (levelListState is RequestState.Success) {
        if (levelListState.data.levels.isEmpty()) {
            EmptyContent()
        } else {
            ChapterList(levelList = levelListState.data)
        }
    } else if (levelListState is RequestState.Loading) {
        LoadingContent()
    } else {
        EmptyContent()
    }
}


@Composable
fun ChapterList(
    levelList: LevelList
) {
    val modifier = Modifier
    LazyColumn {
        items(count = levelList.levels.size) { levelIndex ->
            ChapterContent(
                modifier = modifier,
                level = levelList.levels[levelIndex]
            )
        }
        item {
            Box(
                modifier = modifier
                    .height(76.dp)
                    .fillMaxWidth()
                    .shadow(
                        elevation = SHADOW_ELEVATION_1DP,
                        ambientColor = LightShadow
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_flag),
                    contentDescription = stringResource(id = R.string.ic_flag),
                    tint = Purple
                )
            }

        }
    }
}


