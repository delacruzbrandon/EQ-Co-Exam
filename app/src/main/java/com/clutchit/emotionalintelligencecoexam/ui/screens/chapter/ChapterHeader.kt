package com.clutchit.emotionalintelligencecoexam.ui.screens.chapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.clutchit.emotionalintelligencecoexam.R
import com.clutchit.emotionalintelligencecoexam.ui.theme.Black
import com.clutchit.emotionalintelligencecoexam.ui.theme.GrayTextColor
import com.clutchit.emotionalintelligencecoexam.ui.theme.White
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_12DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_16DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_4DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_64DP
import com.clutchit.emotionalintelligencecoexam.utils.RADIUS_8DP

@Composable
fun ChapterHeader(
    modifier: Modifier,
    chapterLevel: String,
    chapterTitle: String,
    chapterDescription: String
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ChapterHeaderImage(
            modifier = modifier,
            level = chapterLevel
        )
        Spacer(
            modifier = modifier.height(PADDING_16DP)
        )
        ChapterHeaderText(
            modifier = modifier,
            title = chapterTitle,
            description = chapterDescription
        )
    }
}

private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val headerImage = createRefFor("headerImage")
        val headerImageText = createRefFor("headerImageText")

        constrain(headerImageText) {
            top.linkTo(headerImage.bottom)
            bottom.linkTo(headerImage.bottom)
            start.linkTo(headerImage.start)
            end.linkTo(headerImage.end)
        }
    }
}

@Composable
fun ChapterHeaderImage(
    modifier: Modifier,
    level: String
) {
    ConstraintLayout(
        constraintSet = decoupledConstraints()
    ) {
        Image(
            modifier = modifier
                .layoutId("headerImage"),
            painter = painterResource(
                id = R.drawable.bg_castle
            ),
            contentDescription = stringResource(
                id = R.string.bg_castle
            )
        )
        Box(
            modifier = modifier
                .layoutId("headerImageText")
                .background(
                    Black,
                    shape = RoundedCornerShape(RADIUS_8DP)
                )
                .padding(
                    horizontal = PADDING_12DP,
                    vertical = PADDING_4DP
                )
        ) {
            Text(
                text = "Level $level",
                style = MaterialTheme.typography.bodySmall,
                color = White
            )
        }
    }
}
@Composable
fun ChapterHeaderText(
    modifier: Modifier,
    title: String,
    description: String
) {
    Column(
        modifier = modifier.padding(horizontal = PADDING_64DP),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.height(PADDING_4DP))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = GrayTextColor,
            textAlign = TextAlign.Center
        )
    }
}

