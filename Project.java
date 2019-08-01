import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class Project {

    public static JPanel p_name;
    public static JPanel p_time;
    public static JPanel p_message;
    public static JLabel l_name;
    public static JLabel l_time;
    public static JLabel l_message;
    public static JTextField tf_name;
    public static JTextField tf_time;
    public static JTextArea tf_message;
    public static Linked_List linkedlist;
    public static void main(String[] args) {

        
        linkedlist = new Linked_List();

        JFrame frame = new JFrame("Runners");
        JPanel p_main = new JPanel();
        p_main.setLayout(new BoxLayout(p_main,BoxLayout.Y_AXIS));

        //Name Panel//////////////////////////////////////////
        p_name = new JPanel();
        p_name.setLayout(new FlowLayout(FlowLayout.CENTER));
        p_main.add(p_name);

        l_name = new JLabel("Name");
        tf_name = new JTextField();
        tf_name.setPreferredSize(new Dimension(150,50));
        p_name.add(l_name);
        p_name.add(tf_name);

        //Time Panel//////////////////////////////////////////
        p_time = new JPanel();
        p_time.setLayout(new FlowLayout(FlowLayout.CENTER));
        p_main.add(p_time);

        l_time = new JLabel("Time(minutes)");
        tf_time = new JTextField();
        tf_time.setPreferredSize(new Dimension(150,50));
        p_time.add(l_time);
        p_time.add(tf_time);

        //Marathon joined Panel///////////////////////////////
        JPanel p_joined=  new JPanel();
        p_joined.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel l_joined = new JLabel("Category : ");

        p_joined.add(l_joined);

        p_main.add(p_joined);

        ButtonGroup bg_joined = new ButtonGroup();

        JRadioButton rb_GreatDelhiRun = new JRadioButton("Great Delhi Run");
        JRadioButton rb_OpenRun = new JRadioButton("Open 10K Run");
        JRadioButton rb_HalfMarathon = new JRadioButton("Half Marathon");

        bg_joined.add(rb_GreatDelhiRun);
        bg_joined.add(rb_OpenRun);
        bg_joined.add(rb_HalfMarathon);

        p_joined.add(rb_GreatDelhiRun);
        p_joined.add(rb_OpenRun);
        p_joined.add(rb_HalfMarathon);

        //Button Panel/////////////////////////////////////////


        JPanel p_buttons = new JPanel();
        p_buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton b_next = new JButton("Next");
        JButton b_winner = new JButton("Winner");
        JButton b_cancel = new JButton("Cancel");
        p_buttons.add(b_next);
        p_buttons.add(b_winner);
        p_buttons.add(b_cancel);
        p_main.add(p_buttons);


        b_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = tf_name.getText();
                int time = Integer.parseInt(tf_time.getText());
                boolean hm = rb_HalfMarathon.isSelected();
                boolean gdr = rb_GreatDelhiRun.isSelected();
                boolean otr = rb_OpenRun.isSelected();
                linkedlist.insert(name,time,hm,gdr,otr);
                System.out.println("added");
            }
        });

        

        //Message Panel/////////////////////////////////////////
        JPanel p_message = new JPanel();
        p_message.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel l_message = new JLabel("Winners: ");
        JTextArea tf_message = new JTextArea();
        tf_message.setPreferredSize(new Dimension(150,250));
        p_message.add(l_message);
        p_message.add(tf_message);
        p_main.add(p_message);


        
        b_winner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                String message = linkedlist.winners();
                tf_message.setText(message);
            }
        });

        b_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        //Frame Display///////////////////////////////////////
        frame.add(p_main);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
class Runner
    { 
        String name;
        private int time;
        private boolean hm,gdr,otr;
        Runner next;

        public Runner()
        {
            this.name = "";
            this.time = 0;
            this.hm = false;
            this.gdr = false;
            this.otr = false;
            next = null;
        }

        public Runner(String name, int time, boolean hm, boolean gdr, boolean otr)
        {
            this.name = name;
            this.time = time;
            this.hm = hm;
            this.gdr = gdr;
            this.otr = otr;
            next = null;
        }
    }
class Linked_List 
{ 
    static int winHM;
    static int secHM;
    static int winGDR;
    static int secGDR;
    static int winOTR;
    static int secOTR;
 
    static Runner head = null;
    static Runner win1 = null;
    static Runner sec1 = null;
    static Runner win2 = null;
    static Runner sec2 = null;
    static Runner win3 = null;
    static Runner sec3 = null;


    static void insert(String name, int time, boolean hm, boolean gdr, boolean otr) 
    {
        Runner  ptr_to_insert = new Runner(name,time,hm,gdr,otr);
        ptr_to_insert.next = head;
        head = ptr_to_insert;
        if(hm==true)
        {
            if(win1==null)
            {
                win1 = ptr_to_insert;
                winHM = time;
            }
            else if(sec1==null && time>winHM)
            {
                sec1 = ptr_to_insert;
                secHM = time;
            }
            else if(time<winHM)
            {
                sec1 = win1;
                secHM = winHM;
                win1 = ptr_to_insert;
                winHM = time;
            }
            else if(time>winHM && time<secHM)
            {
                sec1 = ptr_to_insert;
                secHM = time;
            }
        }
        else if(gdr==true)
        {
            if(win2==null)
            {
                win2 = ptr_to_insert;
                winGDR = time;
            }
            else if(sec2==null && time>winGDR)
            {
                sec2 = ptr_to_insert;
                secGDR = time;
            }
            else if(time<winGDR)
            {
                sec2 = win2;
                secGDR = winGDR;
                win2 = ptr_to_insert;
                winGDR = time;
            }
            else if(time>winGDR && time<secGDR)
            {
                sec2 = ptr_to_insert;
                secGDR = time;
            }
        }
        else if(otr==true)
        {
            if(win3==null)
            {
                win3 = ptr_to_insert;
                winOTR = time;
            }
            else if(sec3==null && time>winOTR)
            {
                sec3 = ptr_to_insert;
                secOTR = time;
            }
            else if(time<winOTR)
            {
                sec3 = win3;
                secOTR = winOTR;
                win3 = ptr_to_insert;
                winOTR = time;
            }
            else if(time>winOTR && time<secOTR)
            {
                sec3 = ptr_to_insert;
                secOTR = time;
            }
        }
    }
    static String winners()
    {
        String hmwinner;
        String hmsecond;
        String gdrwinner;
        String gdrsecond;
        String otrwinner;
        String otrsecond;
        if(win1==null)
        {
            hmwinner="None";
        }
        else
        {
            hmwinner = win1.name;
        }
        if(sec1==null)
        {
            hmsecond="None";
        }
        else
        {
            hmsecond = sec1.name;
        }
        if(win2==null)
        {
            gdrwinner="None";
        }
        else
        {
            gdrwinner = win2.name;
        }
        if(sec2==null)
        {
            gdrsecond="None";
        }
        else
        {
            gdrsecond = sec2.name;
        }
        if(win3==null)
        {
            otrwinner="None";
        }
        else
        {
            otrwinner = win3.name;
        }
        if(sec3==null)
        {
            otrsecond="None";
        }
        else
        {
            otrsecond = sec3.name;
        }
        

        String message = "Half Marathon winners: \n First:"+hmwinner+"\n Prize: Rs. 2,80,000 \n Second:"+hmsecond+"\n Prize: Rs. 2,10,000 \n Open 10K Run: \n First: "+otrwinner+"\n Prize: Rs. 1,90,000 \n Second: "+otrsecond+"\n Prize: Rs. 1,50,000 \n Great Delhi Run \n First: "+gdrwinner+"\n Prize: Rs. 1,35,000 \n Second: "+gdrsecond+"\n Prize: Rs. 1,15,000";
        return message;
    }
}