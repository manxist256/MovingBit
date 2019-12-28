package TollFreeDecryptor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TollFreeDecryptorManager {

    private final TollFreeDecryptService tollFreeDecryptService;

    public TollFreeDecryptorManager(TollFreeDecryptService tollFreeDecryptService) {
        this.tollFreeDecryptService = tollFreeDecryptService;
    }

    public String decodeFancyNumber(String fancyNumber) {
        try {
            String decodedFancyNumber = tollFreeDecryptService.decode(fancyNumber);
            return decodedFancyNumber;
        } catch(Exception e) {
            System.out.println(String.format("There was some error decoding the fancy number %s",  fancyNumber));
            throw e;
        }
    }

}

class UserInterface extends JFrame implements MouseListener {

    TollFreeDecryptorManager tollFreeDecryptorManager;

    private JTextField inputField;
    private JButton decodeButton;

    private final boolean TRUE = true;
    private final int C_WIDTH = 300;
    private final int C_HEIGHT = 400;
    private static final int TEXT_FIELD_MAX_CHAR = 20;
    private static final String DECODE = "DECODE";

    public UserInterface() {
        this.tollFreeDecryptorManager = new TollFreeDecryptorManager(new DefaultTollFreeDecryptService());
        initializeComponents();
        buildJFrame();
        addComponents();
        addListeners();
    }

    private void initializeComponents() {
        this.inputField = new JTextField(TEXT_FIELD_MAX_CHAR);
        this.decodeButton = new JButton(DECODE);
    }

    private void buildJFrame() {
        this.setVisible(TRUE);
        this.setResizable(TRUE);
        this.setSize(C_WIDTH, C_HEIGHT);
        this.setTitle("DECODE FANCY NUMBERS");
        this.getContentPane().setBackground(Color.CYAN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
    }

    private void addComponents() {
        this.add(inputField);
        this.add(decodeButton);
    }

    private void addListeners() {
        this.decodeButton.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String fancyNumber = inputField.getText();
        String decodedFancyNumber = tollFreeDecryptorManager.decodeFancyNumber(fancyNumber);
        inputField.setText(decodedFancyNumber);
    }

    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }

    public static void main(String... args) {
        new UserInterface();
    }
}
