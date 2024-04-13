package com.clutchit.emotionalintelligencecoexam.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.clutchit.emotionalintelligencecoexam.R

val euclidCircularFamily = FontFamily(
    Font(R.font.euclid_circular_b_bold, FontWeight.Bold),
    Font(R.font.euclid_circular_b_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.euclid_circular_b_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.euclid_circular_b_light, FontWeight.Light),
    Font(R.font.euclid_circular_b_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.euclid_circular_b_medium, FontWeight.Medium),
    Font(R.font.euclid_circular_b_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.euclid_circular_b_regular, FontWeight.Normal),
    Font(R.font.euclid_circular_b_semi_bold, FontWeight.SemiBold),
    Font(R.font.euclid_circular_b_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = euclidCircularFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = euclidCircularFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = euclidCircularFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = euclidCircularFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = euclidCircularFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = euclidCircularFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    labelSmall = TextStyle(
        fontFamily = euclidCircularFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = euclidCircularFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.5.sp
    )
)
