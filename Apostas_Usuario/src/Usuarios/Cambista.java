/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import javax.swing.JOptionPane;

/**
 *
 * @author Danie
 */
public class Cambista extends Usuario {

    private static int idCambista;

    public void alterarCadastro() {
        int esc1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o que você quer alterar\n 1-Nome\n 2-Matriculla\n 3- Cpf\n 4-Telefone\n 5- Endereco\n 6- Saldo"));
        switch (esc1) {
            case 1:
                nome = JOptionPane.showInputDialog("Informe o novo nome");
                break;
            case 2:
                matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe o novo nome"));
                break;
            case 3:
                cpf = JOptionPane.showInputDialog("Informe o Novo cpf");
                break;
            case 4:
                telefone = JOptionPane.showInputDialog("Informe o Novo telefone");
                break;
            case 5:
                endereco = JOptionPane.showInputDialog("Informe o Novo endereco");
                break;
            case 6:
                try {
                    float sald = Float.parseFloat(JOptionPane.showInputDialog("Informe o Novo saldo"));
                    setSaldo(sald);
                } catch (NumberFormatException e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Por favor, informe um valor numerico");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Informe uma opção valida!!");
        }
    }

    public Cambista() {

    }

    public Cambista(int matricula, String nome, String cpf, String telefone, String endereco) {
        super(matricula, nome, cpf, telefone, endereco);
    }

    public Usuario gerarCadastro() {
        idCambista++;
        u = new Supervisor();
        nome = JOptionPane.showInputDialog("Informe o nome do Supervisor");
        setNome(nome);
        int mat = 0;
        int testmat;
        do {
            try {
                mat = Integer.parseInt(JOptionPane.showInputDialog("Informe a Matricula do Cambista"));
                setMatricula(mat);
                testmat = 0;
            } catch (NumberFormatException e) {
                testmat = 1;
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Por favor, informe um valor numerico");
            }
        } while (testmat != 0);
        {
            int testecpf = 0;
            int testcpf;
            do {
                try {
                    String cpf = JOptionPane.showInputDialog("Informe o cpf do Cambista");
                    testcpf = Integer.parseInt(cpf);
                    testecpf = 0;
                    setCpf(cpf);
                } catch (NumberFormatException e) {
                    testecpf = 1;
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Por favor, informe um CPF valido", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            } while (testecpf != 0);
        }
        String end = JOptionPane.showInputDialog("Informe o endereco do Cambista");
        setEndereco(end);
        int testeTelefone = 0;
        int testTel;
        do {
            try {
                String telefone = JOptionPane.showInputDialog("Informe o telefone do Cambista");
                setTelefone(telefone);
                testTel = Integer.parseInt(telefone);
                testeTelefone = 0;
            } catch (NumberFormatException e) {
                testeTelefone = 1;
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Por favor, informe um Telefone valido", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (testeTelefone != 0);
        float sald = 00;
        int testesald = 0;
        do {
            try {
                sald = Float.parseFloat(JOptionPane.showInputDialog("Informe o saldo Cambista"));
                setSaldo(sald);
                testesald = 0;
            } catch (NumberFormatException e) {
                testesald = 1;
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Por favor, informe um valor numerico");
            }
        } while (testesald != 0);
        JOptionPane.showMessageDialog(null, "Cadastro Efetuador com Sucesso!!");
        u = new Supervisor(idCambista, matricula, nome, cpf, telefone, endereco);
        return u;
    }

    public String imprimirCadastro() {
        return "Nome adm: " + nome
                + "\nMatricula: " + matricula
                + "\n ID Cambista: " + idCambista
                + "\nCpf: " + cpf
                + "\nTelefone: " + telefone
                + "\n endereco: " + endereco
                + "\nSaldo: " + saldo;

    }

}
