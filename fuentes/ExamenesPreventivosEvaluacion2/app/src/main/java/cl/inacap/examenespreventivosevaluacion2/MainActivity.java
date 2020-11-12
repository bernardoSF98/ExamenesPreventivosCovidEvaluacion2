//package
package cl.inacap.examenespreventivosevaluacion2;
//imports
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import java.util.Calendar;
import java.util.List;
import cl.inacap.examenespreventivosevaluacion2.adapters.PacientesArrayAdapter;
import cl.inacap.examenespreventivosevaluacion2.dao.PacientesDAO;
import cl.inacap.examenespreventivosevaluacion2.dao.PacientesDAOLista;
import cl.inacap.examenespreventivosevaluacion2.dto.Paciente;
//class
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //attributes and references
    private ListView pacientesLv;
    private List<Paciente> pacientes;
    private PacientesArrayAdapter adaptador;
    private PacientesDAO pacientesDAO = PacientesDAOLista.getInstance();
    private int dia,mes,ano;
    private Spinner area_registrar;
    private Button ingresar;
    private Button registrarBtn;
    private Button NuevoPacienteBtn;
    private ListView pacientes_lv;
    private ListView principallv;
    private EditText date_registrar;
    private EditText ingresarContraseña;
    private EditText ingresarRut;
    private EditText rut_registrar;
    private EditText nombre_registrar;
    private EditText apellido_registrar;
    private EditText temperatura_registrar;
    private EditText presion_arterial_registrar;
    private Switch sistomas_registrar;
    private Switch tos_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this
        this.pacientesLv = findViewById(R.id.pacientes_lv);
        this.principallv = findViewById(R.id.principal_lv);
        this.ingresarRut = findViewById(R.id.ingresarRut);
        this.ingresarContraseña = findViewById(R.id.ingresarContraseña);
        this.date_registrar = findViewById(R.id.date_registrar);
        this.area_registrar = findViewById(R.id.area_registrar);
        this.ingresar = findViewById(R.id.ingresar);
        this.registrarBtn = findViewById(R.id.registrarBtn);
        this.NuevoPacienteBtn = findViewById(R.id.NuevoPacienteBtn);
        this.rut_registrar = findViewById(R.id.rut_registrar);
        this.nombre_registrar = findViewById(R.id.nombre_registrar);
        this.apellido_registrar = findViewById(R.id.apellido_registrar);
        this.temperatura_registrar = findViewById(R.id.temperatura_registrar);
        this.sistomas_registrar = findViewById(R.id.sistomas_registrar);
        this.tos_registrar = findViewById(R.id.tos_registrar);
        this.presion_arterial_registrar = findViewById(R.id.presion_arterial_registrar);
        //buttons
        ingresar.setOnClickListener(this);
        registrarBtn.setOnClickListener(this);
        NuevoPacienteBtn.setOnClickListener(this);
        //toolbar
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        pacientes = pacientesDAO.getAll();
        adaptador = new PacientesArrayAdapter(this, R.layout.ver_paciente, pacientes);
        pacientesLv = findViewById(R.id.pacientes_lv);
        pacientesLv.setAdapter(adaptador);
        pacientesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,PrincipalActivity.class);
                startActivity(intent);
            }
        });
    }
    //mostrar errores en la app
    private void mostrarErrores(List <String> errores) {
        //1. generar una cadena de texto con los errores
        String mensaje = "";
        for (String e: errores) {
            mensaje+= "-" + e + "\n";
        }
        //2. mostrar un mensaje de alerta
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        //chaining (encademaniento)
        alertBuilder
                .setTitle("Error De Validacion") //define el titulo
                .setMessage(mensaje) //define el mensaje a mostrar
                .setPositiveButton("Agregar", null) //agrega el boton
                .create() //crear el alert
                .show(); //lo muestra
    }
    //calendario
    @Override
    public void onClick(View v) {
        if(v==date_registrar) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet (DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    date_registrar.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }
    }
}
//end