import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Main extends JFrame{

    private static Object Counter;
    private JPanel mainPanel;
    static Timer t;

    public Main(){
        this.setContentPane(mainPanel);
        int yourOption = JOptionPane.showOptionDialog(null, "Choose option", "Option dialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Settings", "Cancel"}, null);
    }

    public static void main(String[] args) {
        Main f=new Main();
        f.setSize(600,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 50,50));

        JLabel jl=new JLabel();
        f.add(jl);



        String actualTime=new SimpleDateFormat("HH:mm:ss").format(new Date().getTime());
        jl.setText(actualTime);



        JButton bt1= new JButton("Start");
        f.add(bt1);

        JButton bt2=new JButton("Stop");
        f.add(bt2);



        bt1.addActionListener(e -> {


             t=new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
                    jl.setText(sdf.format(new java.util.Date()));
                }


            });
                    t.start();


            Color BC= JColorChooser.showDialog(null,"Choose color",Color.white);
            if(BC!=null){
                jl.setForeground(BC);
            }
        });


bt2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        t.stop();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        jl.setText(sdf.format(new java.util.Date()));
    }
});


        f.setVisible(true);
    }
}
