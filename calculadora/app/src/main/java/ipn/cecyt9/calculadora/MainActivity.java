package ipn.cecyt9.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Double numero1,numero2,resultado;
    String operador;

    public void onClickButtonUno(View miView)//cuando se presiona el boton numero uno
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"1");//set: mete el nuevo valor de (get: el valor actual de esa vista más 1)
    }
    public void onClickButtonDos(View miView)//cuando se presiona el boton numero dos
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"2");//set: mete el nuevo valor de (get: el valor actual de esa vista más 2)
    }
    public void onClickButtonTres(View miView)//cuando se presiona el boton numero tres
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"3");//set: mete el nuevo valor de (get: el valor actual de esa vista más 3)
    }
    public void onClickButtonCuatro(View miView)//cuando se presiona el boton numero cuatro
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"4");//set: mete el nuevo valor de (get: el valor actual de esa vista más 4)
    }
    public void onClickButtonCinco(View miView)//cuando se presiona el boton numero cinco
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"5");//set: mete el nuevo valor de (get: el valor actual de esa vista más 5)
    }
    public void onClickButtonSeis(View miView)//cuando se presiona el boton numero seis
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"6");//set: mete el nuevo valor de (get: el valor actual de esa vista más 6)
    }
    public void onClickButtonSiete(View miView)//cuando se presiona el boton numero siete
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"7");//set: mete el nuevo valor de (get: el valor actual de esa vista más 7)
    }
    public void onClickButtonOcho(View miView)//cuando se presiona el boton numero ocho
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"8");//set: mete el nuevo valor de (get: el valor actual de esa vista más 8)
    }
    public void onClickButtonNueve(View miView)//cuando se presiona el boton numero nueve
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"9");//set: mete el nuevo valor de (get: el valor actual de esa vista más 9)
    }
    public void onClickButtonCero(View miView)//cuando se presiona el boton numero cero
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero); // se obtiene el valor de ese boton, obteniendo un objeto del textview
        tv.setText(tv.getText()+"0");//set: mete el nuevo valor de (get: el valor actual de esa vista más 0)
    }
    public void onClickOperacionCapturaNumero1(View miView)// en este metodo se le asigna el valor a numero1 del textview en double y vaciando el textview
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero);
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }
    public void onClickSuma(View miView)//se da una operación que se ocupa en igual y ejecuta el metodo anterior
    {
        operador= "+";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickResta(View miView)//se da una operación que se ocupa en igual y ejecuta el metodo anterior
    {
        operador= "-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickDivision(View miView)//se da una operación que se ocupa en igual y ejecuta el metodo anterior
    {
        operador= "/";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClicMultiplicacion(View miView)//se da una operación que se ocupa en igual y ejecuta el metodo anterior
    {
        operador= "*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickIgual(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero);
        numero2 = Double.parseDouble(tv.getText().toString());
        try {
            if(operador.equals("+")){
                resultado = numero1 + numero2;
            }else if(operador.equals("-")){
                resultado = numero1 - numero2;
            }else if (operador.equals("/")){
                resultado = numero1 / numero2;
            }else if(operador.equals("*")){
                resultado = numero1 * numero2;
            }
            tv.setText(resultado.toString());
        }catch(NumberFormatException nfe){
            Toast.makeText(this,"Numero Incorrecto",Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickLimpia(View miView){
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.textViewNumero);
        tv.setText("");
    }

}