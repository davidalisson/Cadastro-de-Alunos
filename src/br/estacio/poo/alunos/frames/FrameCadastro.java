/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.dao.ListaAlunos;
import br.estacio.poo.alunos.entidade.Aluno;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FrameCadastro extends JFrame{
// Variáveis
    private FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
    private JLabel lblTitulo1 = new JLabel("Projeto de Cadastro de Alunos");
    private JPanel painelTitulo1 = new JPanel();
    
    private JLabel lblTitulo2 = new JLabel("* Estácio | FIC - 2014.2 *");
    private JPanel painelTitulo2 = new JPanel();
    
    private JLabel lblMatricula = new JLabel("Matrícula: ");
    private JTextField tfMatricula = new JTextField(30);
    private JPanel painelMatricula = new JPanel(layout);
    
    private JLabel lblNome = new JLabel("Nome:        ");
    private JTextField tfNome = new JTextField(30);
    private JPanel painelNome = new JPanel(layout);
    
    private JLabel lblCurso = new JLabel("Curso:        ");
    private JComboBox cbCurso;
    private JPanel painelCurso = new JPanel(layout);
    
    private JLabel lblTurno = new JLabel("Turno:         ");
    private JComboBox cbTurno;
    private JPanel painelTurno = new JPanel(layout);
    
    private JLabel lblSexo = new JLabel("Sexo:          ");
    private JRadioButton rbMasculino = new JRadioButton("Masculino",true);
    private JRadioButton rbFeminino = new JRadioButton("Feminino");
    private ButtonGroup radioGroup = new ButtonGroup();
    private JPanel painelSexo = new JPanel(layout);
    
    private JLabel lblIdade = new JLabel("Idade:         ");
    private JTextField tfIdade = new JTextField(20);
    private JButton btCalcular = new JButton("Calcular");
    private JPanel painelIdade = new JPanel(layout);
    
    private JLabel lblNotas = new JLabel("Notas: ");
    private JPanel painelLblNotas = new JPanel(layout);
    private JLabel lblAv1 = new JLabel("       Av1: ");
    private JTextField tfAv1 = new JTextField(5);
    private JLabel lblAv2 = new JLabel("Av2: ");
    private JTextField tfAv2 = new JTextField(5);
    private JLabel lblAv3 = new JLabel("Av3: ");
    private JTextField tfAv3 = new JTextField(5);
    
    private JLabel lblConhecimentos = new JLabel("Conhecimentos: ");
    private JPanel painelLblConhec = new JPanel(layout);
    
    private JCheckBox chbConhecIgles = new JCheckBox(" Ingles "); 
    private JCheckBox chbConhecJava = new JCheckBox(" Java "); 
    private JCheckBox chbConhecPhp = new JCheckBox(" Php "); 
    private JPanel painelConhec1 = new JPanel(layout);
    
    private JCheckBox chbConhecC = new JCheckBox(" C/C++ "); 
    private JCheckBox chbConhecNet = new JCheckBox(" .Net "); 
    private JCheckBox chbConhecSql = new JCheckBox(" Sql "); 
    private JPanel painelConhec2 = new JPanel(layout);
    
    private JButton btNovo = new JButton("Novo");
    private JButton btGravar = new JButton("Gravar");
    private JButton btConsultar = new JButton("Consultar");
    private JButton btSair = new JButton("Sair");
    private JPanel painelBotoes = new JPanel(layout);
    
    private JPanel painelTudo = new JPanel(new GridLayout(13,1));
    
    private JLabel lblAutor = new JLabel("Autor: David Alisson");
    private JPanel painelAutor = new JPanel();
    private static final String[] nomesCbCurso = 
      { "Sistemas de Inormações", "Análise e Desenvolvimento de Sistemas",  "Redes de Computadores", "Telemática" ,"Jogos Digitais"};
     private static final String[] nomesCbTurno = 
      { "Manhã", "Tarde",  "Noite"};
     
     private JTable tbAlunos = new JTable();
     private JPanel painelTbAlunos = new JPanel(new BorderLayout());
     private JScrollPane sc = new JScrollPane();
     
     private ListaAlunos alunoL = new ListaAlunos();
    private JPanel painelHora = new JPanel();
    private JLabel lblHora = new JLabel();
    private JLabel lblHora2 = new JLabel("Hora Atual: ");
    
    FrameCadastro fc;
//   
     
//Construtor da Classe
    char teste;
    public FrameCadastro()
    {
        
        setLayout(new BorderLayout(10,10));
        
        //Inicialização
        iniciaRelogio();
        camposNaoEditaveis();
        //
        btGravar.setEnabled(false);
        btCalcular.setEnabled(false);
        //TABELA
        //Linha Selecionada da Tabela
        tbAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmAluno = tbAlunos.getSelectionModel();
        lsmAluno.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(! e.getValueIsAdjusting()){
                    tbAlunoLinhaSelecionada(tbAlunos);
                }
            }
        });
        //
        tbAlunos.setSize(200, 100);  
        painelTbAlunos.setSize(500,600);
        painelTbAlunos.setBorder(  BorderFactory.createTitledBorder("Alunos:")  );  
        painelTbAlunos.add(sc,BorderLayout.CENTER);
        sc.setViewportView(tbAlunos);
        tbAlunos.setModel(alunoL.TableModelAlunos());
        //
        painelTitulo1.add(lblTitulo1);
        lblTitulo1.setForeground(Color.WHITE);
        painelTitulo1.setBackground(Color.DARK_GRAY);
        lblTitulo1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD ,Font.CENTER_BASELINE+15));
        painelTitulo2.add(lblTitulo2);
        lblTitulo2.setForeground(Color.WHITE);
        painelTitulo2.setBackground(Color.blue);
        lblTitulo1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD ,Font.CENTER_BASELINE+15));
        painelMatricula.add(lblMatricula);
        painelMatricula.add(tfMatricula);
        painelNome.add(lblNome);
        painelNome.add(tfNome);
        painelCurso.add(lblCurso);
        cbCurso = new JComboBox(nomesCbCurso);
        painelCurso.add(cbCurso);
        painelTurno.add(lblTurno);
        cbTurno = new JComboBox(nomesCbTurno);
        painelTurno.add(cbTurno);
        painelSexo.add(lblSexo);
        radioGroup.add(rbMasculino);
        radioGroup.add(rbFeminino);
        painelSexo.add(rbMasculino);
        painelSexo.add(rbFeminino);
        painelIdade.add(lblIdade);
        painelIdade.add(tfIdade);
        painelIdade.add(btCalcular);
        painelLblNotas.add(lblNotas);
        painelLblNotas.add(lblAv1);
        painelLblNotas.add(tfAv1);
        painelLblNotas.add(lblAv2);
        painelLblNotas.add(tfAv2);
        painelLblNotas.add(lblAv3);
        painelLblNotas.add(tfAv3);
        painelLblConhec.add(lblConhecimentos);
        painelConhec1.add(chbConhecIgles);
        painelConhec1.add(chbConhecJava);
        painelConhec1.add(chbConhecPhp);
        painelConhec2.add(chbConhecC);
        painelConhec2.add(chbConhecNet);
        painelConhec2.add(chbConhecSql);
        painelBotoes.add(btNovo);
        painelBotoes.add(btGravar);
        painelBotoes.add(btConsultar);
        painelBotoes.add(btSair);
        painelAutor.add(lblAutor);
        lblAutor.setFont(new Font("TIMES NEW ROMAN", Font.BOLD ,Font.CENTER_BASELINE+15));
        lblAutor.setForeground(Color.WHITE);
        painelAutor.setBackground(Color.DARK_GRAY);
        //eventos
        Clicar c = new Clicar();
        btCalcular.addActionListener(c);
        btNovo.addActionListener(c);
        btGravar.addActionListener(c);
        btConsultar.addActionListener(c);
        btSair.addActionListener(c);
        //
        painelHora.add(lblHora2);
        painelHora.add(lblHora);
        add(painelTbAlunos,BorderLayout.CENTER);
        painelTudo.add(painelTitulo1,BorderLayout.CENTER);
        painelTudo.add(painelTitulo2,BorderLayout.CENTER);
        painelTudo.add(painelMatricula);
        painelTudo.add(painelNome);
        painelTudo.add(painelCurso);
        painelTudo.add(painelTurno);
        painelTudo.add(painelSexo);
        painelTudo.add(painelIdade);
        painelTudo.add(painelLblNotas);
        painelTudo.add(painelLblConhec);
        painelTudo.add(painelConhec1);
        painelTudo.add(painelConhec2);
        painelTudo.add(painelBotoes);
        
        add(painelTudo,BorderLayout.WEST);
        painelHora.setBorder(BorderFactory.createTitledBorder(" - Horário de Brasília - ")  );
        painelTbAlunos.add(painelHora, BorderLayout.SOUTH);
        add(painelAutor,BorderLayout.SOUTH);
        
        

        
    }
    
//Pegar idade do FrameIdade
    public void setIdade(String s)
    {
        tfIdade.setText(s);
    }
    
//Cadastrar Alunos
    public void cadastrarAluno()
    {
        Aluno aluno = new Aluno();
        aluno.setMatricula(tfMatricula.getText().trim());
        aluno.setNome(tfNome.getText().trim());
        aluno.setCurso(cbCurso.getSelectedItem().toString());
        
        if (cbTurno.getSelectedItem().equals("Manhã"))
            aluno.setTurno('M');
        else if (cbTurno.getSelectedItem().equals("Tarde"))
            aluno.setTurno('T');
        else if (cbTurno.getSelectedItem().equals("Noite"))
            aluno.setTurno('N');
        
        aluno.setIdade(Integer.parseInt(String.valueOf(tfIdade.getText().trim())));
        
        if(rbMasculino.isSelected())
            aluno.setSexo('M');
        else
            aluno.setSexo('F');
        aluno.setAv1(Float.parseFloat(String.valueOf(tfAv1.getText().trim())));
        aluno.setAv2(Float.parseFloat(String.valueOf(tfAv2.getText().trim())));
        aluno.setAv3(Float.parseFloat(String.valueOf(tfAv3.getText().trim())));
        
        if(chbConhecIgles.isSelected())
            aluno.setConhecimentoIngles(true);
        else
            aluno.setConhecimentoIngles(false);
        
        if(chbConhecJava.isSelected())
            aluno.setConhecimentoJava(true);
        else
            aluno.setConhecimentoJava(false);
        
        if(chbConhecPhp.isSelected())
            aluno.setConhecimentoPhp(true);
        else
            aluno.setConhecimentoPhp(false);
        
        if(chbConhecC.isSelected())
            aluno.setConhecimentoC(true);
        else
            aluno.setConhecimentoC(false);
        
        if(chbConhecNet.isSelected())
            aluno.setConhecimentoNet(true);
        else
            aluno.setConhecimentoNet(false);
        
        if(chbConhecSql.isSelected())
            aluno.setConhecimentoSql(true);
        else
            aluno.setConhecimentoSql(false);

        alunoL.incluir(aluno);
        teste=aluno.getTurno();
    }
    
//Limpar os Campos
    public void limparCampos()
    {
        tfMatricula.setText("");
        tfNome.setText("");
        tfIdade.setText("");
        tfAv1.setText("");
        tfAv2.setText("");
        tfAv3.setText("");
        chbConhecIgles.setSelected(false);
        chbConhecJava.setSelected(false);
        chbConhecPhp.setSelected(false);
        chbConhecC.setSelected(false);
        chbConhecNet.setSelected(false);
        chbConhecSql.setSelected(false);
    }
    
    //Campos não Editáveis
    public void camposNaoEditaveis()
    {
        tfMatricula.setEditable(false);
        tfNome.setEditable(false);
        //cbCurso.setEnabled(false);
        //cbTurno.setEnabled(false);
        tfIdade.setEditable(false);
        rbFeminino.setEnabled(false);
        rbMasculino.setEnabled(false);
        tfAv1.setEditable(false);
        tfAv2.setEditable(false);
        tfAv3.setEditable(false);
        chbConhecIgles.setEnabled(false);
        chbConhecJava.setEnabled(false);
        chbConhecPhp.setEnabled(false);
        chbConhecC.setEnabled(false);
        chbConhecNet.setEnabled(false);
        chbConhecSql.setEnabled(false);
        
        
    }
    
//Campos Editáveis
    public void camposEditaveis()
    {
    tfMatricula.setEditable(true);
        tfNome.setEditable(true);
        //cbCurso.setEnabled(true);
        //cbTurno.setEnabled(true);
        tfIdade.setEditable(true);
        rbFeminino.setEnabled(true);
        rbMasculino.setEnabled(true);
        tfAv1.setEditable(true);
        tfAv2.setEditable(true);
        tfAv3.setEditable(true);
        chbConhecIgles.setEnabled(true);
        chbConhecJava.setEnabled(true);
        chbConhecPhp.setEnabled(true);
        chbConhecC.setEnabled(true);
        chbConhecNet.setEnabled(true);
        chbConhecSql.setEnabled(true);
        
    }
    
//Verificação de campos
    public void verificaCampos()
    {
        if (tfMatricula.getText().equals(""))
                   JOptionPane.showMessageDialog(FrameCadastro.this, "Preencha o campo 'Matricula'!!!");
                else if (tfNome.getText().equals(""))
                   JOptionPane.showMessageDialog(FrameCadastro.this, "Preencha o campo 'Nome'!!!");
                else if (tfIdade.getText().equals(""))
                   JOptionPane.showMessageDialog(FrameCadastro.this, "Preencha o campo 'Idade'!!!");
                else if (tfAv1.getText().equals(""))
                   JOptionPane.showMessageDialog(FrameCadastro.this, "Preencha o campo 'Av1'!!!");
                else if (tfAv2.getText().equals(""))
                   JOptionPane.showMessageDialog(FrameCadastro.this, "Preencha o campo 'Av2'!!!");
                else if (tfAv3.getText().equals(""))
                   JOptionPane.showMessageDialog(FrameCadastro.this, "Preencha o campo 'Av3'!!!");
                else
                {
                    try{
                    cadastrarAluno();
                    JOptionPane.showMessageDialog(FrameCadastro.this, "Cadastro realizado com sucesso! ");
                    camposNaoEditaveis();
                    btGravar.setEnabled(false);
                    btCalcular.setEnabled(false);
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, " Ops, digite apenas numeros nos campos Av1, Av2, Av3 e Idade! ");
                    }
                }
    }
//Eventos de Click
    
    public class Clicar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton b = (JButton) e.getSource();
            if (b==btCalcular)
            {
                FrameIdade frameI = new FrameIdade(FrameCadastro.this);
                frameI.setVisible(true); 
            }
            else if (b == btNovo)
            {
                btGravar.setEnabled(true);
                btCalcular.setEnabled(true);
                camposEditaveis();
                limparCampos();
             
            }
            else if( b == btGravar)
            {
                verificaCampos();
                System.out.println(teste);
            }    
            else if(b == btConsultar)
            {   
                alunoL.listarAlunos();
                btGravar.setEnabled(false);
                btCalcular.setEnabled(false);
                camposNaoEditaveis();
                
            }
            else if(e.getSource() == btSair)
            {
                int resposta = JOptionPane.showConfirmDialog(FrameCadastro.this, "Antes sair desta tela verifique se todos os dados foram salvos.\n Deseja realmente sair?","Verificação de Saída!!!", JOptionPane.YES_OPTION);
                if (resposta == JOptionPane.YES_OPTION) 
                {
                    System.exit(0);
                }
            }
        }
    }
    
//Relógio
    public void iniciaRelogio() {
        new Thread() {//instancia nova thread já implementando o método run()
            public void run() {//sobrescreve o método run()
                while (0 == 0) {//while para fazer o loop infinito
                    GregorianCalendar gc = new GregorianCalendar();//novo gregorian calendar, onde temos a data atual
                    int hora = gc.get(Calendar.HOUR_OF_DAY);//pega as horas
                    int minuto = gc.get(Calendar.MINUTE);//pega os minutos
                    int segundo = gc.get(Calendar.SECOND);//pega os segundos
                    String horaString;//nova string horas
                    String minString;//nova string minutos
                    String segundoString;//nova string segundos
                    if (hora < 10)
                    {//se hora for menor que 10 precisa colocar um 0 à esquerda
                        horaString = "0" + hora;
                    } else
                    {
                        horaString = "" + hora;
                    }
                    if (minuto < 10) 
                    {//se minuto for menor que 10 precisa colocar um 0 à esquerda
                        minString = "0" + minuto;
                    } else
                    {
                        minString = "" + minuto;
                    }
                    if (segundo < 10)
                    {//se segundo for menor que 10 precisa colocar um 0 à esquerda
                        segundoString = "0" + segundo;
                    } else
                    {
                        segundoString = "" + segundo;
                    }
                    lblHora.setText(""+horaString + ":" + minString + ":" + segundoString);//seta hora atual no label
                    try {
                        sleep(1000);//faz a thread entrar em estado de espera por 1000 milissegundos ou 1 segundo
                    } catch (Exception e) {
                    }
                }
            }
    }.start();//inicia a thread.
    }
    
//Linha Selecionada
    List<Aluno> aluno ;
    ListSelectionModel lsmAluno ;
    public void tbAlunoLinhaSelecionada(JTable tb) {
        
        aluno = alunoL.getAluno();
        if (tb.getSelectedRow() != -1) {
            tfMatricula.setText(aluno.get(tb.getSelectedRow()).getMatricula());

            tfNome.setText(aluno.get(tb.getSelectedRow()).getNome());
            
            cbCurso.setSelectedItem(aluno.get(tb.getSelectedRow()).getCurso());
            
            if(aluno.get(tb.getSelectedRow()).getTurno() == 'M')
            {
                cbTurno.setSelectedIndex(0);
            }
            else if(aluno.get(tb.getSelectedRow()).getTurno() == 'T')
            {
                cbTurno.setSelectedIndex(1);
            }
            else if(aluno.get(tb.getSelectedRow()).getTurno() == 'N')
            {
                cbTurno.setSelectedIndex(2);
            }

            if (aluno.get(tb.getSelectedRow()).getSexo()=='M'){
                rbMasculino.setSelected(true);
                rbFeminino.setSelected(false);
            }
            else
            {
            rbMasculino.setSelected(false);
            rbFeminino.setSelected(true);
            }
            
            tfIdade.setText(String.valueOf(aluno.get(tb.getSelectedRow()).getIdade()));
            
            tfAv1.setText(String.valueOf(aluno.get(tb.getSelectedRow()).getAv1()));
            tfAv2.setText(String.valueOf(aluno.get(tb.getSelectedRow()).getAv2()));
            tfAv3.setText(String.valueOf(aluno.get(tb.getSelectedRow()).getAv3()));
            
            
            chbConhecIgles.setSelected(aluno.get(tb.getSelectedRow()).isConhecimentoIngles());
            chbConhecJava.setSelected(aluno.get(tb.getSelectedRow()).isConhecimentoJava());
            chbConhecPhp.setSelected(aluno.get(tb.getSelectedRow()).isConhecimentoPhp());
            chbConhecC.setSelected(aluno.get(tb.getSelectedRow()).isConhecimentoC());
            chbConhecNet.setSelected(aluno.get(tb.getSelectedRow()).isConhecimentoNet());
            chbConhecSql.setSelected(aluno.get(tb.getSelectedRow()).isConhecimentoSql());


        } else {
            limparCampos();

        }
    }
  
}
