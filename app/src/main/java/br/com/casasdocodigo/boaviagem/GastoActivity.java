package br.com.casasdocodigo.boaviagem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.Calendar;

/**
 * Created by Lucas on 30/08/2015.
 */
public class GastoActivity extends Activity {

    private int ano, mes, dia;
    private Button dataGasto;
    private Spinner categoria;

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            dataGasto.setText(dia+"/"+(mes+1)+"/"+ano);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gasto);
        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        dataGasto = (Button)findViewById(R.id.data);
        dataGasto.setText(dia+"/"+(mes+1)+"/"+ano);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categoria_gasto,android.R.layout.simple_spinner_item);
        categoria = (Spinner)findViewById(R.id.categoria);
        categoria.setAdapter(adapter);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(R.id.data == id) {
            return new DatePickerDialog(this,listener,ano,mes,dia);
        }
        return null;
    }



    public void selecionarData(View view) {
        showDialog(view.getId());
    }
}