package co.com.jap.ui.theme

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat

private val LighColorSchema = lightColorScheme(
    primary = color_theme_light_on_primary,
    onPrimary = color_theme_light_primary,
    secondary = color_theme_light_secondary,
    onSecondary = color_theme_light_on_secondary,
    tertiary = color_theme_light_tertiary,
    onTertiary = color_theme_light_on_tertiary,
    background = color_theme_light_background,
    onBackground = color_theme_light_on_background,
   surface = color_theme_light_surface,
   onSurface = color_theme_light_on_surface,
    error = color_theme_light_error,
    onError = color_theme_light_on_error,
    onPrimaryContainer = color_theme_light_on_primary_container,
    primaryContainer = color_theme_light_primary_container,
    onSecondaryContainer = color_theme_light_on_secondary_container,
    secondaryContainer = color_theme_light_secondary_container,
    onTertiaryContainer = color_theme_light_on_tertiary_container,
    tertiaryContainer = color_theme_light_tertiary_container,
    inversePrimary = color_theme_light_primary_inverse
)

private val DarkColorSchema = darkColorScheme(
    primary = color_theme_dark_primary,
    onPrimary = color_theme_dark_on_primary,
    secondary = color_theme_dark_secondary,
    onSecondary = color_theme_dark_on_secondary,
    tertiary = color_theme_dark_tertiary,
    onTertiary = color_theme_dark_on_tertiary,
    background = color_theme_dark_background,
    onBackground = color_theme_dark_on_background,
    surface = color_theme_dark_surface,
    onSurface = color_theme_dark_on_surface,
    error = color_theme_dark_error,
    onError = color_theme_dark_on_error,
    primaryContainer = color_theme_dark_primary_container,
    onPrimaryContainer = color_theme_dark_on_primary_container,
    secondaryContainer = color_theme_dark_secondary_container,
    onSecondaryContainer = color_theme_dark_on_secondary_container,
    tertiaryContainer = color_theme_dark_tertiary_container,
    onTertiaryContainer = color_theme_dark_on_tertiary_container,
    inversePrimary = color_theme_dark_primary
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MaterialThemeComposeUI(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
){
    val colorSchema = getColorSchema(darkTheme, dynamicColor, LocalContext.current)

    settingView(colorSchema, darkTheme)

    applyMaterialTheme(colorScheme = colorSchema, content = content)

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun applyMaterialTheme(colorScheme: ColorScheme, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = TypoGraphy,
        content = content
    )
}

@Composable
private fun settingView(colorScheme: ColorScheme, darkTheme: Boolean){
    val view = LocalView.current
    if(!view.isInEditMode){
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.secondary.toArgb()
            WindowCompat.getInsetsController(window,view).isAppearanceLightStatusBars = darkTheme
        }
    }
}

private fun getColorSchema(darkTheme: Boolean , dynamicColor: Boolean=false ,context:Context):ColorScheme{
    return when{
        dynamicColor  -> {
            if(darkTheme){
                dynamicDarkColorScheme(context)
            }else{
                dynamicLightColorScheme(context)
            }
        }
        darkTheme -> DarkColorSchema
        else -> LighColorSchema
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true, showSystemUi = true,uiMode = Configuration.UI_MODE_NIGHT_YES)
fun MaterialThemeComposeUIPreview(){
    MaterialThemeComposeUI{
        Text(text = "Test Theme")
    }
}