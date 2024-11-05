package com.example.stomatoassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.stomatoassignment.common.components.TopAppBar
import com.example.stomatoassignment.common.ui.theme.StomatoAssignmentTheme
import com.example.stomatoassignment.common.utils.customRememberSavable
import com.example.stomatoassignment.gold.presentation.GoldScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val tabRowElements = customRememberSavable {
                listOf("Gold", "Mar UPI", "Nek", "Loan")
            }
            val pagerState = rememberPagerState(initialPage = 0, pageCount = {
                tabRowElements.size
            })
            val coroutineScope = rememberCoroutineScope()
            StomatoAssignmentTheme {
                Surface {
                    Scaffold(modifier = Modifier
                        .windowInsetsPadding(WindowInsets.systemBars)
                        .fillMaxSize(), topBar = {
                        TopAppBar()
                    }) { innerPadding ->
                        Column {
                            ScrollableTabRow(
                                modifier = Modifier.padding(innerPadding),
                                selectedTabIndex = pagerState.currentPage
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
                                        Box(modifier = Modifier.fillMaxWidth())
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}