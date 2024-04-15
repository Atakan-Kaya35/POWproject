/**
 * This is Menu class.
 * It shows initial page of the test
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame
{
    //Instance variables
    private JPanel menu;
    private JPanel title;
    private JButton start;

    //Constructor
    public Menu()
    {
        title = createTitle();
        start = createButton();
        menu = createMenu();
        add(menu);
        setSize(500,100);
    }

    /**
     * Create panel that shows test title and warning part.
     * @return panel
     */
    public JPanel createTitle()
    {
        JPanel title = new JPanel();
        title.setLayout(new GridLayout(2,1));
        JLabel l1 = new JLabel("Welcome to \"Quick Diagnosis Test\"");
        JLabel l2 = new JLabel("WARNING: It is just recommendation. Thus, you must see your doctor, anyway!");
        title.add(l1);
        title.add(l2);
        return title;
    }

    /**
     * Create button which starts test
     * @return button
     */
    public JButton createButton()
    {
        JButton b = new JButton("Start");
        ActionListener listener = new ClickListener();
        b.addActionListener(listener);
        return b;

    }

    /**
     * Listener inner class. Implements actionPerformed method
     */
    class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            getMenu().dispose();
            JFrame test = new Test();
            test.setTitle("Answer Questions");
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            test.setVisible(true);
        }
    }

    /**
     * Create menu by assembling start button and test title.
     * @return panel
     */
    public JPanel createMenu()
    {
        JPanel menu = new JPanel();
        menu.setLayout(new BorderLayout());
        menu.add(title,BorderLayout.CENTER);
        menu.add(start, BorderLayout.SOUTH);
        return menu;
    }

    /**
     * Give menu (in order o access its reference)
     * @return Frame
     */
    public JFrame getMenu()
    {
        return this;
    }
}