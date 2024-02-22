package controler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.MedioTransporte;
import modelo.Parqueadero;

public class AplMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el medio de transporte:");
        System.out.println("1. Bicicleta");
        System.out.println("2. Moto");
        System.out.println("3. Automóvil");
        int codigoMedioTransporte = scanner.nextInt();

        System.out.println("Digite la duración del servicio en minutos:");
        int duracionServicio = scanner.nextInt();

        MedioTransporte medioTransporte;
        switch (codigoMedioTransporte) {
            case 1:
                medioTransporte = new Bicicleta();
                break;
            case 2:
                medioTransporte = new Moto();
                break;
            default:
                medioTransporte = new Automovil();
                break;
        }

        Parqueadero parqueadero = new Parqueadero(medioTransporte, duracionServicio);

        System.out.println("Factura: ");
        System.out.println("Nombre del establecimiento: TruluParking");
        System.out.println("Medio de transporte: " + medioTransporte.getDescripcion());
        System.out.println("Duración del servicio: " + duracionServicio + " minutos");
        System.out.println("Valor por minuto: " + medioTransporte.getValorPorMinuto() + " pesos");
        System.out.println("Valor total del servicio: " + parqueadero.calcularValorTotal() + " pesos");
        System.out.println("IVA (19%): " + parqueadero.calcularIva() + " pesos");
        System.out.println("Valor total del servicio a pagar aproximado a múltiplos de 50: " + parqueadero.calcularValorTotalAPagar() + " pesos");

        System.out.println("Ingrese la cantidad a pagar:");
        int cantidadPagar = scanner.nextInt();

        double sobra = cantidadPagar - parqueadero.calcularValorTotalAPagar();

        if (sobra > 0) {
            System.out.println("Sobrante: " + sobra + " pesos");
        } else if (sobra < 0) {
            System.out.println("Devuelta: " + Math.abs(sobra) + " pesos");
        } else {
            System.out.println("No hay sobra ni devuelta");
        }

        List<Integer> billetes = new ArrayList<>();
        List<Integer> monedas = new ArrayList<>();

        int billetes500 = (int) (sobra / 500);
        sobra = sobra % 500;
        int billetes200 = (int) (sobra / 200);
        sobra = sobra % 200;
        int billetes100 = (int) (sobra / 100);
        sobra = sobra % 100;
        int billetes50 = (int) (sobra / 50);
        sobra = sobra % 50;
        int monedas2000 = (int) (sobra / 2000);
        sobra = sobra % 2000;
        int monedas1000 = (int) (sobra / 1000);
        sobra = sobra % 1000;
        int monedas500 = (int) (sobra / 500);
        sobra = sobra % 500;
        int monedas200 = (int) (sobra / 200);
        sobra = sobra % 200;
        int monedas100 = (int) (sobra / 100);
        sobra = sobra % 100;
        int monedas50 = (int) (sobra / 50);
        sobra = sobra % 50;
        int monedas20 = (int) (sobra / 20);
        sobra = sobra % 20;
        int monedas10 = (int) (sobra / 10);
        sobra = sobra % 10;
        int monedas5 = (int) (sobra / 5);
        sobra = sobra % 5;

        if (billetes500 > 0) {
            billetes.add(billetes500);
        }
        if (billetes200 > 0) {
            billetes.add(billetes200);
        }
        if (billetes100 > 0) {
            billetes.add(billetes100);
        }
        if (billetes50 > 0) {
            billetes.add(billetes50);
        }
        if (monedas2000 > 0) {
            monedas.add(monedas2000);
        }
        if (monedas1000 > 0) {
            monedas.add(monedas1000);
        }
        if (monedas500 > 0) {
            monedas.add(monedas500);
        }
        if (monedas200 > 0) {
            monedas.add(monedas200);
        }
        if (monedas100 > 0) {
            monedas.add(monedas100);
        }
        if (monedas50 > 0) {
            monedas.add(monedas50);
        }
        if (monedas20 > 0) {
            monedas.add(monedas20);
        }
        if (monedas10 > 0) {
            monedas.add(monedas10);
        }
        if (monedas5 > 0) {
            monedas.add(monedas5);
        }

        System.out.println("Billetes: " + billetes);
        System.out.println("Monedas: " + monedas);

        scanner.close();
    }
}
