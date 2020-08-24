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
import com.rantas.bankfinalproject.model.InnerAccount;
import com.rantas.bankfinalproject.model.Extrato;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.SetPayment;

import static com.rantas.bankfinalproject.MainActivity.HEADER_SHARED;

public class PagamentoActivity extends AppCompatActivity {

    private Button confirmBtn;
    private String titular;
    private String cpf;
    private String numConta;
    private String pws;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagamento_layout);

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
        String action = intent.getStringExtra("pagamento");

        TextView textView = findViewById(R.id.pagamento);
        TextView textView1 = findViewById(R.id.conta);
        TextView textView2 = findViewById(R.id.titular);
        TextView textView3 = findViewById(R.id.cpf);

        textView.setText(action);
        textView1.setText(this.numConta);
        textView2.setText(this.titular);
        textView3.setText(this.cpf);

        this.confirmBtn = findViewById(R.id.confirma);
        final Button btnPagar = (Button) findViewById(R.id.btnPagar);
        final LinearLayout layout = findViewById(R.id.layoutSenha);
        btnPagar.setOnClickListener(new View.OnClickListener() {
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
                if (authorization == true) {
                    User user = new User();
                    InnerAccount innerAccount = new InnerAccount();
                    innerAccount.setCode(numConta);
                    innerAccount.setUser(user);
                    innerAccount.getUser().setCpf(cpf);
                    innerAccount.getUser().setPws(pws);

                    EditText editText1 = findViewById(R.id.boleto);
                    EditText editText2 = findViewById(R.id.quantia);
                    String nBoleto = editText1.getText().toString();
                    String valor = editText2.getText().toString();
                    int amount = Integer.parseInt(valor);
                    BankSlip boleto = new BankSlip();
                    boleto.setBoleto(nBoleto);
                    boleto.setAmount(amount);

                    editText1.setVisibility(View.INVISIBLE);
                    editText2.setVisibility(View.INVISIBLE);

                    SetPayment payment = new SetPayment();

                    payment.setPayment(new RequestResult() {
                        @Override
                        public <T> void successful(T result) {
                            Extrato pagamento = (Extrato)result;
                            TextView titulo = findViewById(R.id.mensagemcomprovante);
                            TextView comprovante = findViewById(R.id.comprovante);
                            comprovante.setText(pagamento.toString());
                            titulo.setVisibility(View.VISIBLE);
                            comprovante.setVisibility(View.VISIBLE);
                            Log.d("COMPROVANTE",pagamento.toString());
                            Toast.makeText(PagamentoActivity.this,"Pagamento Efetuado com Sucesso.",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void failureMessage(Messenger messenger) {
                            Toast.makeText(PagamentoActivity.this, messenger.getFailureMessage() +
                                    " code: " + String.valueOf(messenger.getErrorCode()), Toast.LENGTH_LONG).show();
                            Log.d("FALHA",messenger.getFailureMessage() +
                                    " code: " + String.valueOf(messenger.getErrorCode()));
                        }
                    }, innerAccount, boleto);

                } else {
                    Toast.makeText(PagamentoActivity.this, "Senha não Confere!", Toast.LENGTH_LONG).show();
                }

                findViewById(R.id.textBoleto).setVisibility(View.INVISIBLE);
                findViewById(R.id.textquantia).setVisibility(View.INVISIBLE);
                layout.setVisibility(View.INVISIBLE);
                confirmBtn.setVisibility(View.INVISIBLE);

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