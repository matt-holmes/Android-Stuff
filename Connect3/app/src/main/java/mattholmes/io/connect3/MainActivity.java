package mattholmes.io.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] == 2) {
            counter.setTranslationY(-1000f);
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(3600).setDuration(3000).withEndAction(new Runnable() {
                @Override
                public void run() {
                    if(isThereAWinner()) {
                        String winner = "Yellow";
                        if(activePlayer != 1) {
                            winner = "Red";
                        }
                        Toast.makeText(MainActivity.this, winner + " is the winner!", Toast.LENGTH_LONG).show();
                        setContentView(R.layout.activity_main);
                        resetGameState();

                    } else if (isItADraw()) {
                        Toast.makeText(MainActivity.this, "Draw!", Toast.LENGTH_LONG).show();
                        setContentView(R.layout.activity_main);
                        resetGameState();
                    }
                }
            });
        }
    }

    private boolean isThereAWinner() {
        boolean isThereAWinner = false;

        if(gameState[0] == gameState[1] && gameState[1] == gameState[2] && gameState[0] != 2) {
            isThereAWinner = true;
        } else if (gameState[3] == gameState[4] && gameState[4] == gameState[5] && gameState[3] != 2) {
            isThereAWinner = true;
        } else if (gameState[6] == gameState[7] && gameState[7] == gameState[8] && gameState[6] != 2) {
            isThereAWinner = true;
        } else if (gameState[0] == gameState[3] && gameState[3] == gameState[6] && gameState[0] != 2) {
            isThereAWinner = true;
        } else if (gameState[1] == gameState[4] && gameState[4] == gameState[7] && gameState[1] != 2) {
            isThereAWinner = true;
        } else if (gameState[2] == gameState[5] && gameState[5] == gameState[8] && gameState[2] != 2) {
            isThereAWinner = true;
        } else if (gameState[0] == gameState[4] && gameState[4] == gameState[8] && gameState[0] != 2) {
            isThereAWinner = true;
        } else if (gameState[2] == gameState[4] && gameState[4] == gameState[6] && gameState[2] != 2) {
            isThereAWinner = true;
        }
        return isThereAWinner;
    }

    private boolean isItADraw() {
        boolean isItADraw = true;
        for (int i: gameState) {
            if(i == 2) {
                isItADraw = false;
                break;
            }
        }
        return isItADraw;
    }

    private void resetGameState() {
        for( int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
    }
}
