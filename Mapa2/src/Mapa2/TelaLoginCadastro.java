package Mapa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TelaLoginCadastro extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;
    private JButton botaoCadastrar;
    private JPanel painelLogin;

    // Campos de texto da tela de cadastro
    private JTextField campoNome;
    private JTextField campoLoginCadastro;
    private JPasswordField campoSenhaCadastro;
    private JTextField campoEmail;

    public TelaLoginCadastro() {
        setTitle("Tela de Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelLogin = new JPanel();
        painelLogin.setLayout(new GridLayout(4, 2));

        JLabel labelUsuario = new JLabel("Usuário:");
        campoUsuario = new JTextField(20);

        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(20);

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerLogin();
            }
        });

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaCadastro();
            }
        });
        botaoCadastrar.setVisible(false);

        painelLogin.add(labelUsuario);
        painelLogin.add(campoUsuario);
        painelLogin.add(labelSenha);
        painelLogin.add(campoSenha);
        painelLogin.add(new JLabel());
        painelLogin.add(botaoEntrar);
        painelLogin.add(new JLabel());
        painelLogin.add(botaoCadastrar);

        add(painelLogin);
    }

    private void fazerLogin() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        String url = "jdbc:mysql://localhost:3306/mapa";
        String usuarioBD = "root";
        String senhaBD = "Peretti12@";

        try (Connection conexao = DriverManager.getConnection(url, usuarioBD, senhaBD)) {
        	String consultaSQL = "SELECT id, nome FROM usuario WHERE login = ? AND senha = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL)) {
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, senha);
                try (ResultSet resultado = preparedStatement.executeQuery()) {
                    if (resultado.next()) {
                        JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
                        botaoCadastrar.setVisible(true);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private void exibirTelaCadastro() {
        JFrame telaCadastro = new JFrame("Tela de Cadastro");
        telaCadastro.setSize(300, 200);
        telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridLayout(5, 2));

        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField(20);

        JLabel labelLoginCadastro = new JLabel("Login:");
        campoLoginCadastro = new JTextField(20);

        JLabel labelSenhaCadastro = new JLabel("Senha:");
        campoSenhaCadastro = new JPasswordField(20);

        JLabel labelEmail = new JLabel("Email:");
        campoEmail = new JTextField(20);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
                telaCadastro.dispose(); // Fechar a janela de cadastro após o cadastro bem-sucedido
            }
        });

        painelCadastro.add(labelNome);
        painelCadastro.add(campoNome);
        painelCadastro.add(labelLoginCadastro);
        painelCadastro.add(campoLoginCadastro);
        painelCadastro.add(labelSenhaCadastro);
        painelCadastro.add(campoSenhaCadastro);
        painelCadastro.add(labelEmail);
        painelCadastro.add(campoEmail);
        painelCadastro.add(new JLabel());
        painelCadastro.add(botaoCadastrar);

        telaCadastro.add(painelCadastro);
        telaCadastro.setVisible(true);
    }

    	    
	       

    private void cadastrarUsuario() {
        String nome = campoNome.getText();
        String login = campoLoginCadastro.getText();
        String senha = new String(campoSenhaCadastro.getPassword());
        String email = campoEmail.getText();

	        String url = "jdbc:mysql://localhost:3306/mapa";
	        String usuarioBD = "root";
	        String senhaBD = "Peretti12@";

	        try (Connection conexao = DriverManager.getConnection(url, usuarioBD, senhaBD)) {
	            String consultaSQL = "INSERT INTO usuario (nome, login, senha, email) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL)) {
	                preparedStatement.setString(1, nome);
	                preparedStatement.setString(2, login);
	                preparedStatement.setString(3, senha);
	                preparedStatement.setString(4, email);

	                int linhasAfetadas = preparedStatement.executeUpdate();
	                if (linhasAfetadas > 0) {
	                    JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
	                } else {
	                    JOptionPane.showMessageDialog(this, "Falha ao cadastrar o usuário.");
	                }
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
	        }
	    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLoginCadastro tela = new TelaLoginCadastro();
                tela.setVisible(true);
            }
        });
    }
}
