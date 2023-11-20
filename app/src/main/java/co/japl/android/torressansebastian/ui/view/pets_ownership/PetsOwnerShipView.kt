package co.japl.android.torressansebastian.ui.view.pets_ownership

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.SimpleHtml
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun PetsOwnerShip(){
    val tabIndex= remember { mutableIntStateOf(1) }
    val list = arrayListOf("Normas Unidad Residencial","Normas Código Nacional")
    Title(title = stringResource(id = R.string.pet_ownership), icon = painterResource(id = R.drawable.ic_baseline_pets_24)) {
        TabRow(selectedTabIndex = tabIndex.intValue) {
            list.forEachIndexed { index, title->
                Tab(
                    onClick = {
                        tabIndex.intValue = index
                    },
                    selected = false
                ) {
                    Text(text = title)
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
@Preview(showSystemUi = true, showBackground = true)
fun Preview(){
    PetsOwnerShip()
}