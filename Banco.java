// Excepción personalizada
class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String message) {
        super(message);
    }
}

class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void retirar(double cantidad) throws FondosInsuficientesException {
        if (cantidad > saldo) {
            throw new FondosInsuficientesException("No tienes suficientes fondos para realizar este retiro.");
        }
        saldo -= cantidad;
        System.out.println("Has retirado: " + cantidad + ". Saldo restante: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Banco {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(500.0);
        
        try {
            System.out.println("Saldo inicial: " + cuenta.getSaldo());
            cuenta.retirar(600.0); // Intentamos retirar más de lo que hay en la cuenta
        } catch (FondosInsuficientesException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}