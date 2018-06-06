/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.estacio.poo.alunos.frames;

import br.estacio.poo.alunos.frames.FrameCadastro;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class FrameIdade extends JFrame{
    private JLabel lblAnoAtual = new JLabel("Ano Atual:                   ");
    private JTextField tfAnoAtual = new JTextField(10);
    private JLabel lblAnoNasc = new JLabel("Ano de Nascimento: ");
    private JTextField tfAnoNasc = new JTextField(10);
    private JLabel lblIdadeCalculada = new JLabel("Idade Calculada:      ");
    private JTextField tfIdadeCalculada = new JTextField(10);
    private JButton btCalcular = new JButton("  Calcular    ");
    private JButton btFechar = new JButton("    Fechar  ");
    private JPanel painel = new JPanel();
    
    FrameCadastro fc;
    public FrameIdade(FrameCadastro f)
    {
        fc=new FrameCadastro();
        fc=f;
        setLayout(new FlowLayout());
       
        
        setLocationRelativeTo(null);
        
        
        setSize(300,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        tfIdadeCalculada.setEditable(false);
        lblAnoAtual.setHorizontalAlignment(SwingConstants.CENTER);
        lblAnoNasc.setHorizontalAlignment(SwingConstants.CENTER);     
        
        add(lblAnoAtual);
        add(tfAnoAtual);
        add(lblAnoNasc);
        add(tfAnoNasc);
        painel.add(btCalcular);
        painel.add(btFechar);
        add(painel);
        add(lblIdadeCalculada);
        add(tfIdadeCalculada);
        
        btCalcular.addActionListener(new Clicar());
        btFechar.addActionListener(new Clicar());
    }
        int anoA;
        int anoN;
        int idade;
        String idadeCalc;
        
    public void verificaCampos()
    {
        
        try{
            if (tfAnoAtual.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Preencha o campo 'Ano Atual'");
            else if (tfAnoAtual.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Preencha o campo 'Ano de Nascimento'");
            else{

                anoA= Integer.parseInt(tfAnoAtual.getText());
                anoN= Integer.parseInt(tfAnoNasc.getText());
                idade = anoA-anoN;
                idadeCalc = String.valueOf(idade);
                tfIdadeCalculada.setText(idadeCalc);
                
                
                
                }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Ops, digite apenas numeros nos campos 'Ano atual'\n"
                                                            + "e 'Ano de Nascimento'");
        }
    }

   
   
    public class Clicar implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
            
            if (e.getSource()==btCalcular)
            {
                verificaCampos();

            }else if(e.getSource()==btFechar)
            {  
                fc.setIdade(tfIdadeCalculada.getText());
                dispose();
            }
        }
    }

    
}
