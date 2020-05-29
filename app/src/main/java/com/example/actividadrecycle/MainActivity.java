package com.example.actividadrecycle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //definicion un objeto ArrayList de forma global
    ArrayList<Model>models=new ArrayList<>();

    // definicion de los objetos
    RecyclerView mRecycleView;
    Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView=findViewById(R.id.recycleview1);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter= new Adapter(this, getMyList());
        mRecycleView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList(){
        // se define  un objeto  del Modelo creado en modelo
        Model m=new Model();

        // estableciendo valores a los atributos segun el modelo del atributo
        m.setTitle("Facultativa II");
        m.setDescripcion ("Andoid Studio");
        m.setImage(R.drawable.app);
        m.setProfesor("Saira Cienfuego");
        m.setDia("25 de mayo del 2020");
        m.setHora("12:00");
        m.setFechaent("26 de mayo del 2020");
        models.add(m);// agregar al ArrayList

        m=new Model();
        //objeto2
        m.setTitle("Investigación");
        m.setDescripcion ("Recolecion de la informacion");
        m.setImage(R.drawable.files);
        m.setProfesor("Jazcar Bravo");
        m.setDia("25 de mayo del 2020");
        m.setHora("12:00");
        m.setFechaent("26 de mayo del 2020");
        models.add(m);// agrega al ArrayList

        //objeto3
        m=new Model();
        m.setTitle("Planificación TIC");
        m.setDescripcion ("Desarrollo de talleres informaticos");
        m.setProfesor("Miriam Tellez");
        m.setDia("25 de mayo del 2020");
        m.setHora("12:00");
        m.setFechaent("26 de mayo del 2020");
        m.setImage(R.drawable.pc);
        models.add(m);// agrega al Arreaylist

        return models;// retorna la vista
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuasignatura, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addclose:// acciones para el  item cerrra del dialogo
                this.finish();//
            case R.id.addmenu:// item para el addnew del diaqlogo

                final Dialog dlg = new Dialog(this);// definir obejto del dialogo
                dlg.setContentView(R.layout.activity_registroasignatura);// xml del dialogo
                dlg.setTitle("ASIGNATURA");
                dlg.setCancelable(false);//no se puede cerrar

                //referenciando botones del dialogo
                Button buttonagregar = (Button) dlg.findViewById(R.id.buttonagregar);// asiendo refencia al botón guardar
                Button buttoncancelar = (Button) dlg.findViewById(R.id.buttoncancelar);// referencia al boton cancelar

                // evento click para agregar nuevo
                buttonagregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        EditText editText_asigna = (EditText) dlg.findViewById(R.id.editTextnombreasig);
                        EditText editText_descrip = (EditText) dlg.findViewById(R.id.editTextdescrip);
                        EditText editText_profe = (EditText) dlg.findViewById(R.id.editTextProfesor);
                        EditText editText_dia = (EditText) dlg.findViewById(R.id.editTextDia);
                        EditText editText_hora = (EditText) dlg.findViewById(R.id.editTexthora);
                        EditText editText_fechaentr = (EditText) dlg.findViewById(R.id.editTextfechaentre);


                        // los campos no queden vacios de los edit_text
                        // se creo un if para todo los edit_text
                        if(editText_asigna.getText().toString().isEmpty()) {
                            Toast.makeText(V.getContext(), "Agregar la Asignatura!!!", Toast.LENGTH_LONG).show();
                            return;
                        }

                        if(editText_descrip.getText().toString().isEmpty()) {
                            Toast.makeText(V.getContext(), "Agregar la descripcíon!!!", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(editText_profe.getText().toString().isEmpty()) {
                            Toast.makeText(V.getContext(), "Agregar el profesor!!!", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(editText_dia.getText().toString().isEmpty()) {
                            Toast.makeText(V.getContext(), "Agregar el dia!!!", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(editText_hora.getText().toString().isEmpty()) {
                            Toast.makeText(V.getContext(), "Agregar la hora!!!", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if(editText_fechaentr.getText().toString().isEmpty()) {
                            Toast.makeText(V.getContext(), "Agregar la fecha de entrega!!!", Toast.LENGTH_LONG).show();
                            return;
                        }


                        Model model = new Model();// se define  un objeto  del Modelo creado en modelo
                        model.setTitle(editText_asigna.getText().toString());
                        model.setDescripcion(editText_descrip.getText().toString());
                        model.setProfesor(editText_profe.getText().toString());
                        model.setImage(R.drawable.book);
                        model.setDia(editText_dia.getText().toString());
                        model.setHora(editText_hora.getText().toString());
                        model.setFechaent(editText_fechaentr.getText().toString());


                        models.add(model);//Agrega al ArrayList
                        myAdapter = new Adapter(V.getContext(), models);//actualizar el recycleView
                        mRecycleView.setAdapter(myAdapter);
                        dlg.cancel();
                        Toast.makeText(V.getContext(), "guardado",Toast.LENGTH_SHORT).show();
                    }


                });

                // evento click cancelar
                buttoncancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.cancel();
                    }
                });

                dlg.show();// muestra el dialogo
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}


