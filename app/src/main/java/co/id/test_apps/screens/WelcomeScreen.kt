package co.id.test_apps.screens

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.test_apps.R
import co.id.test_apps.views.HomeActivity

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen() {

    val context = LocalContext.current

    val pageState : PagerState = remember { PagerState() }
    val isDragged = pageState.interactionSource.collectIsFocusedAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)) {
            Column {
                HorizontalPager(
                    pageCount = 3, state = pageState) {page ->
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cup_coffee), 
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary)
                        Text(text = stringResource(R.string.title_slider),
                            fontSize = 24.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                        Text(text = stringResource(R.string.description_slider),  textAlign = TextAlign.Center)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cup_coffee),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary)

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.title_slider),
                            fontSize = 24.sp, fontWeight = FontWeight.Bold,textAlign = TextAlign.Center
                        )
                        Text(text = stringResource(id = R.string.description_slider), textAlign = TextAlign.Center)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cup_coffee),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary)
                        Text(text = stringResource(id = R.string.title_slider),
                            fontSize = 24.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                        Text(text = stringResource(id = R.string.description_slider), textAlign = TextAlign.Center)
                    }
                }

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                    contentAlignment = Alignment.Center) {
                    LazyRow(modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(3) {
                            Box(modifier = Modifier
                                .size(width = if (pageState.currentPage == it) 15.dp else 8.dp, height = 8.dp)
                                .clip(shape = RoundedCornerShape(size = 10.dp))
                                .background(
                                    color = if (pageState.currentPage == it) {
                                        MaterialTheme.colorScheme.primary
                                    } else {
                                        MaterialTheme.colorScheme.secondary
                                    }
                                ))
                        }
                    }
                }
            }
            Box(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    onClick = {
                    val intent = Intent(context, HomeActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Text(text = stringResource(R.string.get_started))
                }
            }
        }
    }
}


@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}