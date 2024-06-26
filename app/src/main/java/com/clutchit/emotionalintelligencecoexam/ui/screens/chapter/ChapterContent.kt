package com.clutchit.emotionalintelligencecoexam.ui.screens.chapter

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.clutchit.emotionalintelligencecoexam.R
import com.clutchit.emotionalintelligencecoexam.data.models.Activity
import com.clutchit.emotionalintelligencecoexam.data.models.Level
import com.clutchit.emotionalintelligencecoexam.utils.DP_4
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_10DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_24DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_32DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_8DP

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChapterContent(
    modifier: Modifier,
    level: Level
) {
    val listSize = level.activities.size

    Column(
        modifier = modifier.padding(vertical = PADDING_32DP)
    ) {
        ChapterHeader(
            modifier = modifier,
            chapterLevel = level.level,
            chapterTitle = level.title,
            chapterDescription = level.description
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(DP_4),
            maxItemsInEachRow = 2
        ) {
            val itemModifier = Modifier
            repeat(listSize) { activityIndex ->
                // if the activity list is not an even number
                // don't use weight modifier, but rather fillMaxWidth
                if ((activityIndex + 1) % listSize + 2 == 0) {
                    ChapterItem(
                        modifier = itemModifier.fillMaxWidth(),
                        activity = level.activities[activityIndex]
                    )
                } else {
                    ChapterItem(
                        modifier = itemModifier.weight(0.5f),
                        activity = level.activities[activityIndex]

                    )
                }
            }
        }
    }
}

@Composable
fun ChapterItem(
    modifier: Modifier,
    activity: Activity
) {
    val itemModifier = Modifier

    Column(
        modifier = modifier.padding(top = PADDING_24DP),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = itemModifier
                .width(144.dp)
                .height(132.dp)
                .padding(horizontal = PADDING_8DP),
            painter = painterResource(id = R.mipmap.bg_cutie1),
            contentDescription = stringResource(R.string.bg_activity),
        )
        Spacer(modifier = itemModifier.height(PADDING_10DP))
        Text(
            text = activity.title,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center
        )

    }
}