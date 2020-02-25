package projeto;

import projeto.bean.Aluno;
import projeto.bean.Curso;
import projeto.controller.CursoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setTitle("Teste");

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
                new Aluno();
                Aluno.main();
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
                int idCurso = Integer.parseInt(JOptionPane.showInputDialog("Id do Curso"));
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
