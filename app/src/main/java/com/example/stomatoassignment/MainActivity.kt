package com.example.stomatoassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.stomatoassignment.common.presentation.components.TopAppBar
import com.example.stomatoassignment.common.utils.customRememberSavable
import com.example.stomatoassignment.gold.Sample
import com.example.stomatoassignment.gold.presentation.GoldScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.dark(Color(color = 0xff1D1829).toArgb())
        )
        setContent {
            val tabRowElements = customRememberSavable {
                listOf("Gold", "Mar UPI", "Nek", "Loan")
            }
            val pagerState = rememberPagerState(initialPage = 0, pageCount = {
                tabRowElements.size
            })
            val coroutineScope = rememberCoroutineScope()
            Scaffold(modifier = Modifier
                .background(Color(color = 0xFF36156E))
                .windowInsetsPadding(WindowInsets.statusBars)
                .fillMaxSize(), topBar = {
                TopAppBar()
            }) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    ScrollableTabRow(
                        containerColor = Color(color = 0xFF36156E),
                        selectedTabIndex = pagerState.currentPage,
                        contentColor = Color(color = 0xFFF9F8FA),
                        indicator = { tabPositions ->
                            if (pagerState.currentPage < tabPositions.size) {
                                SecondaryIndicator(
                                    modifier = Modifier
                                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                                        .height(5.dp)
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 15.dp, topEnd = 15.dp
                                            )
                                        ),
                                    color = Color(color = 0xFFA97FE0).copy(0.75f)
                                )
                            }
                        }
                    ) {
                        tabRowElements.forEachIndexed { index, string ->
                            Tab(
                                selected = index == pagerState.currentPage - 1,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                },
                                modifier = Modifier.padding(15.dp)
                            ) {
                                Text(
                                    text = string,
                                    color = if (index == pagerState.currentPage) LocalContentColor.current else LocalContentColor.current.copy(
                                        0.75f
                                    ),
                                    fontWeight = if (index == pagerState.currentPage) FontWeight.SemiBold else FontWeight.Normal
                                )
                            }
                        }
                    }
                    HorizontalPager(state = pagerState) { currentPage ->
                        when (currentPage) {
                            0 -> GoldScreen()
                            else -> {
                                Sample()
                            }
                        }
                    }
                }
            }
        }
    }
}