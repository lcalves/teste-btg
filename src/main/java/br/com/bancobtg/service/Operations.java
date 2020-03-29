package br.com.bancobtg.service;

import br.com.bancobtg.exceptions.AccountNotFoundException;
import br.com.bancobtg.exceptions.InsufficientBalanceException;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Operations {

    final static Logger logger = Logger.getLogger(Operations.class);

    public static void processesOperation(int option) {

        switch (option) {
            case 0:
                break;
            case 1:
                transferOperation();
                break;
            case 2:
                balanceOperation();
                break;
        }

    }

    public static void balanceOperation() {

        int accountId = 0;

        Scanner scann = new Scanner(System.in);

        while (accountId == 0) {
            try {
                System.out.println("Digite o ID da conta de origem");
                accountId = scann.nextInt();
            } catch (InputMismatchException e) {
                scann = new Scanner(System.in);
                logger.error("Valor do ID da conta inválido.");
                System.err.println("Valor do ID da conta inválido.");
            }
        }

        MoneyBalance moneyBalance = new MoneyBalance();

        try {
            BigDecimal balance = moneyBalance.getBalance(accountId);
            System.out.printf("Saldo: R$ %.2f\n", balance);
        } catch (AccountNotFoundException e) {
            logger.error(e.getMessage());
            System.err.println("");
        }

    }

    public static void transferOperation() {

        Scanner scann = new Scanner(System.in);

        boolean transferred = false;

        int origemAccountId = 0;

        while (origemAccountId == 0) {
            try {
                System.out.println("Digite o ID da conta de origem");
                origemAccountId = scann.nextInt();
            } catch (InputMismatchException e) {
                scann = new Scanner(System.in);
                logger.error("Valor do ID da conta de origem inválido.");
                System.err.println("Valor do ID da conta de origem inválido.");
            }
        }

        int destinyAccountId = 0;

        while (destinyAccountId == 0) {
            try {
                System.out.println("Digite o ID da conta de destino");
                destinyAccountId = scann.nextInt();
            } catch (InputMismatchException e) {
                scann = new Scanner(System.in);
                logger.error("Valor do ID da conta do destinatário inválido.");
                System.err.println("Valor do ID da conta do destinatário inválido.");
            }
        }

        Double amount = 0d;

        while (amountInValid(amount)) {
            try {
                System.out.println("Digite o valor da transferencia");
                amount = scann.nextDouble();
            } catch (InputMismatchException e) {
                scann = new Scanner(System.in);
                logger.error("Valor digitádo é inválido.");
                System.err.println("Valor digitádo é inválido.");
            }

            if (amountInValid(amount)) {
                System.err.println("Valor inválio para transferencia");
            }
        }

        MoneyTransfer transfer = new MoneyTransfer();

        try {
            transferred = transfer.transfer(origemAccountId, destinyAccountId, amount);

        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            logger.error("Não foi possível realizar a transferência. " + e.getMessage());
            System.err.println("Não foi possível realizar a transferência. " + e.getMessage());
        }

        if (transferred) {
            System.out.println("Transferencia realizada com sucesso.");
        }


    }

    private static boolean amountInValid(Double amount) {
        return amount.compareTo(0d) == 0 || amount.compareTo(0d) == -1;
    }
}
