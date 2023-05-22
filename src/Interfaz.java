import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame{
    private JTabbedPane tabbedPane1;
    private JTextField txtNombre;
    private JTextField txtNumPaginas;
    private JButton btnIngresar;
    private JButton btnQuemar;
    private JTextField txtEliminarNombre;
    private JButton btnEliminarporNombre;
    private JTextField txEliminartId;
    private JButton btnEliminarporID;
    private JTextField txtBusquedaNombre;
    private JButton btnBuscarPorNombre;
    private JTextField txtBuscarId;
    private JButton btnBuscarPorId;
    private JTextArea txtResultadoBUsqueda;
    private JTextArea txtEliminados;
    private JPanel panel1;
    private JTextArea txtImprimirlISTA;
    private JButton btnCalcular;
    private JTextArea txtCalculo;
    private Biblioteca bl;
public Interfaz(String title) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panel1);
    this.pack();
    bl=new Biblioteca();
    btnIngresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(bl.addLibro(new Libro(txtNombre.getText(),Integer.parseInt(txtNumPaginas.getText())))){
                txtImprimirlISTA.setText(bl.toString());
            }else{
                txtImprimirlISTA.setText("No hay como agregar el libro");
            }

        }
    });
    btnQuemar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            bl.QuemarDatos();
            txtImprimirlISTA.setText(bl.toString());
            btnQuemar.setEnabled(false);
        }
    });
    btnEliminarporNombre.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Libro libro1=bl.removeLibroPorNombre(txtEliminarNombre.getText());
            if(libro1!=null){
                txtEliminados.setText("Libro encontrado "+libro1.toString());
            }else {
                txtEliminados.setText("Libro no encontrado");
            }

        }
    });
    btnEliminarporID.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Libro libro1=bl.removeLibroPorId(Integer.parseInt(txEliminartId.getText()));
            if(libro1!=null){
                txtEliminados.setText("Libro encontrado "+libro1.toString());
            }else {
                txtEliminados.setText("Libro no encontrado");
            }
        }
    });
    btnBuscarPorNombre.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Libro libro1=bl.busquedaLibro(txtBusquedaNombre.getText());
            if(libro1!=null){
                txtResultadoBUsqueda.setText("Libro encontrado "+libro1.toString());
            }else {
                txtResultadoBUsqueda.setText("Libro no encontrado");
            }

        }
    });
    btnBuscarPorId.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           Libro libro1=bl.busquedaBinario(Integer.parseInt(txtBuscarId.getText()));
           if(libro1!=null){
               txtResultadoBUsqueda.setText("Libro encontrado "+libro1.toString());
           }else {
               txtResultadoBUsqueda.setText("Libro no encontrado");
           }

        }
    });
    btnCalcular.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int indice=bl.getLibros().size()-1;
            txtCalculo.setText("Suma paginas total"+bl.sumaRecursivo(bl.getLibros(),indice));
        }
    });
}
}
