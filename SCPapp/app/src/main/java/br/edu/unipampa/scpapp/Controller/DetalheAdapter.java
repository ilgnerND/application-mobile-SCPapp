package br.edu.unipampa.scpapp.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.unipampa.scpapp.Model.Andamento;
import br.edu.unipampa.scpapp.R;

/**
 * Created by Sapo on 28/04/2017.
 */

public class DetalheAdapter extends ArrayAdapter<Andamento>  {


    private Context context;
    private List<Andamento> andamentos = null;

    public DetalheAdapter(Context context,  List<Andamento> andamentos) {
        super(context,0, andamentos);
        this.andamentos = andamentos;
        this.context = context;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Andamento andamento = andamentos.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.tela_detalhe_andamento, null);


        TextView ocorrencia = (TextView) view.findViewById(R.id.text_view_ocorrencia);
        ocorrencia.setText(andamento.getOcorrencia());
       // ocorrencia.setMovementMethod(new ScrollingMovementMethod());
       // ocorrencia.setFocusable(true);


      TextView despacho = (TextView) view.findViewById(R.id.text_view_despacho);
        despacho.setText(andamento.getDespacho());
       // despacho.setMovementMethod(new ScrollingMovementMethod());
       // despacho.setFocusable(true);

        return view;
    }
}
