/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.estacio.poo.alunos.entidade;

/**
 *
 * @author fic
 */
public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private char turno;
    private int idade;
    private char sexo;    
    private float av1;
    private float av2;
    private float av3;
    private boolean conhecimentoIngles;
    private boolean conhecimentoJava;
    private boolean conhecimentoPhp;
    private boolean conhecimentoC;
    private boolean conhecimentoNet;
    private boolean conhecimentoSql;

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public char getTurno() {
        return turno;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setTurno(char turno) {
        this.turno = turno;
    }

    
    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the av1
     */
    public float getAv1() {
        return av1;
    }

    /**
     * @param av1 the av1 to set
     */
    public void setAv1(float av1) {
        this.av1 = av1;
    }

    /**
     * @return the av2
     */
    public float getAv2() {
        return av2;
    }

    /**
     * @param av2 the av2 to set
     */
    public void setAv2(float av2) {
        this.av2 = av2;
    }

    /**
     * @return the av3
     */
    public float getAv3() {
        return av3;
    }

    /**
     * @param av3 the av3 to set
     */
    public void setAv3(float av3) {
        this.av3 = av3;
    }

    /**
     * @return the conhecimentoIngles
     */
    public boolean isConhecimentoIngles() {
        return conhecimentoIngles;
    }

    /**
     * @param conhecimentoIngles the conhecimentoIngles to set
     */
    public void setConhecimentoIngles(boolean conhecimentoIngles) {
        this.conhecimentoIngles = conhecimentoIngles;
    }

    /**
     * @return the conhecimentoJava
     */
    public boolean isConhecimentoJava() {
        return conhecimentoJava;
    }

    /**
     * @param conhecimentoJava the conhecimentoJava to set
     */
    public void setConhecimentoJava(boolean conhecimentoJava) {
        this.conhecimentoJava = conhecimentoJava;
    }

    /**
     * @return the conhecimentoPhp
     */
    public boolean isConhecimentoPhp() {
        return conhecimentoPhp;
    }

    /**
     * @param conhecimentoPhp the conhecimentoPhp to set
     */
    public void setConhecimentoPhp(boolean conhecimentoPhp) {
        this.conhecimentoPhp = conhecimentoPhp;
    }

    /**
     * @return the conhecimentoC
     */
    public boolean isConhecimentoC() {
        return conhecimentoC;
    }

    /**
     * @param conhecimentoC the conhecimentoC to set
     */
    public void setConhecimentoC(boolean conhecimentoC) {
        this.conhecimentoC = conhecimentoC;
    }

    /**
     * @return the conhecimentoNet
     */
    public boolean isConhecimentoNet() {
        return conhecimentoNet;
    }

    /**
     * @param conhecimentoNet the conhecimentoNet to set
     */
    public void setConhecimentoNet(boolean conhecimentoNet) {
        this.conhecimentoNet = conhecimentoNet;
    }

    /**
     * @return the conhecimentoSql
     */
    public boolean isConhecimentoSql() {
        return conhecimentoSql;
    }

    /**
     * @param conhecimentoSql the conhecimentoSql to set
     */
    public void setConhecimentoSql(boolean conhecimentoSql) {
        this.conhecimentoSql = conhecimentoSql;
    }
    
}
