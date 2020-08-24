package com.rantas.bankfinalproject;

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

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.BankSlip;
import com.rantas.bankfinalproject.model.DataTransference;
import com.rantas.bankfinalproject.model.Extrato;
import com.rantas.bankfinalproject.model.InnerAccount;
import com.rantas.bankfinalproject.model.TranfComprovante;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.SetTransference;

import static com.rantas.bankfinalproject.MainActivity.HEADER_SHARED;

public class TransferActivity extends AppCompatActivity {
    private Button btnTransferir;
    private Button confirmBtn;
    private String titular;
    private String cpf;
    private String numConta;
    private String pws;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);


        SharedPreferences preferences = getSharedPreferences(HEADER_SHARED, MODE_PRIVATE);
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

        this.btnTransferir.setOnClickListener(new View.OnClickListener() {
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
                boolean authorization = checkoutPass(pass, pws);
                if(authorization==true){
                    User user = new User();
                    user.setCpf(cpf);
                    user.setPws(pws);

                    DataTransference data = new DataTransference();

                    EditText editText1 = findViewById(R.id.inputcontOrigem);
                    EditText editText2 = findViewById(R.id.inputcontDestino);
                    EditText editText3 = findViewById(R.id.inputvalor);
                    String origemConta = editText1.getText().toString();
                    String destinoConta = editText2.getText().toString();
                    String valor = editText3.getText().toString();
                    int amount = Integer.parseInt(valor);
                    data.setOrigem(origemConta);
                    data.setDestino(destinoConta);
                    data.setAmount(amount);

                    editText1.setVisibility(View.INVISIBLE);
                    editText2.setVisibility(View.INVISIBLE);
                    editText3.setVisibility(View.INVISIBLE);

                    SetTransference transference = new SetTransference();

                    transference.doMoneyTransference(new RequestResult() {
                        @Override
                        public <T> void successful(T result) {
                            TranfComprovante tranfComprovante = (TranfComprovante)result;
                            TextView titulo = findViewById(R.id.mensagemcomprovante);
                            TextView comprovante = findViewById(R.id.comprovante);
                            comprovante.setText(tranfComprovante.toString());
                            titulo.setVisibility(View.VISIBLE);
                            comprovante.setVisibility(View.VISIBLE);
                            Log.d("TRANSFERENCIA",tranfComprovante.toString());
                            Toast.makeText(TransferActivity.this,"Transferencia Efetuada com Sucesso.",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void failureMessage(Messenger messenger) {
                            Toast.makeText(TransferActivity.this, messenger.getFailureMessage() +
                                    " code: " + String.valueOf(messenger.getErrorCode()), Toast.LENGTH_LONG).show();
                            Log.d("FALHA",messenger.getFailureMessage() +
                                    " code: " + String.valueOf(messenger.getErrorCode()));

                        }
                    },user,data);

                }else {
                    Toast.makeText(TransferActivity.this, "Senha não Confere!", Toast.LENGTH_LONG).show();
                }
                findViewById(R.id.textcontOrigem).setVisibility(View.INVISIBLE);
                findViewById(R.id.textcontDestino).setVisibility(View.INVISIBLE);
                findViewById(R.id.textvalor).setVisibility(View.INVISIBLE);
                layout.setVisibility(View.INVISIBLE);
                confirmBtn.setVisibility(View.INVISIBLE);
                btnTransferir.setVisibility(View.INVISIBLE);

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