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
import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.dao.TransfereDao;
import com.rantas.bankfinalproject.model.DataTransference;
import com.rantas.bankfinalproject.model.TranfComprovante;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.SetTransference;

import static com.rantas.bankfinalproject.activities.MainActivity.HEADER_SHARED;

public class TransferActivity extends AppCompatActivity {
    private Button btnTransferir;
    private Button confirmBtn;
    private String titular;
    private String cpf;
    private String numConta;
    private String pws;
    private EditText pass;
    private boolean checkPassOut;
    private String origemConta;
    private String destinoConta;
    private String valor;
    private TextView titulo;
    private TextView comprovante;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);


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
        String action = intent.getStringExtra("transferencia");

        TextView textView = findViewById(R.id.transferencia);
        TextView textView1 = findViewById(R.id.conta);
        TextView textView2 = findViewById(R.id.titular);
        TextView textView3 = findViewById(R.id.cpf);

        textView.setText(action);
        textView1.setText(this.numConta);
        textView2.setText(this.titular);
        textView3.setText(this.cpf);

        this.confirmBtn = findViewById(R.id.confirma);
        this.btnTransferir = (Button) findViewById(R.id.btnTransfere);

        final LinearLayout layout = findViewById(R.id.layoutSenha);
        pass = findViewById(R.id.editPassword);

        final TextView textView4 = findViewById(R.id.inputcontOrigem);
        textView4.setText(numConta);
        final EditText editText2 = findViewById(R.id.inputcontDestino);
        final EditText editText3 = findViewById(R.id.inputvalor);

        this.btnTransferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
                confirmBtn.setVisibility(View.VISIBLE);
            }
        });


        this.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo =findViewById(R.id.mensagemcomprovante);
                comprovante = findViewById(R.id.comprovante);
                origemConta= textView4.getText().toString();
                destinoConta  = editText2.getText().toString();
                valor= editText3.getText().toString();
                TransfereDao transfereDao = new TransfereDao(getApplicationContext());
                checkPassOut=checkoutPass(pass,pws);
                transfereDao.transfere(cpf,pws,checkPassOut,origemConta,destinoConta,valor,titulo,comprovante);
                findViewById(R.id.inputcontOrigem).setVisibility(View.INVISIBLE);
                findViewById(R.id.inputcontDestino).setVisibility(View.INVISIBLE);
                findViewById(R.id.inputvalor).setVisibility(View.INVISIBLE);
                findViewById(R.id.confirma).setVisibility(View.INVISIBLE);
                findViewById(R.id.btnTransfere).setVisibility(View.INVISIBLE);
                findViewById(R.id.layoutSenha).setVisibility(View.INVISIBLE);

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