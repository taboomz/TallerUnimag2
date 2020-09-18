package co.edu.unimagdalena.apmoviles.tallerunimag2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText x1,y1,x2,y2;
    Button botonpm, botonpen, botonCuad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x1 = findViewById(R.id.edtX1);
        x2 = findViewById(R.id.edtX2);
        y1 = findViewById(R.id.edtY1);
        y2 = findViewById(R.id.edtY2);
        botonpm = findViewById(R.id.btnPuntoMedio);
        botonpen = findViewById(R.id.btnPendiente);
        botonCuad = findViewById(R.id.btnCuadrante);
        botonpm.setOnClickListener(this);
        botonpen.setOnClickListener(this);
        botonCuad.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.maleatorio:
                x1.setText(random() + "");
                x2.setText(random() + "");
                y1.setText(random() + "");
                y2.setText(random() + "");
                Toast.makeText(this,"Aleatorio", Toast.LENGTH_LONG).show();
                break;
            case R.id.mDistancia:
                if (TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString())
                        || TextUtils.isEmpty(y1.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Datos no validos", Toast.LENGTH_LONG).show();
                }
                else {
                    float x01 = Float.parseFloat(x1.getText().toString());
                    float x02 = Float.parseFloat(x2.getText().toString());
                    float y01 = Float.parseFloat(y1.getText().toString());
                    float y02 = Float.parseFloat(y2.getText().toString());
                    Toast.makeText(this,"Distancia = " + distancia(x01, x02, y01, y02), Toast.LENGTH_LONG).show();

                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString())
                || TextUtils.isEmpty(y1.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Datos no validos", Toast.LENGTH_LONG).show();
        }else {

            int cx1 = Integer.parseInt(x1.getText().toString());
            int cx2 = Integer.parseInt(x2.getText().toString());
            int cy1 = Integer.parseInt(y1.getText().toString());
            int cy2 = Integer.parseInt(y2.getText().toString());

            switch (v.getId()) {
                case R.id.btnPuntoMedio:
                    Toast.makeText(this, "Punto Medio = (" + ((cx1 + cx2) / 2) + "," + ((cy1 + cy2) / 2) + ")", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnPendiente:
                    Toast.makeText(this, "Pendiente = " + ((cy2 - cy1) / (cx2 - cx1)), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnCuadrante:
                    Toast.makeText(this,"Cuadrante" + CalCuadrante(cx1,cx2),Toast.LENGTH_LONG).show();
                    break;

            }

        }

    }

     public int random(){
            int menor = -50;
            int mayor = 50;
            final int r = (int) (Math.random() * (menor - mayor + 1) + mayor);
            return r;
        }

    public int distancia(float x1, float x2, float y1, float y2){
        return (int) Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
    }

    public int CalCuadrante(float a,float b){
        if (a == 0 || b == 0) return 0;
        else if (a > 0 && b > 0) return 1;
        else if (a < 0 && b > 0) return 2;
        else if (a < 0 && b < 0) return 3;
        else return 4;
    }




}