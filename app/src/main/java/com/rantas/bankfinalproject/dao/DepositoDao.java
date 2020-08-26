package com.rantas.bankfinalproject.dao;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rantas.bankfinalproject.R;
import com.rantas.bankfinalproject.activities.DepositoActivity;
import com.rantas.bankfinalproject.model.Boleto;
import com.rantas.bankfinalproject.model.Deposit;
import com.rantas.bankfinalproject.model.InnerAccount;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.SetDeposit;

public class DepositoDao {

    private Context context;

    public DepositoDao(Context context) {
        this.context = context;
    }

    public void depositar(final String valor,final String cpf,final String pws,final boolean authorization,
                          final String numConta,final TextView confirmacao){


        if(authorization==true){
            User user = new User();
            InnerAccount innerAccount = new InnerAccount();
            innerAccount.setCode(numConta);
            innerAccount.setUser(user);
            innerAccount.getUser().setCpf(cpf);
            innerAccount.getUser().setPws(pws);

            int amount = Integer.parseInt(valor);

            Deposit deposit = new Deposit();
            deposit.setAmount(amount);

            SetDeposit setDeposit = new SetDeposit();
            setDeposit.doBankDeposit(new RequestResult() {
                @Override
                public <T> void successful(T result) {
                    Boleto comprovante = (Boleto)result;
                    confirmacao.setText(comprovante.toString());
                    Toast.makeText(context,"Depósito Efetuado com sucesso.",Toast.LENGTH_LONG).show();
                }

                @Override
                public void failureMessage(Messenger messenger) {
                    Toast.makeText(context, messenger.getFailureMessage() +
                            " code: " + String.valueOf(messenger.getErrorCode()), Toast.LENGTH_LONG).show();
                    Log.d("FALHA",messenger.getFailureMessage() +
                            " code: " + String.valueOf(messenger.getErrorCode()));                        }
            }, innerAccount, deposit);


        }else {
            Toast.makeText(context, "Senha não Confere!", Toast.LENGTH_LONG).show();
        }

    }
}
