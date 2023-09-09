package com.example.afirmationsapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.afirmationsapplication.ui.theme.AfirmationsApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AfirmationsApplicationTheme {
                AffirmationsApp()
            }
        }
    }
}

@Composable
fun AffirmationsApp() {
    AffirmationList(affirmationList = Datasource().loadAffirmations())
    //gọi hàm affi list
    //nhận tham số là phương thức loadAffirmations() bên class Datasource
    //Sau đó sử dụng affi list để hiện thi các danh mục bên trong datasource
}

//Hàm Compose tạo affi card
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    //nhận 2 tham số là affirmation từ data class Affirmation và Modifier
    Card(modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
        //setup giao diện của 1 affi card
    }
}

//Hàm Compose tạo affi list
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    //Nhận tham số affirmationList là một list chứa các affirmation (Datasource)
    LazyColumn(modifier = modifier) {
        //cho phép hiện thị theo chiều dọc và có thể kéo xuống
        items(affirmationList) {
            AffirmationCard(
                affirmation = it,
                //đối tượng truyền vào là 1 affirmation
                modifier = Modifier.padding(10.dp)
                //mỗi card cách nhau 10dp
            )
        }
    }
}


