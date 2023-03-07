package usg.ihealth.ui.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val darkColorPalette = darkColors(
    primary = Primary200,
    primaryVariant = PrimaryVariant,
    background = BlackDark,
    surface = BlackLight,
    onBackground = WhiteLight,
    onSurface = WhiteLight,
    onPrimary = BlackDark
)

private val lightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = PrimaryVariant,
    background = WhiteDark,
    surface = WhiteLight,
    onBackground = BlackDark,
    onSurface = BlackDark,
    onPrimary = WhiteLight
)

@Composable
fun OnBoardingTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {

    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}