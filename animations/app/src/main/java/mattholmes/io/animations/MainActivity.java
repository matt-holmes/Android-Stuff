package mattholmes.io.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView homer1 = (ImageView) findViewById(R.id.homer1);
        homer1.setTranslationX(-2000f);
        homer1.setScaleX(0.5f);
        homer1.setScaleY(0.5f);
        homer1.animate().translationXBy(2000f).setDuration(2000);
        homer1.animate().rotation(360f);
    }

    public void fade(View view) {
        ImageView homer1 = (ImageView) findViewById(R.id.homer1);
        homer1.animate().scaleX(1f).setDuration(2000);
        homer1.animate().scaleY(1f).setDuration(2000);
    }
}
