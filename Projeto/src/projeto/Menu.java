/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author glaykiere
 */
public class Menu {

    Scanner scanner;
    Cadastro cad;
    Movimentacao movimentacao;
    Usuario login;

    public Menu() {
        scanner = new Scanner(System.in);
        cad = new Cadastro();
    }

    public void menuPrincipal() {

        System.out.println("======MENU======");
        System.out.println("Digite 1 para fazer login");
        System.out.println("Digite 2 para cadastrar novo usuario");
        System.out.println("Digite 3 para sair do programa");
        String opcao = scanner.next();
        if(opcao.length()>1){
            opcao = "x";
        }
        switch (opcao) {
            case "1": {
                menuLogin();
                break;
            }
            case "2": {
                menuCadastro();
                break;
            }
            case "3": {
                System.out.println("Programa terminado com sucesso");
                break;
            }
            default: {
                System.out.println("Opcao invalida");
                menuPrincipal();
            }
        }

    }

    public void menuLogin() {
        if (cad.usuarios.isEmpty()) {
            System.out.println("Erro, lista vazia");
            menuPrincipal();
        } else {
            System.out.println("======MENU======");
            System.out.println("Digite o login");
            login = cad.buscar(scanner.next());
            //if o login nao for o mesmo aparece mensagem de erro
            if (login != null) {
                System.out.println("Digite a senha");
                String senha = scanner.next();
                if (login.getSenha().equals(senha)) {
                    menuLogado();
                } else {
                    System.out.println("Senha invalida");
                    menuPrincipal();
                }

            } else {
                System.out.println("Login invalido");
                menuPrincipal();
            }
        }

    }

    public void menuCadastro() {
        System.out.println("======MENU======");
        System.out.println("Digite o login");
        String loginCadastro = scanner.next();
        //if o login for igual aparece mensagem de erro
        if (cad.buscar(loginCadastro) != null) {
            System.out.println("Este login ja existe");
            menuCadastro();
        } else {
            Date nascimento;
            System.out.println("Digite a data de nascimento (dd/mm/aaaa)");
            while (true) {
                String data = scanner.next();
                try {
                    nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                    break;
                } catch (ParseException ex) {
                    System.out.println("Formato de data nao aceito");
                }
            }
            char sexo = 'x';
            while (Character.toLowerCase(sexo) != 'm' && Character.toLowerCase(sexo) != 'f') {                
                System.out.println("Digite o sexo M/F");
                sexo = scanner.next().toUpperCase().charAt(0);
            }
            String senha = "";
            while (senha.length()<4) {                
                System.out.println("Digite uma senha com no minimo 4 digitos");
                senha = scanner.next();
            }            
            cad.adicionar(new Usuario(loginCadastro, nascimento, 0, sexo, senha));
            System.out.println(cad.usuarios);
            menuPrincipal();
        }

    }

    public void menuLogado() {
        System.out.println("Usuario " + login.getLogin() + " está logado");
        System.out.println("======MENU======");
        System.out.println("Digite 1 para movimentacao");
        System.out.println("Digite 2 para atualizar o cadastro");
        System.out.println("Digite 3 para excluir um usuario");
        System.out.println("Digite 4 para voltar ao menu principal");
        String opcao = scanner.next();
        if(opcao.length()>1){
            opcao = "x";
        }

        switch (opcao) {
            case "1": {
                menuMovimentacao();
                break;
            }
            case "2": {
                System.out.println("Digite a sua senha antiga");
                String senha = scanner.next();
                if (login.getSenha().equals(senha)) {
                    System.out.println("Digite a nova senha");
                    String senhaNova = scanner.next();
                    System.out.println("Confirme a senha");
                    if (senhaNova.equals(scanner.next())) {
                        login.setSenha(senhaNova);
                        menuLogado();
                    } else {
                        System.out.println("Senha nao condiz com a anterior");
                        menuLogado();
                    }
                } else {
                    System.out.println("Senha incorreta");
                    menuLogado();
                }
                break;
            }
            case "3": {
                System.out.println("Digite o usuario que deseja remover");
                String remove = scanner.next();
                if (cad.buscar(remove).equals(login)) {
                    System.out.println("Erro, voce nao pode remover esse usuario");
                } else {
                    cad.remover(cad.buscar(remove));
                    System.out.println("Usuario " + remove + " removido com sucesso");
                }
                menuLogado();
                break;
            }
            case "4": {
                login = null;
                menuPrincipal();
                break;
            }

            default: {
                System.out.println("Opcao invalida");
                menuLogado();
            }
        }
    }

    public void menuMovimentacao() {
        System.out.println("Digite uma descricao para a movimentacao");
        String descricao = scanner.next();
        LocalDate data = LocalDate.now();
        float valor;
        System.out.println("Digite o valor");
        valor = scanner.nextFloat();
        while (valor < 0.0f) {
            System.out.println("Valor invalido");
            System.out.println("Digite o valor");
            valor = scanner.nextFloat();
        }
        System.out.println("Digite a categoria da movimentacao");
        String categoria = scanner.next();
        String tipo = "";
        if(tipo.length()>1){
            tipo = "";
        }
        while ((!"1".equals(tipo)) && (!"2".equals(tipo))) {
            System.out.println("Digite 1 para entrada ou 2 para saida");
            tipo = scanner.next();
        }
        switch (tipo) {
            case "1": {
                login.setSaldo(login.getSaldo() + valor);
                login.adicionaMovimentacao(new Movimentacao(descricao, data, valor, categoria, tipo));
                System.out.println(cad.usuarios);
                menuLogado();
                break;
            }
            case "2": {
                if (login.getSaldo() < valor) {
                    System.out.println("Saldo insuficiente");
                    menuLogado();
                } 
                else {
                    login.setSaldo(login.getSaldo() - valor);
                    login.adicionaMovimentacao(new Movimentacao(descricao, data, valor, categoria, tipo));
                    System.out.println(cad.usuarios);
                    menuLogado();
                }
                break;
            }
        }        

    }

}
