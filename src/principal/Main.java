package principal;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    Conversor de Moedas                     
                    Selecione uma das opções abaixo:                      
                    1 - Dólar > Real                                     
                    2 - Real > Dólar 
                    0 - Sair                                   
                    """;
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();
            String moedaBase = "";
            String moedaFinal = "";
            switch (opcao) {
                case 1:
                    moedaBase = "USD";
                    moedaFinal = "BRL";
                    break;
                case 2:
                    moedaBase = "BRL";
                    moedaFinal = "USD";
                    break;
                case 0:
                    System.out.println("Saindo");
                    continue;
                default:
                    System.out.println("Opção inválida");
                    continue;
            }

            System.out.println("Informe o valor que deseja converter:");
            var valor = scanner.nextLine();
            Conversor conversor = new Conversor();
            Gerador gerador = new Gerador();

            DadosMoeda dadosMoeda = conversor.converterMoedas(moedaBase, moedaFinal, valor);
            gerador.salvaJson(dadosMoeda);
            if (opcao == 1) {
                System.out.println("O valor de " + valor + " dólares, convertido é equivalente a " + dadosMoeda + " reais");
            } else {
                System.out.println("O valor de " + valor + " reais, convertido é equivalente " + dadosMoeda + " dólares");
            }
        }
    }
}