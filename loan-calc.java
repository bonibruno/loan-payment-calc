// Loan Payment Calculator written in Java
// by Boni Bruno
//
//Import necessary GUI class and event libraries

import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

 

//A JFrame object is the physical window that works within the Swing API.

//The ActionListener interface defines the actionPerformed() method needed to handle events.

 

public class LoanCalculator extends JFrame implements ActionListener

 

{

 

 //JPanels are just containers for components, the different types of panes are

 //added to the JFrame's contentpane and then components are added to the JPanel.

      Container contentPane = getContentPane();

 

//Create a gridlayout with 4 rows and 2 columns)

        JPanel grid = new JPanel(new GridLayout(4,2));

 

        //JTextField enables the user to enter a line of text.  I set the column width to 15 and leave the field empty to begin.

        //When you press enter when inputting into a text field an ActionEvent is generated.

        //JTextField provides the addActionListener() and removeActionListener() methods.

               JTextField principal = new JTextField ("",15);

               JTextField rate = new JTextField ("",15);

               JTextField months = new JTextField ("",15);

               JTextField payment = new JTextField ("",15);

        

//Here I define the labels for JFrame.  With the JLabel class, you can display unselectable text and images.

        JLabel lblml = new JLabel("MORTGAGE CALCULATOR");

        JLabel lblp = new JLabel("     Principal");

        JLabel lblr = new JLabel("     Rate         ");

        JLabel lblm = new JLabel("     Months       ");

        JLabel lblmp = new JLabel("     Payment      ");

        //Two buttons here, one to Calculate the Monthly Payment and another to clear the contents.

        //The local variables are "btn" and "btnc".

        JButton btn = new JButton("Calculate");

        JButton btnc = new JButton("   Clear    ");

        //Here I set two more pannels, one for the title panel and another for the button pannel.

        JPanel pnl = new JPanel();

        JPanel bpnl = new JPanel();

 

 

        public LoanCalculator()

        {

            //Here I set the window size, fonts, and background color for my labels and textfields.  This is pretty cool and was fun to learn.

            //When an object is created, it's necessary to call the constructors of all super classes to initialize their fields.

            //Java does this automatically at the beginning if you don't, I'm specifically putting it here to be safe.

            super("");

                //Here I set the window size.

                setSize(300,200);

                //Exit the program when your user closes the frame

                setDefaultCloseOperation(EXIT_ON_CLOSE);

                //Set fonts for each label and textfield.

                lblml.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                lblp.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                lblr.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                lblm.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                lblmp.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                principal.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                rate.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                months.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                payment.setFont(new Font ("TimesRoman", Font.BOLD, 16));

                //Set background color for my title and button panels and grid.

                pnl.setBackground(Color.yellow);

                grid.setBackground(Color.pink);

                bpnl.setBackground(Color.pink);

                //Here I assign my ml label to my title panel

                pnl.add(lblml);

                //Here I populate my grid with my lables, textfields and buttons accordingly

                grid.add(lblp);grid.add(principal);

                grid.add(lblr);grid.add(rate);

                grid.add(lblm);grid.add(months);

                grid.add(lblmp);grid.add(payment);

                bpnl.add(btnc);bpnl.add(btn);

                //Here I add my listeners for my Calculate and Clear buttons.

                btn.addActionListener(this);

                btnc.addActionListener(this);

                //Here I add my content panes.

                //Before Java 2 each top-level container had only one layer.

                //Java 2 top-level containers (JFrame, JApplet, etc.) and have several layers (panes): root, content, layered, and glass.

                //I'm just using the content pane here.

                //I place my Title Panel on top, my grid in the middle, and my button panel at the bottom of the window.

                contentPane.add("North",pnl);

                contentPane.add("Center",grid);

                contentPane.add("South",bpnl);

                //Display the window.

                 setVisible(true);

        }
//This is my event handler for the Calculate Button and Clear Button
//To handle events, you must implement the actionPerformed() method defined by the ActionListener interface.

 

        public void actionPerformed(ActionEvent event)

        {
//If the Calulate button is pressed I run through the Calculate method and display the payment.

                if(event.getSource() == btn)

                {

                         //declare tpayment as a double and uses the calculate method to get its value.

                         double tpayment = Calculate();

                         //getCurrencyInstance Returns a new NumberFormat instance which formats monetary values for the specified locale.

                         //This makes my monthly payment come out nicely with $ and , added accordingly.

                         java.text.NumberFormat cf = java.text.NumberFormat.getCurrencyInstance();

                         payment.setText(cf.format(tpayment));

                }

//If the clear button is pressed, I clear all the GUI fields so the user can enter new values.

                if (event.getSource() == btnc)

                                                {

                                                                payment.setText("");

                                                                principal.setText("");

                                                                rate.setText("");

                                                                months.setText("");

                        }

        }

//Here is the main calculation method called Calculate

        public double Calculate()

                {

//I start by defining the temp variables for principal, rate, payment and months.

        double tprincipal, trate;

                double tpayment = 0;

        int tmonths;

//I also need to define some string variables for the GUI

        String strprin = principal.getText();

        String strrate = rate.getText();

        String strmon = months.getText();

//Here I parse the strings and assign them to the temp variables to calculate the payment

                tprincipal = Double.parseDouble(strprin);

                trate = Double.parseDouble(strrate);

                tmonths = Integer.parseInt(strmon);

        {
//This is the forumula if the interest rate is 0 for 0 APR programs.

                 if(trate == 0)

                  {

                      tpayment = (tprincipal/tmonths);

                  }

                 else

//This is the main forumula to calculate the monthly payment.

                 {

                                        trate = trate/100;

                        tpayment = ( trate * tprincipal/12) /(1 - Math.pow(trate/12 + 1, -tmonths));

                 }

        }

//Once the payment is calculated, I return tpayment so the other methods can use it.

        return tpayment;

                }

//This is the main program where I create the LoanCalculator

        public static void main (String[] args)

        {LoanCalculator loan = new LoanCalculator();  }

}
