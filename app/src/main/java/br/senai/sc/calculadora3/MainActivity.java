package br.senai.sc.calculadora3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView botao_0, botao_1,botao_2,botao_3,botao_4,botao_5,botao_6,botao_7,botao_8,
            botao_9,limpar,igual,ponto,voltar,adicao,subracao,multiplicacao,divisao;

    private TextView txtExpressao, txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        botao_0.setOnClickListener(this);
        botao_1.setOnClickListener(this);
        botao_2.setOnClickListener(this);
        botao_3.setOnClickListener(this);
        botao_4.setOnClickListener(this);
        botao_5.setOnClickListener(this);
        botao_6.setOnClickListener(this);
        botao_7.setOnClickListener(this);
        botao_8.setOnClickListener(this);
        botao_9.setOnClickListener(this);
        limpar.setOnClickListener(this);
        ponto.setOnClickListener(this);
        adicao.setOnClickListener(this);
        subracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;
                    if(resultado == (double)longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }

            }
        });



    }

    private void IniciarComponentes(){
        botao_0 = findViewById(R.id.botao_0);
        botao_1 = findViewById(R.id.botao_1);
        botao_2 = findViewById(R.id.botao_2);
        botao_3 = findViewById(R.id.botao_3);
        botao_4 = findViewById(R.id.botao_4);
        botao_5 = findViewById(R.id.botao_5);
        botao_6 = findViewById(R.id.botao_6);
        botao_7 = findViewById(R.id.botao_7);
        botao_8 = findViewById(R.id.botao_8);
        botao_9 = findViewById(R.id.botao_9);
        limpar = findViewById(R.id.limpar);
        igual = findViewById(R.id.igual);
        ponto = findViewById(R.id.ponto);
        voltar = findViewById(R.id.voltar);
        adicao = findViewById(R.id.adicao);
        subracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        txtExpressao = findViewById(R.id.expressao);
        txtResultado = findViewById(R.id.resultado);
    }

    public void  AcrescentarUmaExpressao(String string, boolean limpar_dados){
        if(txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if(limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botao_0:
                AcrescentarUmaExpressao("0", true);
                break;

            case R.id.botao_1:
                AcrescentarUmaExpressao("1", true);
                break;

            case R.id.botao_2:
                AcrescentarUmaExpressao("2", true);
                break;

            case R.id.botao_3:
                AcrescentarUmaExpressao("3", true);
                break;

            case R.id.botao_4:
                AcrescentarUmaExpressao("4", true);
                break;

            case R.id.botao_5:
                AcrescentarUmaExpressao("5", true);
                break;

            case R.id.botao_6:
                AcrescentarUmaExpressao("6", true);
                break;

            case R.id.botao_7:
                AcrescentarUmaExpressao("7", true);
                break;

            case R.id.botao_8:
                AcrescentarUmaExpressao("8", true);
                break;

            case R.id.botao_9:
                AcrescentarUmaExpressao("9", true);
                break;

            case R.id.ponto:
                AcrescentarUmaExpressao(".", true);
                break;

            case R.id.adicao:
                AcrescentarUmaExpressao("+", false);
                break;

            case R.id.subtracao:
                AcrescentarUmaExpressao("-", false);
                break;

            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;

            case R.id.divisao:
                AcrescentarUmaExpressao("/", false);
                break;
        }
    }
}