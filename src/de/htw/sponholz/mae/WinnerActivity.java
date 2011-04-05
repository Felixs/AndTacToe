package de.htw.sponholz.mae;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WinnerActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.winner);
		int winnerId = this.getIntent().getIntExtra("winnerId", 0);
		TextView tv = (TextView) findViewById(R.id.textView1);
		if (winnerId != 0)
			tv.setText("Spieler " + winnerId + " hat das Spiel gewonnen. Glückwunsch!");
		else
			tv.setText("Da ist wohl was schief gelaufen, es hat niemand gewonnen.");
		
	}
}
