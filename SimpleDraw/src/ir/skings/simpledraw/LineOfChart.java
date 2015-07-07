package ir.skings.simpledraw;

import java.util.ArrayList;

import android.graphics.PointF;

public class LineOfChart {

	private ArrayList<PointF> points;
	private int lineColor;
	private int lineStrokeWidth;

	public LineOfChart() {
		// TODO Auto-generated constructor stub
		this(0);
	}

	public LineOfChart(int lineColor) {
		this(lineColor, 5);
	}

	public LineOfChart(int lineColor , int lineStrokeWidth) {
		this(lineColor,lineStrokeWidth,new ArrayList<PointF>());
	}

	public LineOfChart(int lineColor, int lineStrokeWidth,
			ArrayList<PointF> points) {
		this.points = points;
		this.lineColor = lineColor;
		this.lineStrokeWidth = lineStrokeWidth;
	}

	public void addPointF(float x, float y) {
		PointF point = new PointF(x, y);
		points.add(point);
	}

	public ArrayList<PointF> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<PointF> points) {
		this.points = points;
	}

	public int getLineColor() {
		return lineColor;
	}

	public void setLineColor(int lineColor) {
		this.lineColor = lineColor;
	}

	public int getLineStrokeWidth() {
		return lineStrokeWidth;
	}

	public void setLineStrokeWidth(int lineStrokeWidth) {
		this.lineStrokeWidth = lineStrokeWidth;
	}
	
	
}
