package br.edu.unipampa.scpapp.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.unipampa.scpapp.Model.Processo;
import br.edu.unipampa.scpapp.R;


/**
 * Created by Joner Mello on 20/03/2017.
 */

/**
 * Classe que permite a criação de um adapter personalizado
 */
public class ProcessoAdapter extends ArrayAdapter<Processo> {

    private Context context;
    private List<Processo> processos = null;

    public ProcessoAdapter( Context context, List<Processo> processos ) {
        super(context,0, processos);
        this.processos = processos;
        this.context = context;
    }


    @Override
    public View getView(int position, View v, ViewGroup parent) {
        Processo processo = processos.get(position);

        if(v == null)
            v = LayoutInflater.from(context).inflate(R.layout.tela_de_processo, null);

        TextView numeroControle = (TextView) v.findViewById(R.id.recebeNumeroControle);
        numeroControle.setText(processo.getNum_controle());

        TextView numeroProcesso = (TextView) v.findViewById(R.id.recebeNumeroProcesso);
        numeroProcesso.setText(processo.getNum_proc());

        TextView data = (TextView) v.findViewById(R.id.recebeData);
        data.setText(processo.getData());

        TextView tipo = (TextView) v.findViewById(R.id.recebeTipo);
        tipo.setText(String.valueOf(processo.getTipo()));

        TextView departamento = (TextView) v.findViewById(R.id.recebeDepartamento);
        departamento.setText(String.valueOf(processo.getDepartamento()));

        TextView instituicao = (TextView) v.findViewById(R.id.recebeInstituicao);
        instituicao.setText(processo.getInstituicao());

        TextView requerente = (TextView) v.findViewById(R.id.recebeRequerente);
        requerente.setText(String.valueOf(processo.getRequerente()));

        TextView observacao = (TextView) v.findViewById(R.id.recebeObservacao);
        observacao.setText(processo.getObservacao());

        TextView nome = (TextView) v.findViewById(R.id.recebeNome);
        nome.setText(String.valueOf(processo.getNome()));

        TextView atendente= (TextView) v.findViewById(R.id.recebeAtendente);
        atendente.setText(String.valueOf(processo.getAtendente()));

        return v;
    }

}
