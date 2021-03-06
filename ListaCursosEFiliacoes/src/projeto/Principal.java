package projeto;

import projeto.bean.Aluno;
import projeto.bean.Curso;
import projeto.bean.Filiacao;
import projeto.controller.CursoController;
import projeto.controller.FiliacaoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Principal extends JFrame {
    JButton btn1 = new JButton("Botao 1");
    JButton btn2 = new JButton("Botao 2");

    public Principal() {
        setLayout(null);
        /*btn1.setBounds(10,10,100,30);
        add(btn1);
        add(btn2);
        btn2.setBounds(50,40,100,30);*/
        FirstBotao();
        SecondBotao();
        setTitle("Lista curso e filiação");

        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);;
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void FirstBotao() {
        ImageIcon filiacao = new ImageIcon("./src/projeto/assets/network.png");
        JButton btn = new JButton("Filiação",filiacao);
        btn.setBounds(20,60,120,30);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int idFiliacao = 0;
                try {
                    idFiliacao = Integer.parseInt(JOptionPane.showInputDialog("Id da Filiação"));

                } catch (NumberFormatException ne) {
                    System.out.println(ne);
                    JOptionPane.showMessageDialog(null,"Valor inválido! Insira apenas números!");
                    return ;
                }
                Filiacao filiacao = new Filiacao(idFiliacao,"","","");
                FiliacaoController filiacaoController = new FiliacaoController();

                filiacao = filiacaoController.BuscaFiliacaoPorId(filiacao);

                System.out.println(filiacao.toString());
                JOptionPane.showMessageDialog(null,filiacao.toString());

            }
        });
    }

    public void SecondBotao() {
        ImageIcon curso = new ImageIcon("./src/projeto/assets/knowledge.png");
        JButton btn = new JButton("Cursos",curso);
        btn.setBounds(160,60,120,30);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent actionEvent) {
                int idCurso = 0;
                try {
                    idCurso = Integer.parseInt(JOptionPane.showInputDialog("Id do Curso"));
                } catch (NumberFormatException ne) {
                    System.out.println(ne);
                    JOptionPane.showMessageDialog(null,"Valor inválido! Insira apenas números");
                    return ;
                }
                Curso curso = new Curso(idCurso,"","","");
                CursoController cursoController = new CursoController();
                curso = cursoController.BuscaCurso(curso);

                System.out.println(curso.toString());
                System.out.println(curso.toString());

                JOptionPane.showMessageDialog(null,curso.toString());
            }
        });
    }

    public static void main(String[] args) {
        new Principal();
    }

}
