import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.R
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme


@Composable
fun HeroItem(
    modifier: Modifier = Modifier,
    hero:Hero
) {

    Card(
      //  modifier=modifier.clip(MaterialTheme.shapes.medium).padding(8.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)

    ) {
        Row(  modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)
         ){
            //without weight check to practice
            Column(
               modifier.weight(1f)
            ){
                Text(
                    stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
         //   Spacer(modifier.weight(1f))
            Spacer(modifier.width(16.dp))
            Box(modifier.size(72.dp)){
                Image(
                    painter = painterResource(hero.imageRes),
                    "",
                    modifier.clip(
                        MaterialTheme.shapes.small
                    ),
                    contentScale = ContentScale.Fit
                )
            }

        }
    }

}

@Composable
fun HeroesList(
    modifier: Modifier = Modifier,
    herores:List<Hero>
) {
    LazyColumn(
       // modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(herores){
            hero -> HeroItem(hero=hero)

        }
    }
    
}


@Preview
@Composable
fun HeroPreview() {
    SuperheroesTheme{
        HeroItem(
            hero =
            Hero(
                nameRes = R.string.hero1,
                descriptionRes = R.string.description1,
                imageRes = R.drawable.android_superhero1
            )
        )
    }

}
@Preview
@Composable
fun HeroPreviewList() {
    SuperheroesTheme{

        HeroesList(
            herores = HeroesRepository.heroes
        )
    }

}
