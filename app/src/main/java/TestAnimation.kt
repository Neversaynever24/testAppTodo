import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ScrollInfoLazyColumn() {
    val listState = rememberLazyListState()
    var firstVisibleIndex by remember { mutableStateOf(0) }
    var firstVisibleOffset by remember { mutableStateOf(0) }

    // Слушатель прокрутки
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .collect { (index, offset) ->
                firstVisibleIndex = index
                firstVisibleOffset = offset
            }
    }

    LazyColumn(state = listState, modifier = Modifier) {
        items(100) { index ->
            Text(text = "Item $index")
        }
    }

    // Отображаем индекс и смещение
    Text(text = "First visible item index: $firstVisibleIndex")
    Text(text = "First visible item offset: $firstVisibleOffset px")
}