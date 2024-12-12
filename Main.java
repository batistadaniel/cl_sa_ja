import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Menu menu = new Menu();
        App app = new App("Salao Beleza Rapida");

        menu.tituloInicial();
        app.menu();

    }
}

class Menu {

    // metodo void, ou seja, sem retorno
    void tituloInicial() {
        System.out.println();
        System.out.println("*************** BEM VINDO ***************");
        System.out.println();
    }
}
class App {

    private final String nome;
    private final Scanner entrada;
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();



    public App(String nome) {
        this.nome = nome;
        this.entrada = new Scanner(System.in);
    }

    public Scanner getEntrada() {
        return entrada;
    }

    public void menu() {
        int opcao;

        do {
            System.out.println();
            System.out.println("*************** " + nome + " ***************");
            System.out.println();
            System.out.println(">>> 1. Cadastrar Usuario");
            System.out.println(">>> 2. Listar Usuarios");
            System.out.println(">>> 3. Sair");

            System.out.print(">>>>> ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao!= 3);
    }

    public void cadastrarUsuario() {
        int user;

        System.out.println();

        System.out.print("Nome: ");
        String nome = getEntrada().nextLine();

        System.out.print("Telefone: ");
        String telefone = getEntrada().nextLine();

        System.out.print("CPF: ");
        String cpf = getEntrada().nextLine();

        System.out.print("Email: ");
        String email = getEntrada().nextLine();

        System.out.print("Senha: ");
        String senha = getEntrada().nextLine();

        System.out.println("Tipo de Usuario: ");
        System.out.println(">>> 1. Administrador");
        System.out.println(">>> 2. Funcionario");
        System.out.println(">>> 3. Cliente");
        System.out.print(">>>>> ");
        user = getEntrada().nextInt();

        switch (user) {
            case 1: // Administrador
                Administrador administrador = new Administrador(nome, telefone, cpf, email, senha, "Administrador");
                administradores.add(administrador);
                System.out.println("Administrador cadastrado com sucesso!");
                break;
            case 2: // Funcionario
                Funcionario funcionario = new Funcionario(nome, telefone, cpf, email, senha, "Funcionario");
                funcionarios.add(funcionario);
                System.out.println("Funcionario cadastrado com sucesso!");
                break;
            case 3: // Cliente
                Cliente cliente = new Cliente(nome, telefone, cpf, email, senha, "Cliente");
                clientes.add(cliente);
                System.out.println("Cliente cadastrado com sucesso!");
                break;
            default:
        }
    }

    public void listarUsuarios() {
        System.out.println();
        System.out.println("*************** Lista de Usuarios ***************");
        System.out.println();

        // Lista Administradores
        System.out.println(">> Administradores:");
        if (administradores.isEmpty()) {
            System.out.println("Nenhum administrador cadastrado.");
        } else {
            for (int i = 0; i < administradores.size(); i++) {
                System.out.println((i + 1) + " - " + administradores.get(i).getNome() + " (Administrador)");
            }
        }

        // Lista Clientes
        System.out.println("\n>> Clientes:");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println((i + 1) + " - " + clientes.get(i).getNome() + " (Cliente)");
            }
        }

        // Lista Funcionários
        System.out.println("\n>> Funcionários:");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (int i = 0; i < funcionarios.size(); i++) {
                System.out.println((i + 1) + " - " + funcionarios.get(i).getNome() + " (Funcionário)");
            }
        }
    }

    public void cadastrarServico() {

    }
}

class Usuario {
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private String senha;
    private String tipoUsuario;
    private final ArrayList<Usuario> usuarios = null;


    public Usuario(String nome, String telefone, String cpf, String email, String senha, String tipoUsuario) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}

class Administrador extends Usuario {
    public Administrador(String nome, String telefone, String cpf, String email, String senha, String tipoUsuario) {
        super(nome, telefone, cpf, email, senha, "Administrador");
    }
}

class Funcionario extends Usuario {
    public Funcionario(String nome, String telefone, String cpf, String email, String senha, String tipoUsuario) {
        super(nome, telefone, cpf, email, senha, "Funcionario");
    }
}

class Cliente extends Usuario {
    public Cliente(String nome, String telefone, String cpf, String email, String senha, String tipoUsuario) {
        super(nome, telefone, cpf, email, senha, "Cliente");
    }
}

class Servico {

    private final ArrayList<Servico> servicos;

    Servico(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }
}

class Agendamento extends Servico {
    Agendamento(ArrayList<Servico> servicos) {
        super(servicos);
    }
}

