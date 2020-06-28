package br.edu.unipampa.scpapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import br.edu.unipampa.scpapp.Controller.ProcessoActivity;
import br.edu.unipampa.scpapp.Model.ProcessoRepository;
import br.edu.unipampa.scpapp.View.MascaraEntrada;
import br.edu.unipampa.scpapp.View.Validacao;


public class MainActivity extends AppCompatActivity {
    private TextWatcher cpfMask;
    private TextWatcher cnpjMask,processoMask;
    private RadioGroup radioGroup;
    private RadioButton rdCNPJ;
    private Context context;
    ProcessoRepository processoRepository = new ProcessoRepository(this);
    public static final String PREFS_NAME = "Preferences";
    EditText etNumCont;
    EditText etCpfCnpj;
    CheckBox etCheck;
    RadioButton etRdCNPJ;
    RadioButton etRdCPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        //Atribui uma mascara de CPF ao campo id.campo_cpf

        final EditText cpf = (EditText) findViewById(R.id.campo_cpf);
        final EditText campo_cont_processo = (EditText) findViewById(R.id.campo_cont_processo);
        // Armazene seus TextWatcher para posterior uso
        cpfMask = MascaraEntrada.insert("###.###.###-##", cpf);
        cpf.addTextChangedListener(cpfMask);

        cnpjMask = MascaraEntrada.insert("##.###.###/####-##", cpf);
        rdCNPJ = (RadioButton) findViewById(R.id.rdCNPJ);

        processoMask = MascaraEntrada.insert("##############", campo_cont_processo);
        campo_cont_processo.addTextChangedListener(processoMask);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        Button acessarProcesso = (Button) findViewById(R.id.btpesquisar);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int opcao = radioGroup.getCheckedRadioButtonId();
                if (opcao == rdCNPJ.getId()) {
                    cpf.removeTextChangedListener(cpfMask);
                    cpf.addTextChangedListener(cnpjMask);
                } else {
                    cpf.removeTextChangedListener(cnpjMask);
                    cpf.addTextChangedListener(cpfMask);
                }
            }
        });

        acessarProcesso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    Validacao.validateNotNull(cpf, "Preencha o campo Com CPF ou CNPJ");
                    Validacao.validateNotNull(campo_cont_processo, "Preencha o campo Processo");
                    boolean cpf_valido = Validacao.validateCPF(cpf.getText().toString());
                    boolean cnpj_valido = Validacao.isValidCNPJ(cpf.getText().toString());

                    int opcao = radioGroup.getCheckedRadioButtonId();
                    if (opcao == rdCNPJ.getId()) {
                        if (!cnpj_valido) {

                            cpf.setError("CNPJ inválido");
                            cpf.setFocusable(true);
                            cpf.requestFocus();
                        }else
                        {
                            //  Log.e("nunprocesso",campo_cont_processo.getText().toString());
                            Intent it = new Intent(MainActivity.this, ProcessoActivity.class);
                            it.putExtra("cpf",MascaraEntrada.desmascarar(cpf.getText().toString()));
                            it.putExtra("processo",MascaraEntrada.desmascarar(campo_cont_processo.getText().toString()));
                            startActivity(it);

                        }
                    } else {
                        if (!cpf_valido) {
                            cpf.setError("CPF inválido");
                            cpf.setFocusable(true);
                            cpf.requestFocus();
                        }

                        else
                        {

                            Log.e("nunprocesso",campo_cont_processo.getText().toString());

                            Intent it = new Intent(MainActivity.this, ProcessoActivity.class);
                            it.putExtra("cpf",MascaraEntrada.desmascarar(cpf.getText().toString()));
                            it.putExtra("processo",MascaraEntrada.desmascarar(campo_cont_processo.getText().toString()));
                            startActivity(it);

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        //para salvar dados
        etRdCNPJ = (RadioButton) findViewById(R.id.rdCNPJ);
        etRdCPF = (RadioButton) findViewById(R.id.rdCPF);

        etNumCont = (EditText) findViewById(R.id.campo_cont_processo);
        etCpfCnpj = (EditText) findViewById(R.id.campo_cpf);
        etCheck = (CheckBox) findViewById(R.id.chkSalvar);

        //Restaura as preferencias gravadas
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        Log.e("AAA", settings.getAll().toString());
        Log.e("BBB", String.valueOf(settings.getBoolean("PrefIsCNPJ",false)));
        if (settings.getBoolean("PrefCheckSalvar", false)){
            if (settings.getBoolean("PrefIsCPF",false))
                etRdCPF.setChecked(true);

            if (settings.getBoolean("PrefIsCNPJ",false))
                etRdCNPJ.setChecked(true);

            etCheck.setChecked (settings.getBoolean("PrefCheckSalvar", false));
            etNumCont.setText(settings.getString("PrefNumCont", ""));
            etCpfCnpj.setText(settings.getString("PrefCpfCnpj", ""));
        }

    }
    /**
     * Chamado quando a Activity é encerrada
     */
    @Override
    protected void onStop(){
        super.onStop();

        //Caso o checkbox esteja marcado é gravado número de controle e cpf/cnpj
        CheckBox chkSalvar = (CheckBox)findViewById(R.id.chkSalvar);
        if (chkSalvar.isChecked()){

            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("PrefIsCNPJ", etRdCNPJ.isChecked());
            editor.putBoolean("PrefIsCPF",etRdCPF.isChecked());

            editor.putString("PrefNumCont", etNumCont.getText().toString());
            editor.putString("PrefCpfCnpj", etCpfCnpj.getText().toString());
            editor.putBoolean("PrefCheckSalvar",chkSalvar.isChecked());
            //Confirma a gravação dos dados
            editor.commit();
        }else{
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("PrefIsCNPJ", etRdCNPJ.isChecked());
            editor.putBoolean("PrefIsCPF",etRdCPF.isChecked());
            editor.putString("PrefNumCont","");
            editor.putString("PrefCpfCnpj","");
            editor.putBoolean("PrefCheckSalvar",false);
            //Confirma a gravação dos dados
            editor.commit();
        }
    }

}






