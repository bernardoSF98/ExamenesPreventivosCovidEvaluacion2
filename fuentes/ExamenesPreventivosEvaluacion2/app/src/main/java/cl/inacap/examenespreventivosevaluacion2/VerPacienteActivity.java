//package
package cl.inacap.examenespreventivosevaluacion2;
//imports
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

//class
public class VerPacienteActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView principalLv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_paciente);
        this.toolbar = findViewById(R.id.toolbar);
        this.principalLv = findViewById(R.id.principal_lv);
        this.setSupportActionBar(this.toolbar);
        principalLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(VerPacienteActivity.this,PrincipalActivity.class);
                startActivity(intent);
            }
        });
    }
}