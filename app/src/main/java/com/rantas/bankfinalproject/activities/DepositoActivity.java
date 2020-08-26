package com.rantas.bankfinalproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rantas.bankfinalproject.R;
import com.rantas.bankfinalproject.dao.AccountDao;
import com.rantas.bankfinalproject.dao.DepositoDao;
import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.Boleto;
import com.rantas.bankfinalproject.model.Deposit;
import com.rantas.bankfinalproject.model.InnerAccount;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.SetDeposit;

import static com.rantas.bankfinalproject.activities.MainActivity.HEADER_SHARED;

public class DepositoActivity extends AppCompatActivity {
    private Button btnDepositar;
    private Button confirmBtn;
    private String titular;
    private String cpf;
    private String numConta;
    private String pws;
    private EditText pass;
    private boolean checkPassOut;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito);

        preferences = getSharedPreferences(HEADER_SHARED, MODE_PRIVATE);
        this.titular = preferences.getString("nome", "");
        Log.d("nome", this.titular);
        this.cpf = preferences.getString("cpf", "");
        Log.d("cpf", this.cpf);
        this.numConta = preferences.getString("Nccorrente", "");
        Log.d("Nccorrente", this.numConta);
        this.pws = preferences.getString("pws", "");
        Log.d("pws", this.pws);

        Intent intent = getIntent();
        String action = intent.getStringExtra("deposito");

        TextView textView = findViewById(R.id.deposito);
        TextView textView1 = findViewById(R.id.conta);
        TextView textView2 = findViewById(R.id.titular);
        TextView textView3 = findViewById(R.id.cpf);

        textView.setText(action);
        textView1.setText(this.numConta);
        textView2.setText(this.titular);
        textView3.setText(this.cpf);

        this.confirmBtn = findViewById(R.id.confirma);
        this.btnDepositar = (Button) findViewById(R.id.btnDeposito);
        final LinearLayout layout = findViewById(R.id.layoutSenha);

        this.btnDepositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
                confirmBtn.setVisibility(View.VISIBLE);
                pass = findViewById(R.id.editPassword);
            }
        });


        this.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.mensagemcomprovante).setVisibility(View.VISIBLE);
                findViewById(R.id.comprovante).setVisibility(View.VISIBLE);
                EditText editText2 = findViewById(R.id.quantia);
                String valor = editText2.getText().toString();
                editText2.setVisibility(View.INVISIBLE);
                TextView confirmacao =findViewById(R.id.comprovante);

                boolean authorization = checkoutPass(pass, pws);

                DepositoDao depositoDao = new DepositoDao(getApplicationContext());
                depositoDao.depositar(valor,cpf,pws,authorization,numConta,confirmacao);

                findViewById(R.id.layoutSenha).setVisibility(View.INVISIBLE);
                findViewById(R.id.confirma).setVisibility(View.INVISIBLE);


            }
        });
    }

    private boolean checkoutPass(EditText editText, String pws){
        boolean recebeSenha=false;
        String senha = editText.getText().toString();
        if(pws.equals(senha)){
            recebeSenha =true;
        }
        return recebeSenha;
    }
}