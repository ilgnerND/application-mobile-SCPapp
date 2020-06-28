package br.edu.unipampa.scpapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.edu.unipampa.scpapp.Model.Andamento;
import br.edu.unipampa.scpapp.Model.AndamentoRepository;
import br.edu.unipampa.scpapp.R;


public class DetalheAndamentoActivity extends AppCompatActivity  {
    ListView listViewDetalhes;
    AndamentoRepository andamentoRepository = new AndamentoRepository(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_andamento);
        setUpToolbar();

        /*CARREGA O MÉTODO DE CRIAÇÃO DOS COMPONENTES*/
        this.CriarComponentes();

        /*CARREGA A LISTA*/
        this.CarregaOpcoesLista();

        listViewDetalhes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
    //VINCULA O COMPONENTE DA TELA AO OBJETO DA  ATIVIDADE
    protected void CriarComponentes(){

        //VINCULANDO A LISTA DA TELA AO LISTVIEW
        listViewDetalhes = (ListView) this.findViewById(R.id.listViewDetalhes);
    }

    //CRIA A  LISTA E ADICIONA AO LISTVIEW DA TELA.
    protected  void CarregaOpcoesLista(){
        Intent itdetalhe = getIntent();
        String strDetalhe = itdetalhe.getStringExtra("DetalheID");
        listViewDetalhes = (ListView) this.findViewById(R.id.listViewDetalhes);
        List<Andamento> itens = andamentoRepository.listaDetalheAndamento(Integer.valueOf(strDetalhe));
        final DetalheAdapter detalheAdapter = new DetalheAdapter(this,  itens);
        listViewDetalhes.setAdapter(detalheAdapter);

    }
    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDetalhe);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
