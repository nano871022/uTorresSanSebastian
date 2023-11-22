package co.japl.android.torressansebastian.ui.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.jap.ui.common.ImageView
import co.com.jap.ui.theme.MaterialThemeComposeUI
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeView(){
    val model = HomeState()

    with(model.state){
        var currentPage by  remember { mutableIntStateOf(0) }
        LaunchedEffect(key1 = currentPage ){
            delay(10000)
            val nextPage = if(pageCount > 0) currentPage + 1 % pageCount else 0
            animateScrollToPage(nextPage)
            currentPage = nextPage
        }
    }

    Column{
Box {
    HorizontalPager(
        state = model.state,
        pageSpacing = 5.dp,
        contentPadding = PaddingValues(horizontal = 5.dp),
    ) {
        model.viewModel.list[it]?.let {

            Card(modifier = Modifier.padding(10.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                onClick={
                    model.openStateName.value = "Image $it"
                    model.openStateSrc.value = it
                    model.openState.value = true
                }) {
                Image(painter = painterResource(id = it), contentDescription = "tt")
            }
        }

    }
    DotImages(pageCount = model.viewModel.list.size, pagerState = model.state, modifier = Modifier.align(
        Alignment.BottomCenter
    ))
    ImageView(name = model.openStateName.value, imageSrcInt = model.openStateSrc.value, openDialog = model.openState as MutableState<Boolean>)
}

}

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DotImages(pageCount:Int, pagerState:PagerState,modifier:Modifier){
  Row (modifier=modifier){
      repeat(pageCount) {
          val color =
              if (pagerState.currentPage == it) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
          Box(
              modifier = modifier
                  .padding(top = 15.dp, start = 3.dp)
                  .clip(CircleShape)
                  .background(color)
                  .padding(3.dp)

          ) {

          }
      }
  }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewHomeView(){
    MaterialThemeComposeUI {
        HomeView()
    }
}