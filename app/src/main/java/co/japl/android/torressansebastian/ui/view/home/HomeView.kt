package co.japl.android.torressansebastian.ui.view.home

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.jap.ui.common.ImageView
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R
import co.urtss.core.model.Carousel
import coil.compose.AsyncImage
import coil.memory.MemoryCache
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

val DELAY_CAROUSEL_MILLSEG = 10_000L


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeView(model:HomeModel = HomeState()) {
    val load = remember {model.viewModel.loader}
    val progress = remember {model.viewModel.progress}
    val list = remember {model.viewModel.list}

    LaunchedEffect(key1 = Dispatchers.IO) {
        model.viewModel.main()
    }

    if(load.value) {
        LinearProgressIndicator(progress.value, modifier = Modifier.fillMaxWidth())
    }else {
        if(list.isEmpty()){
            Column {
                Text(text = "Carousel was not able to load images")
                Image(
                    painter = painterResource(id = R.drawable.torres_san_sebastian2),
                    contentDescription = "WhatsApp",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }else {
            MoveCarousel(model = model)
            Carousel(model = model)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MoveCarousel(model: HomeModel){
    val isDragger by model.state.interactionSource.collectIsDraggedAsState()
    if(isDragger.not()) {
        with(model.state) {
            var currentPage by remember { mutableIntStateOf(0) }
            LaunchedEffect(key1 = currentPage) {
                delay(DELAY_CAROUSEL_MILLSEG)
                val nextPage = if (pageCount > 0) currentPage + 1 % pageCount else 0
                animateScrollToPage(nextPage)
                currentPage = nextPage
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun Carousel(model: HomeModel){
    val list = remember {model.viewModel.list}
    Column {
        co.com.japl.ui.components.Carousel(list.size,modifier=Modifier.fillMaxHeight(0.7f)) {
            val image = list[it]
            if (image.url.isNotBlank()) {
                CarouselItemWeb(model = model, it = image)
            } else {
                CardImage(model = model, it = image)
            }
        }

        AllImage(model = model)

        ImageView(
            name = model.openStateName.value,
            imageSrcInt = model.openStateSrc.value,
            openDialog = model.openState as MutableState<Boolean>
        )
        ImageView(
            name = model.openStateName.value,
            imageUrl = model.openStateUrl.value,
            openDialog = model.openState as MutableState<Boolean>
        )
    }
}

@Composable
private fun AllImage(model: HomeModel){
    val list = remember {model.viewModel.list}
    var placeholder: MemoryCache.Key? = null
    LazyVerticalGrid(columns = GridCells.Fixed(6)) {
        items(list.size) {
            if (list[it].url.isBlank()) {
                Image(
                    painter = painterResource(id = list[it].image)
                    , contentDescription = ""
                    , modifier = Modifier.clickable {
                        model.openStateName.value = "Image ${list[it].name}"
                        model.openStateSrc.value = list[it].image
                        model.openStateUrl.value = ""
                        model.openState.value = true
                    }
                )
            }else{
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(list[it].url).crossfade(true).build(),
                    error = ColorPainter(Color.Red),
                    onSuccess = { placeholder = it.result.memoryCacheKey },
                    contentDescription = list[it].name
                    , modifier = Modifier.fillMaxWidth().clickable {
                        model.openStateName.value = "Image ${list[it].name}"
                        model.openStateSrc.value = -1
                        model.openStateUrl.value = list[it].url
                        model.openState.value = true
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CardImage(model: HomeModel,it:Carousel){
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        onClick={
            model.openStateName.value = "Image ${it.name}"
            model.openStateSrc.value = it.image
            model.openStateUrl.value = ""
            model.openState.value = true
        }) {
        Image(painter = painterResource(id = it.image)
            , contentDescription = "${it.name}"
            , modifier = Modifier.fillMaxWidth())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselItemWeb(model: HomeModel,it:Carousel){
    var placeholder: MemoryCache.Key? = null
    Card(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
        , onClick = {
            model.openStateName.value = "Image ${it.name}"
            model.openStateUrl.value = it.url
            model.openStateSrc.value = -1
            model.openState.value = true
        }   ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(it.url).crossfade(true).build(),
            error = ColorPainter(Color.Red),
            onSuccess = { placeholder = it.result.memoryCacheKey },
            contentDescription = it.name
            , modifier = Modifier.fillMaxWidth()
        )
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
@Preview(showSystemUi = true, showBackground = true, apiLevel = 31, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewHomeView(){
    MaterialThemeComposeUI {
        HomeView()
    }
}