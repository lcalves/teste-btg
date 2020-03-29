package br.com.teste.console;

import br.com.teste.exceptions.AccountNotFoundException;
import br.com.teste.exceptions.InsufficientBalanceException;
import br.com.teste.service.MoneyTransferService;
import org.apache.log4j.Logger;

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
            default:
                System.err.println("Opção inválida.");
                break;

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

        MoneyTransferService transfer = new MoneyTransferService();

        try {
            transferred = transfer.transfer(origemAccountId, destinyAccountId, amount);

        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            logger.error("Não foi possível realizar a transferência. " + e.getMessage());
            System.err.println("Não foi possível realizar a transferência. " + e.getMessage());
        }

        if (transferred) {
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Não foi possível realizar a transferência.");
        }

    }

    private static boolean amountInValid(Double amount) {
        return amount.compareTo(0d) == 0 || amount.compareTo(0d) == -1;
    }
}
