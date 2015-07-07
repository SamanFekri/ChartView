package ir.skings.simpledraw;

import java.util.ArrayList;

import android.R.bool;
import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.RelativeLayout;

public class GraphChartView extends RelativeLayout {

	private Paint mPaint;
	private ArrayList<LineOfChart> curveds;
	private Pair<Integer, Integer> rangex, rangey;
	private boolean showGrid;

	public GraphChartView(Context context) {
		this(context, null, 0);
	}

	public GraphChartView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GraphChartView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		this.setWillNotDraw(false);
		setBackgroundColor(Color.TRANSPARENT);
		mPaint = new Paint();
		mPaint.setStrokeCap(Cap.ROUND);
		curveds = new ArrayList<LineOfChart>();
		showGrid = true;
		rangex = new Pair<Integer, Integer>(-10, 10);
		rangey = new Pair<Integer, Integer>(-100, 100);
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		mPaint.setColor(Color.GRAY);
		mPaint.setStrokeWidth(1);

		float deltaX = (rangex.second - rangex.first) / 10;
		float deltaY = (rangey.second - rangey.first) / 8;

		if (showGrid) {
			for (int i = 0; i <= 10; i++) {
				canvas.drawLine((getWidth() / 10 * i), 0,
						(getWidth() / 10 * i), getHeight(), mPaint);
			}

			for (int i = 0; i <= 8; i++) {
				canvas.drawLine(0, (getHeight() / 8 * i), getWidth(),
						(getHeight() / 8 * i), mPaint);
			}
		}

		for (int i = 1; i < 10; i++) {
			canvas.drawText(rangex.first + deltaX * i + "",
					(getWidth() / 10 * i) - 5, getHeight(), mPaint);
		}
		for (int i = 0; i < 8; i++) {
			canvas.drawText(rangey.second - deltaY * i + "", 0, getHeight() / 8
					* i, mPaint);
		}
		
		for (int i = 0; i < curveds.size(); i++) {
			LineOfChart lineOfChart = curveds.get(i);
			ArrayList<PointF> points = lineOfChart.getPoints();

			mPaint.setColor(lineOfChart.getLineColor());
			mPaint.setStrokeWidth(lineOfChart.getLineStrokeWidth());
			for (int j = 0; j < points.size() - 1; j++) {

				canvas.drawLine(getWidth() / 2 + points.get(j).x * getWidth()/ (rangex.second - rangex.first),
						getHeight() / 2 - points.get(j).y * getHeight() / (rangey.second - rangey.first),
						getWidth() / 2 + points.get(j + 1).x * getWidth()/ (rangex.second - rangex.first),
						getHeight() / 2 - points.get(j + 1).y * getHeight() / (rangey.second - rangey.first), mPaint);
			}
		}


	}

	public void addCurved(LineOfChart lineOfChart) {
		curveds.add(lineOfChart);
	}

	public Pair<Integer, Integer> getRangex() {
		return rangex;
	}

	public void setRangex(Pair<Integer, Integer> rangex) {
		this.rangex = rangex;
	}

	public Pair<Integer, Integer> getRangey() {
		return rangey;
	}

	public void setRangey(Pair<Integer, Integer> rangey) {
		this.rangey = rangey;
	}

	public boolean isShowGrid() {
		return showGrid;
	}

	public void setShowGrid(boolean showGrid) {
		this.showGrid = showGrid;
	}

}
