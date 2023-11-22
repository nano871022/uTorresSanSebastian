package co.japl.android.torressansebastian.ui.view.schedule

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.com.jap.ui.theme.MaterialThemeComposeUI
import co.com.japl.schedule.ui.schedule.ScheduleBoard

@Composable
fun ScheduleView(){
 ScheduleBoard()
}
@Composable
@Preview
fun Preview(){
    MaterialThemeComposeUI {
        ScheduleView()
    }
}