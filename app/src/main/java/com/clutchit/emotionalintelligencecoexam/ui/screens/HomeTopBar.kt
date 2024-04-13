package com.clutchit.emotionalintelligencecoexam.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clutchit.emotionalintelligencecoexam.R
import com.clutchit.emotionalintelligencecoexam.ui.theme.Black
import com.clutchit.emotionalintelligencecoexam.ui.theme.DisabledTextColor
import com.clutchit.emotionalintelligencecoexam.ui.theme.LightShadow
import com.clutchit.emotionalintelligencecoexam.ui.theme.Purple
import com.clutchit.emotionalintelligencecoexam.ui.theme.SelectedTextColor
import com.clutchit.emotionalintelligencecoexam.utils.boxSize_24dp
import com.clutchit.emotionalintelligencecoexam.utils.dayEllipseSize_16dp
import com.clutchit.emotionalintelligencecoexam.utils.dp_2
import com.clutchit.emotionalintelligencecoexam.utils.dp_4
import com.clutchit.emotionalintelligencecoexam.utils.dp_6
import com.clutchit.emotionalintelligencecoexam.utils.padding_10dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_16dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_2dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_4dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_6dp
import com.clutchit.emotionalintelligencecoexam.utils.padding_8dp
import com.clutchit.emotionalintelligencecoexam.utils.shadowElevation_1dp
import com.clutchit.emotionalintelligencecoexam.utils.userIconSize_40dp


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
            .padding(
                horizontal = padding_16dp,
                vertical = padding_10dp
            )
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
                horizontal = padding_16dp,
                vertical = padding_10dp
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
            Spacer(modifier = modifier.height(padding_4dp))
            Box(
                modifier = modifier
                    .size(boxSize_24dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(dayEllipseSize_16dp),
                    painter = painterResource(id = ellipse),
                    contentDescription = stringResource(id = R.string.ic_ellipse),
                )
            }
            Spacer(modifier = modifier.height(padding_8dp))
            Text(
                text = day,
                style = MaterialTheme.typography.labelMedium,
                color = textColor,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(padding_8dp))
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
        Spacer(modifier = modifier.width(padding_16dp))
        Column {
            Text(
                text = stringResource(id = R.string.top_bar_title),
                style = MaterialTheme.typography.titleSmall,
                color = Black,
            )
            Spacer(modifier = modifier.height(padding_6dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = modifier.height(dp_4),
                    painter = painterResource(id = R.mipmap.bg_segment),
                    contentDescription = stringResource(id = R.string.bg_segment)
                )
                Spacer(modifier = modifier.width(dp_6))
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
        Spacer(modifier = modifier.width(padding_2dp))
        Text(
            text = stringResource(id = R.string.top_bar_fire_number),
            style = MaterialTheme.typography.labelMedium,
            color = Purple
        )
        Spacer(modifier = modifier.width(padding_16dp))
        Box(
            modifier = modifier
                .size(userIconSize_40dp)
                .clip(CircleShape)
                .shadow(
                    elevation = shadowElevation_1dp,
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