import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class Project {

    public static JPanel p_name;
    public static JPanel p_time;
    public static JLabel l_name;
    public static JLabel l_time;
    public static JTextField tf_name;
    public static JTextField tf_time;
    public static void main(String[] args) {

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

        //Frame Display///////////////////////////////////////
        frame.add(p_main);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}