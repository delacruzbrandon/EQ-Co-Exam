package com.clutchit.emotionalintelligencecoexam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.clutchit.emotionalintelligencecoexam.R
import com.clutchit.emotionalintelligencecoexam.ui.theme.Black
import com.clutchit.emotionalintelligencecoexam.ui.theme.DisabledTextColor
import com.clutchit.emotionalintelligencecoexam.ui.theme.LightShadow
import com.clutchit.emotionalintelligencecoexam.ui.theme.Purple
import com.clutchit.emotionalintelligencecoexam.ui.theme.SelectedTextColor
import com.clutchit.emotionalintelligencecoexam.utils.BOX_SIZE_24DP
import com.clutchit.emotionalintelligencecoexam.utils.ELLIPSE_SIZE_16DP
import com.clutchit.emotionalintelligencecoexam.utils.DP_4
import com.clutchit.emotionalintelligencecoexam.utils.DP_6
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_10DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_16DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_2DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_4DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_6DP
import com.clutchit.emotionalintelligencecoexam.utils.PADDING_8DP
import com.clutchit.emotionalintelligencecoexam.utils.SHADOW_ELEVATION_1DP
import com.clutchit.emotionalintelligencecoexam.utils.USER_ICON_SIZE_40DP


@Composable
fun HomeTopBar(
) {
    val modifier = Modifier

    val dayList = listOf(
        "MON",
        "TUE",
        "WEN",
        "THU",
        "FRI",
        "SAT",
        "SUN",
    )

    Column(
        modifier = modifier
            .background(colorResource(id = R.color.white))
            .fillMaxWidth()
    ) {
        TopBarTracker(modifier = modifier)
        TopBarWeekList(days = dayList, modifier = modifier)
    }
}

@Composable
fun TopBarTracker(
    modifier: Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = PADDING_16DP,
                vertical = PADDING_10DP
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Tracker(modifier = modifier)
        UserIcon(modifier = modifier)
    }
}

@Composable
fun TopBarWeekList(
    days: List<String>,
    modifier: Modifier
) {
    var selectedDay by remember { mutableStateOf(0) }

    LazyRow(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        userScrollEnabled = false
    ) {
        itemsIndexed(days) { dayIndex, day ->

            val ellipseColor = if (dayIndex == selectedDay) R.drawable.ic_elipse_filled else R.drawable.ic_elipse_open
            val textColor = if (dayIndex == selectedDay) SelectedTextColor else DisabledTextColor

            TopBarDayItem(
                day = day,
                modifier = modifier,
                ellipse = ellipseColor,
                textColor = textColor,
                onClickDay = {
                    selectedDay = dayIndex
                }
            )


        }
    }
}

@Composable
fun TopBarDayItem(
    day: String,
    modifier: Modifier,
    ellipse: Int,
    textColor: Color,
    onClickDay: () -> Unit
) {
    Surface(
        onClick = onClickDay
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = modifier.height(PADDING_4DP))
            Box(
                modifier = modifier
                    .size(BOX_SIZE_24DP),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(ELLIPSE_SIZE_16DP),
                    painter = painterResource(id = ellipse),
                    contentDescription = stringResource(id = R.string.ic_ellipse),
                )
            }
            Spacer(modifier = modifier.height(PADDING_8DP))
            Text(
                text = day,
                style = MaterialTheme.typography.labelMedium,
                color = textColor,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(PADDING_8DP))
        }

    }

}

@Preview
@Composable
fun PreviewTopBarDayItem() {
    TopBarDayItem(
        day = "MON",
        modifier = Modifier,
        ellipse = R.drawable.ic_elipse_filled,
        textColor = SelectedTextColor,
        onClickDay = { }
    )
}

@Composable
fun Tracker(modifier: Modifier) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_journey),
            contentDescription = stringResource(id = R.string.ic_journey),
        )
        Spacer(modifier = modifier.width(PADDING_16DP))
        Column {
            Text(
                text = stringResource(id = R.string.top_bar_title),
                style = MaterialTheme.typography.titleSmall,
                color = Black,
            )
            Spacer(modifier = modifier.height(PADDING_6DP))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = modifier.height(DP_4),
                    painter = painterResource(id = R.mipmap.bg_segment),
                    contentDescription = stringResource(id = R.string.bg_segment)
                )
                Spacer(modifier = modifier.width(DP_6))
                Text(
                    text = stringResource(id = R.string.top_bar_progress),
                    style = MaterialTheme.typography.labelSmall,
                    color = Purple
                )
            }
        }
    }
}

@Composable
fun UserIcon(modifier: Modifier) {
    Row(
        modifier = modifier
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_fire),
            contentDescription = stringResource(id = R.string.ic_fire)
        )
        Spacer(modifier = modifier.width(PADDING_2DP))
        Text(
            text = stringResource(id = R.string.top_bar_fire_number),
            style = MaterialTheme.typography.labelMedium,
            color = Purple
        )
        Spacer(modifier = modifier.width(PADDING_16DP))
        Box(
            modifier = modifier
                .size(USER_ICON_SIZE_40DP)
                .clip(CircleShape)
                .shadow(
                    elevation = SHADOW_ELEVATION_1DP,
                    shape = CircleShape,
                    ambientColor = LightShadow
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = stringResource(id = R.string.ic_person),
                tint = Purple
            )
        }
    }
}