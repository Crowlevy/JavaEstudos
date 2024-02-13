import java.util.Scanner;

public class Calculadora {
    static class Operadores {
        static int Ad(int number1, int number2) {
            return number1 + number2;
        }

        static int Sub(int number1, int number2) {
            return number1 - number2;
        }

        static int Mult(int number1, int number2) {
            return number1 * number2;
        }

        static int Div(int number1, int number2) {
            return number1 / number2;
        }

        static double Fib(int n) {
            if (n <= 1) {
                return n;
            }
            return Fib(n - 1) + Fib(n - 2);
        }

        static String CDC(String frase, int key) {
            String fraseCod = "";
            for (int i = 0; i < frase.length(); i++) {
                char crth = frase.charAt(i);
                if (Character.isLetter(crth)) {
                    char charCod = (char) ((((crth - 'a') + key + 26) % 26) + 'a');
                    fraseCod += Character.isUpperCase(crth) ? Character.toUpperCase(charCod) : charCod;

                } else {
                    fraseCod += crth;
                }
            }
            return fraseCod.toString();
        }

        static String DCDC(String frase, int key) {
            String fraseDec = "";
            for (int i = 0; i < frase.length(); i++) {
                char crth = frase.charAt(i);
                if (Character.isLetter(crth)) {
                    char msgDec = (char) ((((crth - 'a') - key + 26) % 26) + 'a');
                    fraseDec += Character.isUpperCase(crth) ? Character.isUpperCase(msgDec) : msgDec;
                } else {
                    fraseDec += i;
                }
            }
            return fraseDec;
        }
    }

    public static void main(String[] args) {
        String[] opc = {"1-ADIÇÃO", "2-SUBTRAÇÃO", "3-MULTIPLICAÇÃO", "4-DIVISÃO", "5-FIBONACCI", "6-CIFRA DE CESÁR"};
        while (true) {
            for (int n = 0; n < opc.length; n++) {
                System.out.println(opc[n]);
            }
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();
            if (escolha >= 1 && escolha < opc.length + 1) {
                switch (escolha) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        // OPERAÇÕES SIMPLES
                        System.out.println("Coloque o primeiro número: ");
                        int n1 = scanner.nextInt();
                        System.out.println("Coloque o segundo número: ");
                        int n2 = scanner.nextInt();
                        if (escolha == 1) {
                            System.out.println("RESULTADO: " + Operadores.Ad(n1, n2));
                        } else if (escolha == 2) {
                            System.out.println("RESULTADO: " + Operadores.Sub(n1, n2));
                        } else if (escolha == 3) {
                            System.out.println("RESULTADO: " + Operadores.Mult(n1, n2));
                        } else if (escolha == 4) {
                            System.out.println("RESULTADO: " + Operadores.Div(n1, n2));
                        }
                        break;
                        //SEQUÊNCIA DE FIBONACCI
                    case 5:
                        System.out.println("Coloque o número: ");
                        int NumberSeq = scanner.nextInt();
                        System.out.println(Operadores.Fib(NumberSeq));
                        break;
                        //CODIFICAR E DECODIFICAR
                    case 6:
                        System.out.println("1-CODIFICAR \n2-DECODIFICAR");

                        int esc = scanner.nextInt();
                        if (esc == 1) {
                            System.out.println("Coloque uma frase");
                            String msg = scanner.next();
                            System.out.println("Coloque quantos caracteres deseja pular");
                            int key = scanner.nextInt();
                            System.out.println(Operadores.CDC(msg, key));
                        } else if(esc == 2) {
                        System.out.println("Coloque a frase que deseja descriptografar");
                        String msg = scanner.next();
                        System.out.println("Frases");
                        for (int i = 0; i < 26; i++) {
                            System.out.println(Operadores.DCDC(msg, i));
                        }
                    }
                    break;
                    default:
                        System.out.println("OPÇÃO INVÁLIDA");
                        break;
                }
            } else {
                System.out.println("OPÇÃO INVÁLIDA");
            }
            System.out.println("DESEJA SAIR S/N");
            String opcUser = scanner.next().toUpperCase();
            if (opcUser != "S"){
                System.out.println("OH NÃOOOOOO");
                break;
            }
        }
    }
}
