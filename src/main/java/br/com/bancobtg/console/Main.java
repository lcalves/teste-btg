package br.com.bancobtg.console;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        int option = 1;
        Scanner scann = new Scanner(System.in);
        do {

            System.out.println("Digite o número conforme a operação que deseja realizar.");
            System.out.println("0 - Sair");
            System.out.println("1 - Transferencia");

            try {
                option = scann.nextInt();
                Operations.processesOperation(option);
            } catch (InputMismatchException e) {
                logger.error("Valor Digitado errado.");
                System.err.println("Valor Digitado erradoa.");
                scann = new Scanner(System.in);
                option = 2;
            }

        } while (option != 0);

        scann.close();

    }

}
