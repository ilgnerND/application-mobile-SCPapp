package br.edu.unipampa.scpapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.unipampa.scpapp.Model.Andamento;
import br.edu.unipampa.scpapp.Model.AndamentoRepository;
import br.edu.unipampa.scpapp.Model.Atendente;
import br.edu.unipampa.scpapp.Model.AtendenteDAO;
import br.edu.unipampa.scpapp.Model.Cidadao;
import br.edu.unipampa.scpapp.Model.CidadaoDAO;
import br.edu.unipampa.scpapp.Model.Departamento;
import br.edu.unipampa.scpapp.Model.DepartamentoDAO;
import br.edu.unipampa.scpapp.Model.Processo;
import br.edu.unipampa.scpapp.Model.ProcessoRepository;
import br.edu.unipampa.scpapp.Model.Tipo;
import br.edu.unipampa.scpapp.Model.TipoDAO;
import br.edu.unipampa.scpapp.R;

public class ProcessoActivity extends AppCompatActivity {

    TipoDAO tipoDAO = new TipoDAO(this);
    DepartamentoDAO departamentoDAO = new DepartamentoDAO(this);
    AtendenteDAO atendenteDAO = new AtendenteDAO(this);
    CidadaoDAO cidadaoDAO = new CidadaoDAO(this);
    ProcessoRepository processoRepository = new ProcessoRepository(this);
    AndamentoRepository andamentoRepository = new AndamentoRepository(this);
    List<Andamento> andamentoList = new ArrayList<>();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processo);
        setUpToolbar();
        Intent it = getIntent();
        String strProcesso = it.getStringExtra("processo");
        String strCpf = it.getStringExtra("cpf");



        Tipo tipo = new Tipo();
        tipo.setNome_tipo("IPTU");
        tipoDAO.insert(tipo);

        Tipo tipo2 = new Tipo();
        tipo2.setNome_tipo("ICMS");
        tipoDAO.insert(tipo2);

        Tipo tipo3 = new Tipo();
        tipo3.setNome_tipo("PIS");
        tipoDAO.insert(tipo3);

        Tipo tipo4 = new Tipo();
        tipo4.setNome_tipo("TESTE");
        tipoDAO.insert(tipo4);

        Departamento departamento = new Departamento();
        departamento.setNome_dep("Infra Estrutura");
        departamentoDAO.insert(departamento);

        Departamento departamento2 = new Departamento();
        departamento2.setNome_dep("Saude");
        departamentoDAO.insert(departamento2);

        Departamento departamento3 = new Departamento();
        departamento3.setNome_dep("Educaçao");
        departamentoDAO.insert(departamento3);

        Departamento departamento4 = new Departamento();
        departamento4.setNome_dep("Teste");
        departamentoDAO.insert(departamento4);

        Atendente atendente = new Atendente();
        atendente.setNome_atendente("Paulo");
        atendenteDAO.insert(atendente);

        Atendente atendente2 = new Atendente();
        atendente2.setNome_atendente("Fulano");
        atendenteDAO.insert(atendente2);

        Atendente atendente3 = new Atendente();
        atendente3.setNome_atendente("Teste");
        atendenteDAO.insert(atendente3);

        Cidadao cidadao = new Cidadao();
        cidadao.setNome_cidadao("Joner Mello");
        cidadao.setCpf_Cidadao("22222222222");
        cidadao.setCnpj_cidadao("");
        cidadaoDAO.insert(cidadao);

        Cidadao cidadao1 = new Cidadao();
        cidadao1.setNome_cidadao("Pedro");
        cidadao1.setCpf_Cidadao("");
        cidadao1.setCnpj_cidadao("57702321000155");
        cidadaoDAO.insert(cidadao1);

        Cidadao cidadao2 = new Cidadao();
        cidadao2.setNome_cidadao("Paulo");
        cidadao2.setCpf_Cidadao("33333333333");
        cidadao2.setCnpj_cidadao("");
        cidadaoDAO.insert(cidadao2);

        Cidadao cidadao3 = new Cidadao();
        cidadao3.setNome_cidadao("Maria");
        cidadao3.setCpf_Cidadao("");
        cidadao3.setCnpj_cidadao("37358740000104");
        cidadaoDAO.insert(cidadao3);

        //_____insere 4 processos


        Processo processo = new Processo();
        processo.setNum_proc("123456");
        processo.setNum_controle("123456");
        processo.setData("10/10/2010 22:15");
        processo.setTipo("2");
        processo.setDepartamento("2");
        processo.setInstituicao("Prefeitura");
        processo.setRequerente("2");
        processo.setObservacao("O acusador não tinha moral para acusá-lo");
        processo.setNome("2");
        processo.setAtendente("2");

        processoRepository.insert(processo);

        Processo processo1 = new Processo();
        processo1.setNum_proc("1234567");
        processo1.setNum_controle("1234567");
        processo1.setData("11/10/2011 22:15");
        processo1.setTipo("1");
        processo1.setDepartamento("2");
        processo1.setInstituicao("Prefeitura");
        processo1.setRequerente("3");
        processo1.setObservacao("Testecpf2");
        processo1.setNome("2");
        processo1.setAtendente("1");
        processoRepository.insert(processo1);

        Processo processo2 = new Processo();
        processo2.setNum_proc("12345678");
        processo2.setNum_controle("12345678");
        processo2.setData("10/09/2017 22:15");
        processo2.setTipo("1");
        processo2.setDepartamento("1");
        processo2.setInstituicao("Prefeitura");
        processo2.setRequerente("1");
        processo2.setObservacao("Teste3");
        processo2.setNome("3");
        processo2.setAtendente("1");
        processoRepository.insert(processo2);


        Processo processo3 = new Processo();
        processo3.setNum_proc("123456789");
        processo3.setNum_controle("123456789");
        processo3.setData("12/12/2016 12:15");
        processo3.setTipo("1");
        processo3.setDepartamento("1");
        processo3.setInstituicao("Prefeitura");
        processo3.setRequerente("1");
        processo3.setObservacao("Teste");
        processo3.setNome("1");
        processo3.setAtendente("1");
        processoRepository.insert(processo3);

        Andamento andamento = new Andamento();
        andamento.setDepartamento("1");
        andamento.setProcesso("1");
        andamento.setData("05/04/2016");
        andamento.setOcorrencia("Processo Criado");
        andamento.setDespacho("Tramite inicial");
        andamentoRepository.insert(andamento);

        Andamento andamento2 = new Andamento();
        andamento2.setDepartamento("2");
        andamento2.setProcesso("1");
        andamento2.setData("07/09/2016");
        andamento2.setOcorrencia("Processo finalizado");
        andamento2.setDespacho("Tramite ");
        andamentoRepository.insert(andamento2);

        Andamento andamento3 = new Andamento();
        andamento3.setDepartamento("2");
        andamento3.setProcesso("2");
        andamento3.setData("10/08/2017");
        andamento3.setOcorrencia("Processo Em Andamento");
        andamento3.setDespacho("Encaminhado");
        andamentoRepository.insert(andamento3);

        Andamento andamento4 = new Andamento();
        andamento4.setDepartamento("3");
        andamento4.setProcesso("2");
        andamento4.setData("01/01/2016");
        andamento4.setOcorrencia("Concluido");
        andamento4.setDespacho("Concluido");
        andamentoRepository.insert(andamento4);

        Andamento andamento5 = new Andamento();
        andamento5.setDepartamento("3");
        andamento5.setProcesso("2");
        andamento5.setData("09/09/2014");

        andamento5.setOcorrencia("Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a," +
                " posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. " +
                "Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, " +
                "tincidunt ac, pede. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam," +
                " tempor suscipit diam nulla vel leo. Etiam commodo dui eget wisi. Donec iaculis gravida nulla." +
                " Donec quis nibh at felis congue commodo. Etiam bibendum elit eget erat. Morbi a metus. " +
                " Donec quis nibh at felis congue commodo. Etiam bibendum elit eget erat. Morbi a metus. " +
                " Donec quis nibh at felis congue commodo. Etiam bibendum elit eget erat. Morbi a metus. " +
                " Donec quis nibh at felis congue commodo. Etiam bibendum elit eget erat. Morbi a metus. " +
                "Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit.");

        andamento5.setDespacho("Morbi a metus. Phasellus enim erat, vestibulum vel, aliquam a," +
                " posuere eu, velit. Nullam sapien sem, ornare ac, nonummy non, lobortis a, enim. " +
                "Nunc tincidunt ante vitae massa. Duis ante orci, molestie vitae, vehicula venenatis, " +
                "tincidunt ac, pede.  ");

        andamentoRepository.insert(andamento5);

        if (strCpf.length() == 11) {

            if (processoRepository.existeProcessoCpf(strProcesso, strCpf)) {
                processo = this.processoRepository.buscaProcessoNumeroCpf(strProcesso, strCpf);
                ProcessoRepository processoRepository = new ProcessoRepository(this);
                List<Processo> list = processoRepository.mostraProcesso(processo);
                ListView listView = (ListView)findViewById(R.id.listViewProcesso);
                listView.setAdapter(new ProcessoAdapter(this, processoRepository.mostraProcesso(processo)));
            } else {
                //Quando não encontar o registro
                Toast.makeText(ProcessoActivity.this, "Não foi encontrado o processo solicitado.", Toast.LENGTH_LONG).show();
                super.onBackPressed();//aciona o botão voltar
            }
        }
        if (strCpf.length() == 14) {
            if (processoRepository.existeProcessoCnpj(strProcesso, strCpf)) {
                processo = this.processoRepository.buscaProcessoNumeroCnpj(strProcesso, strCpf);
                ProcessoRepository processoRepository = new ProcessoRepository(this);
                List<Processo> list = processoRepository.mostraProcesso(processo);

                // O mesmos que ListView listView = getListView();
                ListView listView = (ListView)findViewById(R.id.listViewProcesso);

                //O mesmo que setListAdapter(new DespesaAdapter(this,list,listView));
                listView.setAdapter(new ProcessoAdapter(this, processoRepository.mostraProcesso(processo)));
                // setListAdapter(new ProcessoAdapter(this, processoRepository.mostraProcesso(processo)));
            } else {
                //Quando não encontar o registro
                Toast.makeText(ProcessoActivity.this, "Não foi encontrado o processo solicitado.", Toast.LENGTH_LONG).show();
                super.onBackPressed();//aciona o botão voltar
            }
        }

    }
    //toolbar voltar
    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProcesso);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void BTandamento(View view) {

        Intent it = getIntent();
        String strProcesso = it.getStringExtra("processo");
        if (andamentoRepository.existeAndamento(strProcesso)) {
            try {
                Intent intent = new Intent(ProcessoActivity.this, AndamentoActivity.class);
                intent.putExtra("processo",strProcesso);
                startActivity(intent);

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            //Quando não encontar o registro
            Toast.makeText(ProcessoActivity.this, "Processo sem andamento.", Toast.LENGTH_LONG).show();

        }


    }




}
