import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class AnimalUI extends JFrame {
    private JButton buttonShow;
    private JList bd;
    private GridBagLayout gridbag;
    private GridBagConstraints c;
    private DefaultListModel model;

    AnimalUI() {
        super("App");
        setSize(300, 200);
        addNotify();
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent w) {
                        System.exit(0);
                    }
                });
        MyGUI();
        setVisible(true);
        setResizable(true);
    }

    private void MyGUI() {
        gridbag = new GridBagLayout();
        c = new GridBagConstraints();
        model = new DefaultListModel();
        JPanel buttonPanel = new JPanel();

        bd = new JList(model);
        JScrollPane scrollPane = new JScrollPane(bd);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        JPanel buttonsPanel = new JPanel(gridbag);

        setLayout(gridbag);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.PAGE_END;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.gridwidth = 0;
        c.gridheight = 1;
        gridbag.setConstraints(scrollPane, c);
        c.gridwidth = 1;

        c.gridy = 1;
        buttonShow = new JButton("Show");
        buttonShow.setActionCommand("Show");
        gridbag.setConstraints(buttonShow, c);

        buttonsPanel.add(scrollPane);
        buttonsPanel.add(buttonShow);

        add(buttonsPanel);
    }

    private void Buttons() {


        buttonShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.removeAllElements();
                try {
                    JFileChooser fileopen = new JFileChooser();
                    int ret = fileopen.showDialog(null, "Open");
                    if (ret == JFileChooser.APPROVE_OPTION) {
                        File file = fileopen.getSelectedFile();

                        FileInputStream fileIn = new FileInputStream(file);
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        ArrayList<Animal> Animals = (ArrayList<Animal>) in.readObject();
                        in.close();
                        fileIn.close();

                        for (Animal pcs : Animals) {
                            model.addElement(pcs.getName());
                        }
                    }

                } catch (Exception exp) {
                    System.out.println("Exception in deserialization: " + exp);
                }
            }
        });


    }

    public static void main(String[] argv) {
        AnimalUI application = new AnimalUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.Buttons();
    }

}