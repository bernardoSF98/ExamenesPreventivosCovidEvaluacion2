//package
package cl.inacap.examenespreventivosevaluacion2.adapters;
//imports
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import cl.inacap.examenespreventivosevaluacion2.R;
import cl.inacap.examenespreventivosevaluacion2.dto.Paciente;
//class
public class PacientesArrayAdapter extends ArrayAdapter<Paciente> {
    //attributes
    private Activity activity;
    private List <Paciente> pacientes;
    //public
    public PacientesArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Paciente> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.pacientes = objects;
    }
    //method
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.ver_paciente, null, true);
        TextView nombreTv = fila.findViewById(R.id.pacientes_lv);
        Paciente actual = pacientes.get(position);
        nombreTv.setText(actual.getNombre());
        return fila;
    }
}
//end