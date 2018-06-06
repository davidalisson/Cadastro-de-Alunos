
package br.estacio.poo.alunos.dao;

import br.estacio.poo.alunos.entidade.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListaAlunos {

    private List<Aluno> alunoL = new ArrayList();
    private DefaultTableModel tmAlunos = new DefaultTableModel(null, new String[]{"Matricula", "Nome"});
        
    public DefaultTableModel TableModelAlunos()
    {
        return tmAlunos;     
    }
    
    public void incluir(Aluno aluno)
    {
          alunoL.add(aluno);
    }
    //Aluno b;
    public List getAluno()
    {
        return alunoL;
    }

    public void mostrarAlunos(List<Aluno> listA)
    {
        while (tmAlunos.getRowCount() > 0) {
            tmAlunos.removeRow(0);
        }
        
        if (alunoL.isEmpty())
            JOptionPane.showMessageDialog(null, "Nenhum Aluno encontrado!\nPor favor cadastre um novo aluno.");
        else 
        {
            String[] campos = new String[]{null, null};
            for (int i = 0; i < alunoL.size(); i++) {
                tmAlunos.addRow(campos);
                tmAlunos.setValueAt(alunoL.get(i).getMatricula(), i, 0);
                tmAlunos.setValueAt(alunoL.get(i).getNome(), i, 1);
            }
        }
       
    }
    public void listarAlunos() {   
        mostrarAlunos(alunoL);
        
    }
}