package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD.Usuarios;


public class Citas extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Spinner spinner;
    TextView cabecera;
    ImageView dateButton, timeButton;
    TextView edt_fecha, edt_hora;
    Button enviar, cancelar;

    public static ArrayList<Usuarios>users= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        dateButton = (ImageView) findViewById(R.id.btn_calendar);
        timeButton = (ImageView) findViewById(R.id.btn_reloj);
        edt_fecha = (TextView) findViewById(R.id.edt_fecha);
        edt_hora = (TextView) findViewById(R.id.edt_hora);
        enviar = (Button) findViewById(R.id.boton_enviar_consulta);
        cancelar = (Button)findViewById(R.id.boton_cancelar_consulta);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView cabecera = (TextView) findViewById(R.id.cabecera);

        cabecera.setVisibility(View.INVISIBLE);

        //Crearnos una adaptador para volcar los datos

        ArrayAdapter<CharSequence> adapta = ArrayAdapter.createFromResource(this, R.array.consultas_secretaria_array, android.R.layout.simple_spinner_item);

        //Forma en la que se desplegara la lista de opciones

        adapta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Asignarlo a nuestro adaptador

        spinner.setAdapter(adapta);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        Toast.makeText(parent.getContext(), "Has seleccionado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;

                    case 2:
                        Toast.makeText(parent.getContext(), "Has seleccionado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;

                    case 3:
                        Toast.makeText(parent.getContext(), "Has seleccionado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;

                    case 4:
                        Toast.makeText(parent.getContext(), "Has seleccionado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;

                    case 5:
                        Toast.makeText(parent.getContext(), "Has seleccionado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Citas.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );

                Calendar[] days = new Calendar[13];
                for (int i = -6; i < 7; i++) {
                    Calendar day = Calendar.getInstance();
                    day.add(Calendar.DAY_OF_MONTH, i * 2);
                    days[i + 6] = day;
                }


                    dpd.setSelectableDays(days);

                dpd.show(getFragmentManager(), "Datepickerdialog");

            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now1 = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        Citas.this,
                        now1.get(Calendar.HOUR_OF_DAY),
                        now1.get(Calendar.MINUTE),
                        false
                );

                tpd.vibrate(true);

                tpd.enableSeconds(false);

                tpd.setTimeInterval(1,10,1);

                tpd.show(getFragmentManager(), "Timepickerdialog");
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoEnviar();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoCancelar();
            }
        });

    }//fin onCreate


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "Fecha seleccionada "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        edt_fecha.setText(date);
    }



    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String time = "Hora seleccionada: "+hourOfDay+"h"+minute+"m"+second;
        edt_hora.setText(time);
    }

    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");
        if(dpd != null) dpd.setOnDateSetListener(this);
        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("Timepickerdialog");
        if(tpd != null) tpd.setOnTimeSetListener(this);
    }

    public void dialogoEnviar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Citas.this);
        builder.setTitle("Solicitud de cita Secretaria");

        builder.setMessage("Revise sus datos antes de enviarlos....¿Desea enviarlos?");

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Van a ser enviados a la BBDD", Toast.LENGTH_SHORT).show();
                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "No vas a enviar nada", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void dialogoCancelar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Citas.this);
        builder.setTitle("Solicitud de cita Secretaria");

        builder.setMessage("¿Desea salir de la solicitud de citas? Sus datos serán eliminados");

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Vas a permanecer en la activity", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

