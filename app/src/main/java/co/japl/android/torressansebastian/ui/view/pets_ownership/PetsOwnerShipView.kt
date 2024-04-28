package co.japl.android.torressansebastian.ui.view.pets_ownership

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.SimpleHtml
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun PetsOwnerShip(){
    val tabIndex= remember { mutableIntStateOf(0) }
    val list = arrayListOf("Normas Unidad Residencial","Normas Código Nacional")
    Title(title = stringResource(id = R.string.pet_ownership)
        , icon = painterResource(id = R.drawable.ic_baseline_pets_24)) {
        TabRow(selectedTabIndex = tabIndex.intValue
            , backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.primary
            ,modifier=Modifier.padding(2.dp)) {
            list.forEachIndexed { index, title->
                Tab(
                    onClick = {
                        tabIndex.intValue = index
                    },
                    selected = false,
                    modifier=Modifier.padding(start=7.dp,end=7.dp,top=10.dp,bottom=10.dp),
                ) {
                    Text(text = title
                        , textAlign = TextAlign.Center)
                }

            }
        }
        when(tabIndex.intValue) {
            0->   SimpleHtml(stringResource(id = R.string.pets_UR_manual))
            1-> SimpleHtml(text = stringResource(id = R.string.law_pet_ownership))
        }
    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun Preview(){
    MaterialThemeComposeUI {
        PetsOwnerShip()
    }
}