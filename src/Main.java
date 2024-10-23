import com.aluracursos.conversormonedas.utils.CurrencyConversor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables
        Scanner lecture = new Scanner(System.in);
        int currOption = 0;

        System.out.println("************************************************************");
        System.out.println("Bienvenido/a al conversor de monedas");
        System.out.println("A continuación las concurrencias disponibles para convertir:\n");

        // Inicia un ciclo while en cuál sale hasta que seleccionen la opción salir
        while (currOption != 12) {
            // Entra en bloque try-catch para manejar los errores
            try {
                // Muestra las opciones del menú
                mostrarMenu();

                // Lee la opción del usuario
                System.out.println("Ingrese la opcion:");
                currOption = Integer.valueOf(lecture.nextLine());

                // Si la opción seleccionada existe entra las funciones para consultar la conversión,
                // sino, manda imprimir  que no existe esa opción.
                if (currOption > 0 && currOption <= 12) {

                    System.out.println("Ingrese el valor que desea convertir");
                    // Leemos el valor del usuario que quiere convertir
                    Double valueToConvert = Double.valueOf(lecture.nextLine());

                    // Creamos un objeto de la clase CurrencyConversor con la opción seleccionada
                    CurrencyConversor currencyConversor = new CurrencyConversor(currOption);

                    // Consultamos la api para realizar la conversión del valor ingresado
                    String convertedValue = currencyConversor.pairConvertion(valueToConvert);
                    System.out.printf("El valor $%f (%s) corresponde al valor final de ==> $%s (%s)\n",
                            valueToConvert,
                            currencyConversor.getBaseCode(),
                            convertedValue,
                            currencyConversor.getTargetCode());

                    System.out.println("Último día de actualización: " + currencyConversor.getLastUpdate());

                } else {
                    System.out.println("La opción " + currOption + " no está disponible en el menú de opciones.");
                }
            } catch (NumberFormatException e) {
                System.out.println("La opción recibida no es un número válido.");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Hubo un error al consultar el conversor.");
            }
        }

        System.out.println("Gracias por usar el conversor de monedas! :) Hasta pronto.");
    }


    public static void mostrarMenu() {

        System.out.println("""
                \n1) Pesos argentinos (ARS) ==> Dólares americanos (USD)
                2) Dólares americanos (USD) ==> Pesos argentino (ARS)
                3) Reales (BRL) ==> Dólares americanos (USD)
                4) Dólares americanos (USD) ==> Reales (BRL)
                5) Pesos chilenos (CLP) ==> Dólares americanos (USD)
                6) Dólares americanos (USD)  ==> Pesos chilenos (CLP)
                7) Boliviano boliviano (BOB) ==> Peso colombiano (COP)
                8) Pesos mexicanos (MXN) ==> Dólares americanos (USD)
                9) Dólares americanos (USD) ==> Pesos mexicanos (MXN)
                10) Pesos chilenos (CLP) ==> Pesos mexicanos (MXN)
                11) Pesos mexicanos (MXN)  ==> Pesos chilenos (CLP)
                12) Salir
                """);
    }
}
