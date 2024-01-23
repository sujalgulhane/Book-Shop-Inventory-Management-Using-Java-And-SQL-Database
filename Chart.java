/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sujal
 */
 import java.sql.*;
import java.io.*;
import org.jfree.ui.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.*;
import org.jfree.data.jdbc.JDBCPieDataset;

public class Chart  extends javax.swing.JFrame {
 public Chart() throws SQLException, ClassNotFoundException{
 	String query = " select pname ,count(*) as issue_count from sales_product group by qty";
		JDBCPieDataset dataset = new JDBCPieDataset(
				"jdbc:mysql://localhost/inventory", "com.mysql.jdbc.Driver",
				"root", "");

		dataset.executeQuery(query);
		JFreeChart chart = ChartFactory.createPieChart("Test", dataset, true,
				true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		ApplicationFrame f = new ApplicationFrame("Chart");
		f.setContentPane(chartPanel);
		f.pack();
		f.setVisible(true);

 };
 
 

 
	public static void main(String[] args) throws Exception {

 

	Chart c = new Chart();
    c.setVisible(true);
   
        }
    public void setVisible(boolean b) {
      System.out.println(b);
    }
}