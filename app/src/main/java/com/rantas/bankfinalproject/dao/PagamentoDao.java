package com.rantas.bankfinalproject.dao;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rantas.bankfinalproject.model.BankSlip;
import com.rantas.bankfinalproject.model.Extrato;
import com.rantas.bankfinalproject.model.InnerAccount;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.SetPayment;

public class PagamentoDao {
    private Context context;

    public PagamentoDao(Context context) {
        this.context = context;
    }

    public void pagar(boolean authorization, String numConta, String cpf, String pws, String valor,String nBoleto, final TextView comprovante,
                      final TextView titulo){
        int amount = Integer.parseInt(valor);

        if (authorization == true) {
            User user = new User();
            InnerAccount innerAccount = new InnerAccount();
            innerAccount.setCode(numConta);
            innerAccount.setUser(user);
            innerAccount.getUser().setCpf(cpf);
            innerAccount.getUser().setPws(pws);

            BankSlip boleto = new BankSlip();
            boleto.setBoleto(nBoleto);
            boleto.setAmount(amount);

            SetPayment payment = new SetPayment();

            payment.setPayment(new RequestResult() {
                @Override
                public <T> void successful(T result) {
                    Extrato pagamento = (Extrato)result;

                    comprovante.setText(pagamento.toString());
                    titulo.setVisibility(View.VISIBLE);
                    comprovante.setVisibility(View.VISIBLE);
                    Log.d("COMPROVANTE",pagamento.toString());
                    Toast.makeText(context,"Pagamento Efetuado com Sucesso.",Toast.LENGTH_LONG).show();
                }

                @Override
                public void failureMessage(Messenger messenger) {
                    Toast.makeText(context, messenger.getFailureMessage() +
                            " code: " + String.valueOf(messenger.getErrorCode()), Toast.LENGTH_LONG).show();
                    Log.d("FALHA",messenger.getFailureMessage() +
                            " code: " + String.valueOf(messenger.getErrorCode()));
                }
            }, innerAccount, boleto);

        }else {
            Toast.makeText(context, "Senha não Confere!", Toast.LENGTH_LONG).show();
        }

        }
}
