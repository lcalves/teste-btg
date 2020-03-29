package br.com.bancobtg;

import br.com.bancobtg.exceptions.AccountNotFoundException;
import br.com.bancobtg.exceptions.InsufficientBalanceException;
import br.com.bancobtg.service.MoneyBalance;
import br.com.bancobtg.service.MoneyTransfer;
import br.com.bancobtg.service.Operations;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
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
            System.out.println("2 - Consultar Saldo");

            try {
                option = scann.nextInt();
                Operations.processesOperation(option);
            } catch (InputMismatchException e) {
                logger.error("Valor Digitado errado.");
                scann = new Scanner(System.in);
                option = 2;
            }

        } while (option != 0);

        scann.close();

    }






}
