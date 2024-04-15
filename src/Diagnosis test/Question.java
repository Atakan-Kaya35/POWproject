/**
 * This is a Question class.
 * Consists some questions to detect the possible disease for recommendation
 */
import javax.swing.*;
import java.awt.*;

/**
 * 1. Have you had too much caffeine or alcohol lately?
 * 2. Are you tired?
 * 3. Did you hit your sore spot against something hard?
 * 4. Could you have consumed spoiled food recently?
 * 5. Are you hungry?
 * 6. Has gas accumulated in your stomach?
 * 7. Have you exercised excessively lately?
 * 8. Is your painful area swollen?
 * 9. Have you come into contact with an allergen?
 * 10. Have you been out in the sun too long?
 * 11. Is your asthma triggered?
 * 12. Is there dryness in your throat?
 * 13. Did you catch a cold?
 */

public class Question
{
    //Instance variables
    private JPanel qPanel;
    private String question;
    private JRadioButton yes;
    private JRadioButton no;

    //Constructor
    /**
     * eaxh number represents specific question
     * You can add extra questions. 
     * Don't forget to add its name here 
     * Assign new question to relevant symptoms. (test class - firstListener)
     * It should compile according to new, updated questions.
     */
    public Question(int number)
    {
        if(number == 1) {question = "Have you had too much caffeine or alcohol lately?";}
        else if(number == 2) {question = "Are you tired?";}
        else if(number == 3) {question = "Did you hit your sore spot against something hard?";}
        else if(number == 4) {question = "Could you have consumed spoiled food recently?";}
        else if(number == 5) {question = "Are you hungry?";}
        else if(number == 6) {question = "Has gas accumulated in your stomach?";}
        else if(number == 7) {question = "Have you exercised excessively lately?";}
        else if(number == 8) {question = "Is your painful area swollen?";}
        else if(number == 9) {question = "Have you come into contact with an allergen?";}
        else if(number == 10) {question = "Have you been out in the sun too long?";}
        else if(number == 11) {question = "Is your asthma triggered?";}
        else if(number == 12) {question = "Is there dryness in your throat?";}
        else if(number == 13) {question = "Did you catch a cold?";}
        else if(number == 14) {question = "DENEME";}

        //Add your possible question

        qPanel = creatOneQPanel();
    }

    /**
     * It ıs one line panel which contains question and yes/no ratio button
     * @return panel
     */
    public JPanel creatOneQPanel()
    {
        JPanel q = new JPanel();
        q.setLayout(new GridLayout(1,2));
        q.add(createQ());
        q.add(createYesNo());
        return q;
    }

    /**
     * Create label includes question.
     * @return label
     */
    public JLabel createQ()
    {
        JLabel q = new JLabel(getQ());
        return q;
    }

    /**
     * Create ratio buttons, put them in button group and add them to the panel and return 
     * @return panel
     */
    public JPanel createYesNo()
    {
        JPanel buttons = new JPanel();
        yes = new JRadioButton("Yes");
        no = new JRadioButton("No");
        ButtonGroup g = new ButtonGroup();
        g.add(yes);
        g.add(no);

        buttons.add(yes);
        buttons.add(no);
        return buttons;
    }

    /**
     * Give question as a string
     * @return question
     */
    public String getQ()
    {
        return question;
    }

    /**
     * Give panel includes question and buttons
     * @return panel
     */
    public JPanel getOneQ()
    {
        return qPanel;
    }

    /**
     * Give yes button (in order to determine whether it is selected or not while compiling)
     * @return yes button
     */
    public JRadioButton getYesButton()
    {
        return yes;
    }
}
