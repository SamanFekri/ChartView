package ir.skings.simpledraw;

import android.os.Bundle;
import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GraphChartView graphChart = (GraphChartView) findViewById(R.id.graphChart1);
		LineOfChart lineOfChart = new LineOfChart(Color.GREEN, 5);
		lineOfChart.addPointF(0, 0);
		lineOfChart.addPointF(0, 60);
		lineOfChart.addPointF(60, 60);
		graphChart.addCurved(lineOfChart);

		lineOfChart = new LineOfChart(Color.GRAY, 3);
		lineOfChart.addPointF(40, graphChart.getHeight() - 40);
		lineOfChart.addPointF(50, graphChart.getHeight() - 50);
		lineOfChart.addPointF(90, graphChart.getHeight() - 90);

		graphChart.addCurved(lineOfChart);
		
		graphChart.setShowGrid(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
