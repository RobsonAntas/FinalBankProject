package com.rantas.bankfinalproject.dao;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rantas.bankfinalproject.R;
import com.rantas.bankfinalproject.activities.TransferActivity;
import com.rantas.bankfinalproject.model.DataTransference;
import com.rantas.bankfinalproject.model.TranfComprovante;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.SetTransference;

public class TransfereDao {
    private Context context;

    public TransfereDao(Context context) {
        this.context =context;
    }



    public void transfere(final String cpf,final String pws,final boolean authorization,String origemConta, String destinoConta,
                          String valor,final TextView titulo,final TextView comprovante){
        final int amount = Integer.parseInt(valor);

        if(authorization==true){
            User user = new User();
            user.setCpf(cpf);
            user.setPws(pws);

            DataTransference data = new DataTransference();
            data.setOrigem(origemConta);
            data.setDestino(destinoConta);
            data.setAmount(amount);

            SetTransference transference = new SetTransference();

            transference.doMoneyTransference(new RequestResult() {
                @Override
                public <T> void successful(T result) {
                    TranfComprovante tranfComprovante = (TranfComprovante)result;
                    titulo.setVisibility(View.VISIBLE);
                    comprovante.setVisibility(View.VISIBLE);
                    comprovante.setText(tranfComprovante.toString());
                    Log.d("TRANSFERENCIA",tranfComprovante.toString());

                    Toast.makeText(context,"Transferencia Efetuada com Sucesso.",Toast.LENGTH_LONG).show();

                }

                @Override
                public void failureMessage(Messenger messenger) {
                    Toast.makeText(context, messenger.getFailureMessage() +
                            " code: " + String.valueOf(messenger.getErrorCode()), Toast.LENGTH_LONG).show();
                    Log.d("FALHA",messenger.getFailureMessage() +
                            " code: " + String.valueOf(messenger.getErrorCode()));

                }
            },user,data);

        }else {
            Toast.makeText(context, "Senha não Confere!", Toast.LENGTH_LONG).show();
        }

    }
}
