/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;
import MODEL.*;
import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Kenny-fixe
 */
public class Graphes extends ApplicationFrame{
    private static double td1=0,td2=0,td3=0,td4=0,td5=0,td6=0;
    Admin admin;
    
    public Graphes(String title,Admin adm) {
        super(title);
        admin=adm;
        this.settd();
        setContentPane(createDemoPanel());
    }
    
    /**
         * set les effectif pour chaque td
    */
    private void settd(){
        setDoneesGraphe sdg=new setDoneesGraphe(admin);
        td1=sdg.getTD(1);
        td2=sdg.getTD(2);
        td3=sdg.getTD(3);
        td4=sdg.getTD(4);
        td5=sdg.getTD(5);
        td6=sdg.getTD(6);
    }
    
    /**
         * crée le dataset
    */
    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        //decommenter si acces dans la bdd
        if(td1!=0)
            dataset.setValue("td1", new Double(td1));
        if(td2!=0)
            dataset.setValue("td2", new Double(td2));
        if(td3!=0)
            dataset.setValue("td3", new Double(td3));
        if(td4!=0)
            dataset.setValue("td4", new Double(td4));
        if(td5!=0)
            dataset.setValue("td5", new Double(td5));
        if(td6!=0)
            dataset.setValue("td6", new Double(td6));
        //decommenter si valeur arbitraires
        /*dataset.setValue("td1", new Double(10));
        dataset.setValue("td2", new Double(20));
        dataset.setValue("td3", new Double(15));
        dataset.setValue("td4", new Double(11));
        dataset.setValue("td5", new Double(13));
        dataset.setValue("td6", new Double(17));*/
        return dataset;        
    }
    
    /**
         * crée la chart avec les données
         * @return un jfreechart
    */
    private static JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Repartition par TD",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }
    
    /**
     * Creates a panel to print
     * 
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }

}