package co.japl.android.torressansebastian.ui.view.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.com.jap.ui.theme.MaterialThemeComposeUI
import co.com.japl.schedule.ui.schedule.ScheduleBoard
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun ScheduleView(){
    Title(title = stringResource(id = R.string.attention_schedule)
        , icon = painterResource(id = R.drawable.ic_baseline_calendar_month_24)) {
        ScheduleBoard()
        Column(modifier = Modifier.fillMaxWidth()
        , horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(id = R.string.schedule_time),modifier = Modifier.padding(top=10.dp))
        }

        Text(text = stringResource(id = R.string.note1_admin_attention)
        , fontSize = 12.sp
        , modifier = Modifier.padding(top=10.dp))

        Text(text = stringResource(id = R.string.note2_assistant_attention)
            , fontSize = 12.sp
            , modifier = Modifier.padding(top=10.dp))

    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview(){
    MaterialThemeComposeUI {
        ScheduleView()
    }
}