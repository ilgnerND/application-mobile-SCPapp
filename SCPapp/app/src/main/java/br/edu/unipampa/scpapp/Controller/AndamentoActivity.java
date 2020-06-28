package br.edu.unipampa.scpapp.Controller;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import br.edu.unipampa.scpapp.Model.Andamento;
import br.edu.unipampa.scpapp.Model.AndamentoRepository;
import br.edu.unipampa.scpapp.Model.Processo;
import br.edu.unipampa.scpapp.Model.ProcessoRepository;
import br.edu.unipampa.scpapp.R;


public class AndamentoActivity extends AppCompatActivity {
    private File dir;
    private ListView listViewOpcoes;
    private ProgressDialog dialog;
    AndamentoRepository andamentoRepository = new AndamentoRepository(this);
    ProcessoRepository processoRepository = new ProcessoRepository(this);
    private Processo processo;
    private Image imageSIC;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andamento);
        setUpToolbar();
        this.verificaPermissao(this);

        /*CARREGA O MÉTODO DE CRIAÇÃO DOS COMPONENTES*/
        this.CriarComponentes();

        /*CARREGA AS OPÇÕES DA LISTA*/
        this.CarregaOpcoesLista();




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                /*Snackbar.make(view, "Aguarde Um Instante", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                dialog = ProgressDialog.show(AndamentoActivity.this,"Carregando os Andamentos!","Gerando Arquivo Aguarde !!", true,true);
               // dialog.setIcon(R.drawable.e_cidade_logo);
                dialog.setCancelable(false);

                new Thread() {

                    public void run() {

                        try {
                            gerarPdf();
                            Thread.sleep(7000);
                            dialog.dismiss();
                        }catch (Exception e) {

                        }
                    }
                }.start();

            }
        });

//captura o id do andamento e passa para detelhes Activity
        listViewOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Andamento andamento = (Andamento) listViewOpcoes.getItemAtPosition(position);
                String Detalheid = String.valueOf(andamento.getId_anda());
                Intent itdetalhe = new Intent(AndamentoActivity.this, DetalheAndamentoActivity.class);

                // set no intent o id ou a position do item selecionado
                itdetalhe.putExtra("DetalheID",Detalheid);
//                intent.putExtra("POSITION", position);
                startActivity(itdetalhe);
               Log.e("Detalhe envio ID",Detalheid );

            }
        });
    }


    //VINCULA O COMPONENTE DA NOSSA TELA AO OBJETO DA NOSSA ATIVIDADE
    protected void CriarComponentes(){

        //VINCULANDO A LISTA DA TELA AO LISTVIEW QUE DECLARAMOS
        listViewOpcoes = (ListView) this.findViewById(R.id.listViewOpcoes);
    }

    //CRIA A OPÇÕES DA NOSSA LISTA E ADICIONA AO LISTVIEW DA NOSSA TELA.
    protected  void CarregaOpcoesLista(){
        Intent intent = getIntent();
        String strProcesso = intent.getStringExtra("processo");
       // listViewOpcoes = (ListView) this.findViewById(R.id.listViewOpcoes);
        List<Andamento> itens = andamentoRepository.lista(strProcesso);
       /* ArrayAdapter<Andamento> arrayItens = new ArrayAdapter<Andamento>(this,android.R.layout.simple_list_item_1,itens);
        listViewOpcoes.setAdapter(arrayItens);*/
        final AndamentoAdapter andamentoAdapter = new AndamentoAdapter(this,  itens);
        listViewOpcoes.setAdapter(andamentoAdapter);

    }
    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    //variaveis para as permissões
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    //método para a permissão de armazenamento
    public static void verificaPermissao(Activity activity) {
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void gerarPdf(){
        AndamentoRepository andamentoRepository = new AndamentoRepository(this);

        Intent intent = getIntent();
        String strProcesso = intent.getStringExtra("processo");
        List<Andamento> listaAndamentos = andamentoRepository.lista(strProcesso);

        //fontes usadas para criação do pdf
        Font fonteCabecalho =new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font fonteLinhas =new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
        Font fonteTitulo =new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        fonteTitulo.setColor(138, 51, 51);
        Font fonteTopo = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);

        // Criação do objeto que será um documento PDF
        Document document = new Document();
        try {

            String filename = "Andamento.pdf";

            document = new Document(PageSize.A4);

            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();

            this.dir =  new File(path, filename);
            if (!dir.exists()) {
                dir.getParentFile().mkdirs();
            }/**


            Drawable d = ContextCompat.getDrawable(context, R.drawable.imageSIC);
            Bitmap bit = ((BitmapDrawable) d).getBitmap();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
            this.imageSIC = Image.getInstance(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();


*///            Image figura = Image.getInstance("C:\\imagem.jpg");
//            document.add(figura);

            FileOutputStream fOut = new FileOutputStream(dir);
            fOut.flush();

            PdfWriter.getInstance(document, fOut);
            document.open();

            Paragraph topo = new Paragraph("Prefeitura Municipal de Alegrete", fonteTopo);
            topo.setAlignment(Element.ALIGN_CENTER);
            topo.setSpacingBefore(5);
            topo.setSpacingAfter(10);

            Paragraph titulo = new Paragraph("Andamento do Processo nº "+strProcesso+ "\n", fonteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10);
            document.add(topo);
            document.add(titulo);

            PdfPTable table = new PdfPTable(6);

            table.setWidthPercentage (100);
            PdfPCell cel1 = new PdfPCell(new Paragraph("Data", fonteCabecalho));
            PdfPCell cel2 = new PdfPCell(new Paragraph("Departamento", fonteCabecalho));
            PdfPCell cel3 = new PdfPCell(new Paragraph("Despacho", fonteCabecalho));
            PdfPCell cel4 = new PdfPCell(new Paragraph("Ocorrência", fonteCabecalho));
            cel4.setColspan (3);

            cel1.setBackgroundColor (BaseColor.LIGHT_GRAY);
            cel2.setBackgroundColor (BaseColor.LIGHT_GRAY);
            cel3.setBackgroundColor (BaseColor.LIGHT_GRAY);
            cel4.setBackgroundColor (BaseColor.LIGHT_GRAY);

            cel1.setHorizontalAlignment (Element.ALIGN_CENTER);
            cel2.setHorizontalAlignment (Element.ALIGN_CENTER);
            cel3.setHorizontalAlignment (Element.ALIGN_CENTER);
            cel4.setHorizontalAlignment (Element.ALIGN_CENTER);

            table.addCell(cel1);
            table.addCell(cel2);
            table.addCell(cel3);
            table.addCell(cel4);


            for (Andamento andamento : listaAndamentos) {
                cel1 = new PdfPCell(new Paragraph(andamento.getData()+"", fonteLinhas));
                cel2 = new PdfPCell(new Paragraph(andamento.getDepartamento(), fonteLinhas));
                cel3 = new PdfPCell(new Paragraph(andamento.getDespacho()+"", fonteLinhas));
                cel4 = new PdfPCell(new Paragraph(andamento.getOcorrencia(), fonteLinhas));
                cel4.setColspan (3);

                cel1.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);
                cel2.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);
                cel3.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);
                cel4.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);

                table.addCell(cel1);
                table.addCell(cel2);
                table.addCell(cel3);
                table.addCell(cel4);
                table.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);
            }
            document.add(table);
            Log.e("PDF Salvo", path);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        //Compartilhamento

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(dir));
        sendIntent.setType("application/pdf");
        startActivity(Intent.createChooser(sendIntent, "Compartilhar via"));



    }
}
