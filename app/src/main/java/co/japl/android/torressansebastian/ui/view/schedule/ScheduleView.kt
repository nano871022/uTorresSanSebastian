package co.japl.android.torressansebastian.ui.view.schedule

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.com.japl.schedule.ui.schedule.ScheduleBoard
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun ScheduleView(){
    val context = LocalContext.current
    val tabIndex = remember { mutableIntStateOf(0) }
    Title(title = stringResource(id = R.string.attention_schedule)
        , iconPainter = painterResource(id = R.drawable.ic_baseline_calendar_month_24)) {
        TabRow(
            selectedTabIndex = 0
        ) {
            Tab(
                selected = true,
                onClick = { tabIndex.intValue = 0 }

            ) {
                Text(text = stringResource(id = R.string.schedule))
            }
            Tab (
                selected = false,
                onClick = { tabIndex.intValue = 1 }
            ) {
                Text(text = stringResource(id = R.string.info_additional))
            }
        }
        when(tabIndex.intValue){
            0 -> ScheduleBoard()
            1 -> Info()
        }
    }
}

@Composable
private fun Info(){
    Text(
        text = stringResource(id = R.string.schedule_time),
        modifier = Modifier.padding(top = 10.dp)
    )

    Text(
        text = stringResource(id = R.string.note1_admin_attention),
        fontSize = 12.sp,
        modifier = Modifier.padding(top = 10.dp)
    )

    Text(
        text = stringResource(id = R.string.note2_assistant_attention),
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview(){
    MaterialThemeComposeUI {
        ScheduleView()
    }
}