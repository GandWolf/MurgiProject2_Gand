package murgiproject.www.iesmurgi.org.murgiprojectv2;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD.ConexionBD;
import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD.InsertarDatos;


public class Citas extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    private ImageView dateButton, timeButton;
    private TextView edt_fecha, edt_hora;
    private Button enviar, cancelar;
    private EditText nombre, apellidos;
    private String asunto, fecha, hora;

    public static ArrayList<String> datosFecha = new ArrayList<>();
    public static ArrayList<String> datosHora = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        asunto = "";
        dateButton = (ImageView) findViewById(R.id.btn_calendar);
        timeButton = (ImageView) findViewById(R.id.btn_reloj);
        edt_fecha = (TextView) findViewById(R.id.edt_fecha);
        edt_hora = (TextView) findViewById(R.id.edt_hora);
        enviar = (Button) findViewById(R.id.boton_enviar_consulta);
        cancelar = (Button) findViewById(R.id.boton_cancelar_consulta);
        nombre = (EditText) findViewById(R.id.editText_Nombre);
        apellidos = (EditText) findViewById(R.id.editText_Apellido);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView cabecera = (TextView) findViewById(R.id.cabecera);

        compruebaInternet();

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
                        asunto = "matriculacion";
                        break;

                    case 2:
                        Toast.makeText(parent.getContext(), "Has seleccionado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        cabecera.setVisibility(View.VISIBLE);
                        asunto = "solicitud de certificados";
                        break;

                    case 3:
                        Toast.makeText(parent.getContext(), "Has seleccionado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        cabecera.setVisibility(View.VISIBLE);
                        asunto = "informacion oferta educativa";
                        break;

                    case 4:
                        Toast.makeText(parent.getContext(), "Has seleccionado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        cabecera.setVisibility(View.VISIBLE);
                        asunto = "otros";
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
                compruebaInternet();
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Citas.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );

                dpd.show(getFragmentManager(), "Datepickerdialog");

            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compruebaInternet();
                Calendar now1 = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        Citas.this,
                        now1.get(Calendar.HOUR_OF_DAY),
                        now1.get(Calendar.MINUTE),
                        true
                );

                tpd.vibrate(true);

                tpd.enableSeconds(false);

                tpd.setTimeInterval(1, 10, 60);
                tpd.setMinTime(9, 0, 0);
                tpd.setMaxTime(14, 0, 0);


                tpd.show(getFragmentManager(), "Timepickerdialog");
            }
        });


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoCancelar();
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nombre.getText().toString().isEmpty() || apellidos.getText().toString().isEmpty() || edt_fecha.getText().toString().isEmpty() || edt_hora.getText().toString().isEmpty() || asunto.equals("")) {
                    Snackbar.make(findViewById(android.R.id.content), "¡¡¡Error!!! Inserte todos los datos", Snackbar.LENGTH_SHORT).show();

                } else {
                dialogoEnviar();
                }


            }
        });
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



                        new InsertarDatos(Citas.this, nombre.getText().toString(), apellidos.getText().toString(), asunto, fecha, hora).execute();
                        Snackbar.make(findViewById(android.R.id.content), "Cita elegida correctamente", Snackbar.LENGTH_LONG).show();

                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Date fec=null;
        String date = "Fecha seleccionada: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        edt_fecha.setText(date);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        String dat = year +"-"+(monthOfYear + 1) + "-"  +dayOfMonth;
        try {
            fec=dt.parse(dat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fecha=dt.format(fec);


    }


    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        Date hor=null;
        String time = "Hora seleccionada: " + hourOfDay + "h" + minute + "min";
        edt_hora.setText(time);
        String h = hourOfDay + ":" + minute + ":" + second;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
        try {
            hor=dt.parse(h);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        hora=dt.format(hor);


    }


    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");
        if (dpd != null) dpd.setOnDateSetListener(this);
        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("Timepickerdialog");
        if (tpd != null) tpd.setOnTimeSetListener(this);
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
                    public void onClick(DialogInterface dialog, int which) {}
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void compruebaInternet () {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // conectado
            enviar.setEnabled(true);
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
            }
        } else {//desconectado
            Snackbar.make(findViewById(android.R.id.content), "Por favor, revise su conexión a Internet", Snackbar.LENGTH_LONG).show();
            enviar.setEnabled(false);
        }

    }





}


