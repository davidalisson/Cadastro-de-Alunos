/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.estacio.poo.alunos.main;

import br.estacio.poo.alunos.frames.FrameCadastro;
import javax.swing.JDialog;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author fic
 */
public class CadastroAlunosMain 
{
   public static void main (String args[])
    {   
        
        FrameCadastro frame = new FrameCadastro();
        frame.setSize(900,725);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
       
        
    }
}
