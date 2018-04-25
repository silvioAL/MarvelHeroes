package teste.teste.marvelheroes;

import android.support.v7.widget.RecyclerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import teste.teste.marvelheroes.model.Heroes;
import teste.teste.marvelheroes.view.HomeActivity;

import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class HomeTest {

    HomeActivity homeActivity;
    RecyclerView rv;

    @Before
    public void setup() {
        homeActivity = Robolectric.buildActivity(HomeActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityNotNull() {
        assert homeActivity != null;

    }

    @Test
    public void canInflateRecyclerView() {
        rv = homeActivity.findViewById(R.id.rv_heroes);
        rv.measure(0, 0);
        rv.layout(0, 0, 100, 1000);

    }

    @Test
    public void canCreateHeroes() {
        Heroes hero1 = Mockito.mock(Heroes.class);

        assertNotNull(hero1);
    }


}
