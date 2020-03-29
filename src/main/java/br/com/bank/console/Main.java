package br.com.bank.console;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        int option = 1;
        Scanner scann = new Scanner(System.in);
        do {

            System.out.println("Digite o número conforme a operação que deseja realizar.");
            System.out.println("0 - Sair");
            System.out.println("1 - Transferencia");
            System.out.println("2 - Consultar Saldo");

            ViewOperations viewOperations = new ViewOperations();

            try {

                option = scann.nextInt();

                if (isValidOperation(option)) {
                    viewOperations.processesOperation(option);
                }

            } catch (InputMismatchException | IllegalArgumentException e) {
                LOGGER.error("Valor Digitado errado. " + e.getMessage(), e);
                System.err.println("Opção invalida. " + "\n" + e.getMessage());
                scann = new Scanner(System.in);
                option = -1;
            }

        } while (option != 0);

        scann.close();

    }

    private static boolean isValidOperation(int option) {
        return option == 1 || option == 2;
    }

}
