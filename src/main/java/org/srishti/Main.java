package org.srishti;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.srishti.service.BarChartService;
import org.srishti.service.PieChartService;

import javax.swing.*;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        generateBarChart();
        generatePieChart();
    }

    private static void generateBarChart() throws IOException {
        BarChartService barChartService =new BarChartService();

        DefaultCategoryDataset dataset = barChartService.getDataSet();


        JFreeChart chart = ChartFactory.createBarChart(
                "No of new joiners",
                "Year",
                "New joiner count",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        generatepanel(chart);
    }

    private static void generatePieChart() throws IOException {
        PieChartService pieChartService = new PieChartService();

        DefaultPieDataset<String> dataSet = pieChartService.getDataSet();
        JFreeChart chart = ChartFactory.createPieChart(
                "No of New joiner",
                dataSet,
                true,    // include legend
                true,    // generate tooltips
                false);  // no URLs

        generatepanel(chart);
    }


    private  static void generatepanel(JFreeChart chart ){
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setContentPane(chartPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}