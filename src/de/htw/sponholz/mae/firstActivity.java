package de.htw.sponholz.mae;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class firstActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		View v;
		v = this.findViewById(R.id.button1);
		v.setOnClickListener(this);
		v = this.findViewById(R.id.button2);
		v.setOnClickListener(this);
		v = this.findViewById(R.id.button3);
		v.setOnClickListener(this);
		v = this.findViewById(R.id.button4);
		v.setOnClickListener(this);
		v = this.findViewById(R.id.button5);
		v.setOnClickListener(this);
		v = this.findViewById(R.id.button6);
		v.setOnClickListener(this);
		v = this.findViewById(R.id.button7);
		v.setOnClickListener(this);
		v = this.findViewById(R.id.button8);
		v.setOnClickListener(this);
		v = this.findViewById(R.id.button9);
		v.setOnClickListener(this);   
    }

    private int activePlayer = 1;
    private int numberRound = 1;
    
	@Override
	public void onClick(View v) {
		TextView showActivePlayer = (TextView) findViewById(R.id.textView10);
		Boolean switchToNextPlayer = false;
		Button pressedButton = (Button) v;
		if (pressedButton.getText().length() == 0) {
			pressedButton.setText(activePlayer == 1 ? "X" : "O");
			if (activePlayWon()) {
				Log.d("intent", "Launching secondActivity");
				Intent nextActivity = new Intent(this, WinnerActivity.class);
				nextActivity.putExtra("winnerId", activePlayer);
				startActivity(nextActivity);
			}
			switchToNextPlayer = true;
		} else {
			Toast.makeText(getApplicationContext(), "Feld ist belegt!", Toast.LENGTH_LONG).show();
		}
		
		if (switchToNextPlayer) {
			activePlayer = (activePlayer == 1 ? 2 : 1);
			numberRound++;
			if (numberRound < 10)
				showActivePlayer.setText("Spieler " + activePlayer + " am Zug! (Runde " + numberRound + ")");
			else
				showActivePlayer.setText("Das Spieleld ist voll, es gibt keinen Sieger");
		}
	}
	
	private Boolean activePlayWon() {
		int activeField[][] = new int[3][3];
		int test = 10;
		for (int i = 0; i < 3; i++) 
			for (int j = 0; j < 3; j++)
				activeField[i][j] = test++;
		
		Button button = (Button) findViewById(R.id.button1);
		if (button.getText().length() != 0) {
			activeField[0][0] = (button.getText() == "X" ? 1 : 2);	
		}
		button = (Button) findViewById(R.id.button2);
		if (button.getText().length() != 0) {
			activeField[1][0] = (button.getText() == "X" ? 1 : 2);	
		}
		button = (Button) findViewById(R.id.button3);
		if (button.getText().length() != 0) {
			activeField[2][0] = (button.getText() == "X" ? 1 : 2);	
		}
		button = (Button) findViewById(R.id.button4);
		if (button.getText().length() != 0) {
			activeField[0][1] = (button.getText() == "X" ? 1 : 2);	
		}
		button = (Button) findViewById(R.id.button5);
		if (button.getText().length() != 0) {
			activeField[1][1] = (button.getText() == "X" ? 1 : 2);	
		}
		button = (Button) findViewById(R.id.button6);
		if (button.getText().length() != 0) {
			activeField[2][1] = (button.getText() == "X" ? 1 : 2);	
		}
		button = (Button) findViewById(R.id.button7);
		if (button.getText().length() != 0) {
			activeField[0][2] = (button.getText() == "X" ? 1 : 2);	
		}
		button = (Button) findViewById(R.id.button8);
		if (button.getText().length() != 0) {
			activeField[1][2] = (button.getText() == "X" ? 1 : 2);	
		}
		button = (Button) findViewById(R.id.button9);
		if (button.getText().length() != 0) {
			activeField[2][2] = (button.getText() == "X" ? 1 : 2);	
		}
		Boolean playerHasWon = false;

		for (int i = 0; i < 3 && !playerHasWon; i++)
			if (activeField[i][0] == activeField[i][1] && activeField[i][1] == activeField[i][2])
				playerHasWon = true;

		for (int i = 0; i < 3 && !playerHasWon; i++)
			if (activeField[0][i] == activeField[1][i] && activeField[1][i] == activeField[2][i])
				playerHasWon = true;

		if (!playerHasWon && activeField[0][0] == activeField[1][1] && activeField[1][1] == activeField[2][2])
			playerHasWon = true;

		if (!playerHasWon && activeField[0][2] == activeField[1][1] && activeField[1][1] == activeField[2][0])
			playerHasWon = true;

		return playerHasWon;
	}
	
	public void resetGame(View v) {
		activePlayer = 1;
	    numberRound = 1;
	    ((Button) findViewById(R.id.button1)).setText("");
	    ((Button) findViewById(R.id.button2)).setText("");
	    ((Button) findViewById(R.id.button3)).setText("");
	    ((Button) findViewById(R.id.button4)).setText("");
	    ((Button) findViewById(R.id.button5)).setText("");
	    ((Button) findViewById(R.id.button6)).setText("");
	    ((Button) findViewById(R.id.button7)).setText("");
	    ((Button) findViewById(R.id.button8)).setText("");
	    ((Button) findViewById(R.id.button9)).setText("");
	    ((TextView) findViewById(R.id.textView10)).setText("Spieler " + activePlayer + " am Zug! (Runde " + numberRound + ")");
	    
	}
}