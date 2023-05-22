package assyment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;



public class HistogramPanel extends JPanel implements ActionListener
{
    private int histogramHeight = 200;
    private int barWidth = 50;
    private int barGap = 10;

    private JPanel barPanel;
    private JPanel labelPanel;

    private List<Bar> bars = new ArrayList<Bar>();
 JPanel ppanel;
    public HistogramPanel()
    {
        setBorder( new EmptyBorder(10, 10, 10, 10) );
        setLayout( new BorderLayout() );

        barPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        ppanel =  new JPanel( new GridLayout(1, 0, barGap, 0) );
        Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
        Border inner = new EmptyBorder(10, 10, 0, 10);
        Border compound = new CompoundBorder(outer, inner);
        barPanel.setBorder( compound );
        ppanel.setBorder( compound );
        labelPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        labelPanel.setBorder( new EmptyBorder(5, 10, 0, 10) );

        add(barPanel, BorderLayout.CENTER);
        add(labelPanel, BorderLayout.PAGE_END);
       
        
    }

    public void addHistogramColumn(String label, int value, Color color)
    {
        Bar bar = new Bar(label, value, color);
        bars.add( bar );
    }

    public void layoutHistogram()
    {
        barPanel.removeAll();
        labelPanel.removeAll();


        int maxValue = 0;

        for (Bar bar: bars)
            maxValue = Math.max(maxValue, bar.getValue());

        for (Bar bar: bars)
        {
            JLabel label = new JLabel(bar.getValue() + "");
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.TOP);
            label.setVerticalAlignment(JLabel.BOTTOM);
            int barHeight = (bar.getValue() * histogramHeight) / maxValue;
            Icon icon = new ColorIcon(bar.getColor(), barWidth, barHeight);
            label.setIcon( icon );
            barPanel.add( label );

            JLabel barLabel = new JLabel( bar.getLabel() );
            barLabel.setHorizontalAlignment(JLabel.CENTER);
            labelPanel.add( barLabel );
        }
    }

    private class Bar
    {
        private String label;
        private int value;
        private Color color;

        public Bar(String label, int value, Color color)
        {
            this.label = label;
            this.value = value;
            this.color = color;
        }

        public String getLabel()
        {
            return label;
        }

        public int getValue()
        {
            return value;
        }

        public Color getColor()
        {
            return color;
        }
    }

    private class ColorIcon implements Icon
    {
        private int shadow = 3;

        private Color color;
        private int width;
        private int height;

        public ColorIcon(Color color, int width, int height)
        {
            this.color = color;
            this.width = width;
            this.height = height;
        }

        public int getIconWidth()
        {
            return width;
        }

        public int getIconHeight()
        {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, width - shadow, height);
            g.setColor(Color.GRAY);
            g.fillRect(x + width - shadow, y + shadow, shadow, height - shadow);
        }
    }
     int fact(int number) {  
        int f = 1;  
        int j = 1;  
        while(j <= number) {  
           f = f * j;  
           j++;  
        }  
        return f;  
     }  
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JTextField input;
    JTextField inputp;
    JTextField inputn;
    JTextField inputp2;
    JTextField inputn3;
    JTextField inputp3;
    JTextField inputn4;
    JTextField inputm;
    JTextField inputr;
    int x[]= new int[6];
    JLabel label;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel done;
   public void birnolli(Double p)
   {
	   p=p*100;
	  x[0]= p.intValue();
	  x[1]=(int)(100-p);
   }
    public void binomial(double p , int n)
    {
    	
    	for(int k=0 ; k<6;k++)
    	{
    		
    		double temp = 100*(fact(n)/(fact(n-k)*fact(k)))*Math.pow(p, k) *Math.pow(1-p, n-k);
    		x[k]=(int)temp;
    	}
    }
    public void geomtric (Double p)
    {
    	for(int k=1 ; k<6;k++)
    	{
    		double temp;
    		temp = 100*p*Math.pow(1-p, k-1);
    		x[k]=(int)temp;
    	}
    }
    public void negatvebinomial (double p , int n)
    {
    	for(int k=0 ; k<6;k++)
    	{
    		double temp;
    		temp = 100*(fact(k-1)/(fact(k-n)*fact(n-1)))*Math.pow(1-p, k-n)*Math.pow(p, n);
    		x[k]=(int)temp;
    	}
    }
    public void hiper(int n , int m , int r)
    {
    	for(int k=0 ; k<6;k++)
    	{
    		int a = (fact(r)/(fact(r-k)*fact(k)));
    		int b = (fact(n-r)/(fact(n-r-m+k)*fact(m-k)));
    		int c = (fact(n)/(fact(n-m)*fact(m)));
    		x[k]=(100*a*b)/c;
    	}
    }
   HistogramPanel panel;
    JFrame frame;
    private  void createAndShowGUI()
    {
    	//birnolli(0.4);
panel = new HistogramPanel();

        
       
         frame = new JFrame("MATH PROJECT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1100,1000));
        frame.setResizable(true);
        
        frame.add( panel );
        panel.setBounds(10, 10, 550, 550);
        button2 = new JButton("Bernoulli Distribution");
        frame.add(button2);
        button2.setBounds(600, 10, 200, 50);
        button2.addActionListener(this);
        input = new JTextField();
        frame.add(input);
        
       input.setBounds(760, 60, 100, 30);
       label = new JLabel("enter the value of p");
       frame.add(label);
       label.setBounds(600, 60, 200, 30);
        button3 = new JButton("Binomial Distribution");
        frame.add(button3);
        button3.setBounds(600, 100, 200, 50);
        button3.addActionListener(this);
        label2 = new JLabel("enter the value of( p , n )");
        		frame.add(label2);
        		label2.setBounds(600, 150, 200, 30);
        		inputp = new JTextField();
        		frame.add(inputp);
        	       inputp.setBounds(760, 150, 100, 30);
        	       inputn = new JTextField();
           		frame.add(inputn);
           	       inputn.setBounds(860, 150, 100, 30);

           	    button4 = new JButton("Geiomtric Distribution");
                frame.add(button4);
                button4.setBounds(600, 200, 200, 50);
                button4.addActionListener(this);
                label3 = new JLabel("enter the value of( p )");
                frame.add(label3);
                label3.setBounds(600, 250, 200, 30);
                inputp2 = new JTextField();
                frame.add(inputp2);
                inputp2.setBounds(760, 250, 100, 30);
                
                button5 = new JButton("Negative Binomial Distribution");
                frame.add(button5);
                button5.setBounds(600, 300, 210, 50);
                button5.addActionListener(this);
                label4 = new JLabel("enter the value of( p , r )");
                frame.add(label4);
                label4.setBounds(600, 350, 200, 30);
                inputp3 = new JTextField();
                frame.add(inputp3);
                inputp3.setBounds(760, 350, 100, 30);
                inputn3 = new JTextField();
                frame.add(inputn3);
                inputn3.setBounds(860, 350, 100, 30);
                
                button6 = new JButton("Hypergeometric Distribution");
                frame.add(button6);
                button6.setBounds(600, 400, 210, 50);
                button6.addActionListener(this);
                label5 = new JLabel("enter the value of( n , m , r )");
                frame.add(label5);
                label5.setBounds(600, 450, 200, 30);
                inputn4 = new JTextField();
                frame.add(inputn4);
                inputn4.setBounds(780, 450, 100, 30);
                inputm = new JTextField();
                frame.add(inputm);
                inputm.setBounds(880, 450, 100, 30);
                inputr = new JTextField();
                frame.add(inputr);
                inputr.setBounds(980, 450, 100, 30);
                done = new JLabel("Wellcome");
                frame.add(done);
                done.setBounds(780, 500, 100, 30);
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
       
        
    }
    int c=0;
    public  void actionPerformed(ActionEvent e) 
	{
		 if(e.getSource()==button2)
		 {

			 panel = new HistogramPanel();
			 frame.add( panel );
		        panel.setBounds(10, 10, 550, 550);
			 Double temp;
			 temp = Double.parseDouble(input.getText());
			 birnolli(temp);
			
			 done.setText("Done Bernoulli"+c++);
			 
		        panel.addHistogramColumn("0", x[0], Color.RED);
		        panel.addHistogramColumn("1", x[1], Color.YELLOW);
		        
		        panel.layoutHistogram();
		 }
		 else if(e.getSource()==button3) 
		 {
			 panel = new HistogramPanel();
			 frame.add( panel );
		        panel.setBounds(10, 10, 550, 550);
			 Double p;
			 p = Double.parseDouble(inputp.getText());
			 int n = Integer.parseInt(inputn.getText());
			 binomial(p, n);
			 done.setText("Done Binomial"+c++);
			  panel.addHistogramColumn("0", x[0], Color.RED);
		        panel.addHistogramColumn("1", x[1], Color.YELLOW);
		        panel.addHistogramColumn("2", x[2], Color.BLUE);
		        panel.addHistogramColumn("3", x[3], Color.ORANGE);
		        panel.addHistogramColumn("4", x[4], Color.MAGENTA);
		        panel.addHistogramColumn("5", x[5], Color.CYAN);
		        panel.layoutHistogram();
		}
		 else  if(e.getSource()==button4)
		 {
			 panel = new HistogramPanel();
			 frame.add( panel );
		        panel.setBounds(10, 10, 550, 550);
			 Double p;
			 p = Double.parseDouble(inputp2.getText());
			 geomtric(p);
			 done.setText("Done Geomtric"+c++);
			  // panel.addHistogramColumn("0", x[0], Color.RED);
		        panel.addHistogramColumn("1", x[1], Color.YELLOW);
		        panel.addHistogramColumn("2", x[2], Color.BLUE);
		        panel.addHistogramColumn("3", x[3], Color.ORANGE);
		        panel.addHistogramColumn("4", x[4], Color.MAGENTA);
		        panel.addHistogramColumn("5", x[5], Color.CYAN);
		        panel.layoutHistogram();
			 
		 }
		 else if(e.getSource()==button5) 
		 {
			 Double p;
			 panel = new HistogramPanel();
			 frame.add( panel );
		        panel.setBounds(10, 10, 550, 550);
			 p = Double.parseDouble(inputp3.getText());
			 int n = Integer.parseInt(inputn3.getText());
			 negatvebinomial(p, n);
			 done.setText("Done Negatvebinomial"+c++);
			  panel.addHistogramColumn("0", x[0], Color.RED);
		        panel.addHistogramColumn("1", x[1], Color.YELLOW);
		        panel.addHistogramColumn("2", x[2], Color.BLUE);
		        panel.addHistogramColumn("3", x[3], Color.ORANGE);
		        panel.addHistogramColumn("4", x[4], Color.MAGENTA);
		        panel.addHistogramColumn("5", x[5], Color.CYAN);
		        panel.layoutHistogram();
		}
		 else if(e.getSource()==button6) 
		 {
			 panel = new HistogramPanel();
			 frame.add( panel );
		        panel.setBounds(10, 10, 550, 550);
			 int n,m,r;
			 done.setText("Done hypergeometric"+c++);
			 n = Integer.parseInt(inputn4.getText());
			 m = Integer.parseInt(inputm.getText());
			 r = Integer.parseInt(inputr.getText());
			 hiper(n, m, r);
			  panel.addHistogramColumn("0", x[0], Color.RED);
		        panel.addHistogramColumn("1", x[1], Color.YELLOW);
		        panel.addHistogramColumn("2", x[2], Color.BLUE);
		        panel.addHistogramColumn("3", x[3], Color.ORANGE);
		        panel.addHistogramColumn("4", x[4], Color.MAGENTA);
		        panel.addHistogramColumn("5", x[5], Color.CYAN);
		        panel.layoutHistogram();
		}
	}
    public static void main(String[] args)
    {
     
            	HistogramPanel c1 = new HistogramPanel();
                c1.createAndShowGUI();

    }
}