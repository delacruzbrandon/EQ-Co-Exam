package com.clutchit.emotionalintelligencecoexam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.clutchit.emotionalintelligencecoexam.R
import com.clutchit.emotionalintelligencecoexam.ui.theme.Black
import com.clutchit.emotionalintelligencecoexam.ui.theme.EmotionalIntelligenceCoExamTheme
import com.clutchit.emotionalintelligencecoexam.ui.theme.GrayTextColor
import com.clutchit.emotionalintelligencecoexam.ui.theme.White
import com.clutchit.emotionalintelligencecoexam.utils.padding_10dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_12dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_16dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_32dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_4dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_64dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_8dp
import com.clutchit.emotionalintelligencecoexam.utils.radius_8dp

@Composable
fun HomeContent() {
    val modifier = Modifier

    Column(
        modifier = modifier
            .padding(top = padding_32dp, bottom = padding_8dp)
    ) {
        HomeLevelItem(modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    EmotionalIntelligenceCoExamTheme {
        HomeContent()
    }
}

@Composable
fun HomeLevelItem(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LevelHeader(modifier)
    }
}

@Composable
fun LevelHeader(
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LevelHeaderImage(
            modifier = modifier
        )
        Spacer(
            modifier = modifier.height(padding_16dp)
        )
        LevelHeaderText(
            modifier = modifier
        )
        LevelActivityList(
            modifier = modifier
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
fun LevelHeaderImage(
    modifier: Modifier
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
                    shape = RoundedCornerShape(radius_8dp)
                )
                .padding(
                    horizontal = padding_12dp,
                    vertical = padding_4dp
                )
        ) {
            Text(
                text = "LEVEL 1",
                style = MaterialTheme.typography.bodySmall,
                color = White
            )
        }
    }
}

@Composable
fun LevelHeaderText(
    modifier: Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = padding_64dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Find your tools",
            style = MaterialTheme.typography.titleMedium,
            color = Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.height(padding_4dp))
        Text(
            text = "Collect the best ways for you to notice and manage anger",
            style = MaterialTheme.typography.bodyMedium,
            color = GrayTextColor,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LevelActivityList(
    modifier: Modifier
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.Center,
        userScrollEnabled = false
    ) {
        items(5) { activity ->
            LevelActivityItem(
                modifier = modifier
            )
        }
    }
}

@Composable
fun LevelActivityItem(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier
                .padding(horizontal = padding_8dp),
            painter = painterResource(id = R.mipmap.bg_cutie1),
            contentDescription = stringResource(id = R.string.bg_activity)
        )
        Spacer(modifier = modifier.height(padding_10dp))
        Text(
            text = "Activity Title",
            style = MaterialTheme.typography.titleSmall
        )

    }
}