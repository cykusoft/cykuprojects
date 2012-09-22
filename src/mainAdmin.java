import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class mainAdmin extends JFrame implements ActionListener{
    private String vgf_sModusTransaction;
    private String [] sButtonText = {"New", "Edit"};
    private JToolBar toolbar;
    mainAdmin(){
        initComponents();
        setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initComponents(){
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventPostProcessor(new PostProcessor());
        toolbar = new JToolBar();
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
        for(String text: sButtonText){
            JButton b = new JButton(text);
            b.addActionListener(this);
            toolbar.add(b);
        }
        getContentPane().add(toolbar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vgf_sModusTransaction = e.getActionCommand();
        setButtons();
    }
    class PostProcessor implements KeyEventPostProcessor{
        @Override
        public boolean postProcessKeyEvent(KeyEvent e){
            if(e.getID() == KeyEvent.KEY_PRESSED && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_N:
                        vgf_sModusTransaction = "New";
                        setButtons();
                        break;
                    case KeyEvent.VK_M:
                        vgf_sModusTransaction = "Edit";
                        setButtons();
                        break;    
                }
            }
            return true;
        }
    }
    private void setButtons(){
        for(Component c : toolbar.getComponents()){
            if(c instanceof JButton){
                JButton b = (JButton)c;
                b.setEnabled(!b.getText().equals(vgf_sModusTransaction));
            }
        }
    }
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainAdmin id = new mainAdmin();
                id.setVisible(true);
            }
        });
    }
}