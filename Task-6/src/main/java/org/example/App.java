    
    package org.example;

    import java.util.Scanner;
    //Ещё в 4 задании сделал обработку, что нельзя делить на 0
    // Интерфейс для операций калькулятора
    interface Operation {
        double calculate(double a, double b);
    }

    // Класс для сложения
    class Addition implements Operation {
        @Override
        public double calculate(double a, double b) {
            return a + b;
        }
    }

    // Класс для вычитания
    class Subtraction implements Operation {
        @Override
        public double calculate(double a, double b) {
            return a - b;
        }
    }

    // Класс для умножения
    class Multiplication implements Operation {
        @Override
        public double calculate(double a, double b) {
            return a * b;
        }
    }

    // Класс для деления
    class Division implements Operation {
        @Override
        public double calculate(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Деление на ноль невозможно.");
            }
            return a / b;
        }
    }

    // Класс калькулятора
    class Calculator {
        private double result;

        public void setResult(double result) {
            this.result = result;
        }

        public double getResult() {
            return result;
        }

        public double performOperation(Operation operation, double a, double b) {
            result = operation.calculate(a, b);
            return result;
        }
    }

    // Основной класс
    public class App {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Calculator calculator = new Calculator();

            while (true) {
                System.out.print("Введите первое число (или 'exit' для выхода): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                double number1;
                try {
                    number1 = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
                    continue;
                }

                System.out.print("Введите второе число: ");
                double number2 = Double.parseDouble(scanner.nextLine());

                System.out.println("Выберите операцию: +, -, *, /");
                String operator = scanner.nextLine();

                Operation operation = null;
                switch (operator) {
                    case "+":
                        operation = new Addition();
                        break;
                    case "-":
                        operation = new Subtraction();
                        break;
                    case "*":
                        operation = new Multiplication();
                        break;
                    case "/":
                        operation = new Division();
                        break;
                    default:
                        System.out.println("Некорректный оператор. Попробуйте еще раз.");
                        continue;
                }

                try {
                    double result = calculator.performOperation(operation, number1, number2);
                    System.out.printf("Результат: %.2f%n", result);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            }
            scanner.close();


        }
    }