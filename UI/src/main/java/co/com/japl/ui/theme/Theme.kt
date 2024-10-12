package co.com.japl.ui.theme

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
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
    surfaceContainerLow = color_theme_light_surface_container_low,
    surfaceContainerHigh = color_theme_light_surface_container_highest,
    surfaceContainer = color_theme_light_surface_container,
    onSurface = color_theme_light_on_surface,
    surfaceVariant = color_theme_light_surface_variant,
    onSurfaceVariant = color_theme_light_on_surface_variant,
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
    surfaceContainer = color_theme_dark_surface_container,
    surfaceContainerHigh = color_theme_dark_surface_container_highest,
    error = color_theme_dark_error,
    onError = color_theme_dark_on_error,
    primaryContainer = color_theme_dark_primary_container,
    onPrimaryContainer = color_theme_dark_on_primary_container,
    secondaryContainer = color_theme_dark_secondary_container,
    onSecondaryContainer = color_theme_dark_on_secondary_container,
    tertiaryContainer = color_theme_dark_tertiary_container,
    onTertiaryContainer = color_theme_dark_on_tertiary_container,
    inversePrimary = color_theme_dark_primary_inverse

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

@RequiresApi(Build.VERSION_CODES.S)
private fun getColorSchema(darkTheme: Boolean, dynamicColor: Boolean=false, context:Context):ColorScheme{
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
@Preview( showBackground = true,  showSystemUi = true,uiMode = Configuration.UI_MODE_NIGHT_YES)
fun materialThemeComposeUIPreview(){
    val back = isSystemInDarkTheme()
    
    MaterialThemeComposeUI{
        val color = MaterialTheme.colorScheme.background
        Text(text = "Test Theme "+back+" "+color)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview( showSystemUi = true,uiMode = Configuration.UI_MODE_NIGHT_NO)
fun materialThemeComposeUIPreviewLight(){
    MaterialThemeComposeUI{
        Text(text = "Test Theme")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview( showSystemUi = true,uiMode = Configuration.UI_MODE_NIGHT_NO)
fun materialThemeComposeUIPreviewRowLight(){
    MaterialThemeComposeUI{
        Column (modifier = Modifier.fillMaxWidth()) {
            Row (modifier = Modifier.fillMaxWidth()) {
                Text(text = "Test Theme")
            }
        }
    }
}

