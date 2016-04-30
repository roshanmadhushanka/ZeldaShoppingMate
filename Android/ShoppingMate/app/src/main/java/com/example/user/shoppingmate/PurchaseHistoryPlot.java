package com.example.user.shoppingmate;

import android.graphics.DashPathEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidplot.util.PixelUtils;
import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.util.Arrays;

public class PurchaseHistoryPlot extends AppCompatActivity {
    private XYPlot plot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history_plot);

        plot = (XYPlot) findViewById(R.id.plot);

        // create a couple arrays of y-values to plot:
        Number[] series1Numbers = {1, 4, 2, 8, 4, 16, 8, 32, 16, 64};
        Number[] series2Numbers = {5, 2, 10, 5, 20, 10, 40, 20, 80, 40};
        Number[] series3Numbers = {10, 12, 8, 15, 27, 30, 48, 20, 50, 25};
        Number[] series4Numbers = {2, 23, 11, 5, 70, 52, 45, 22, 45, 40};
        Number[] series5Numbers = {45, 25, 10, 35, 20, 18, 45, 58, 45, 40};



        // turn the above arrays into XYSeries':
        // (Y_VALS_ONLY means use the element index as the x value)
        XYSeries series1 = new SimpleXYSeries(Arrays.asList(series1Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Electronic");

        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Food");

        XYSeries series3 = new SimpleXYSeries(Arrays.asList(series3Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Education");

        XYSeries series4 = new SimpleXYSeries(Arrays.asList(series4Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Clothe");

        XYSeries series5 = new SimpleXYSeries(Arrays.asList(series5Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Other");

        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels);

        LineAndPointFormatter series2Format = new LineAndPointFormatter();
        series2Format.setPointLabelFormatter(new PointLabelFormatter());
        series2Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels_2);

        LineAndPointFormatter series3Format = new LineAndPointFormatter();
        series3Format.setPointLabelFormatter(new PointLabelFormatter());
        series3Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels_3);

        LineAndPointFormatter series4Format = new LineAndPointFormatter();
        series4Format.setPointLabelFormatter(new PointLabelFormatter());
        series4Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels_4);

        LineAndPointFormatter series5Format = new LineAndPointFormatter();
        series5Format.setPointLabelFormatter(new PointLabelFormatter());
        series5Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels_5);

        //Dash effect removed by me
        // add an "dash" effect to the series2 line:
        /*
        series2Format.getLinePaint().setPathEffect(
                new DashPathEffect(new float[] {

                        // always use DP when specifying pixel sizes, to keep things consistent across devices:
                        PixelUtils.dpToPix(20),
                        PixelUtils.dpToPix(15)}, 0));
        */

        // just for fun, add some smoothing to the lines:
        // see: http://androidplot.com/smooth-curves-and-androidplot/
        series1Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        series2Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        series3Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        series4Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        series5Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));


        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);
        plot.addSeries(series2, series2Format);
        plot.addSeries(series3, series3Format);
        plot.addSeries(series4, series4Format);
        plot.addSeries(series5, series5Format);

        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);

        // rotate domain labels 45 degrees to make them more compact horizontally:
        plot.getGraphWidget().setDomainLabelOrientation(-45);

    }
}
