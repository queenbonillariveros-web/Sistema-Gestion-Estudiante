
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static int totalEstudiantes = 0;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        boolean banderaSalir = false;

        while (!banderaSalir) {

            System.out.println("\n================================");
            System.out.println(" SISTEMA DE GESTION DE ESTUDIANTES");
            System.out.println("================================");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante por ID");
            System.out.println("4. Salir");
            System.out.println("================================");
            System.out.print("Seleccione una opcion: ");

            String opcion = teclado.nextLine();

            switch (opcion) {

                case "1":
                    agregarEstudiante();
                    break;

                case "2":
                    mostrarEstudiantes();
                    break;

                case "3":
                    buscarEstudiante();
                    break;

                case "4":
                    banderaSalir = true;
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }

        teclado.close();
    }

    public static int leerEntero(String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    public static void agregarEstudiante() {

        System.out.println("\n--- AGREGAR ESTUDIANTE ---");

        int id = leerEntero("Ingrese el ID: ");

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                System.out.println("El ID ya esta registrado.");
                return;
            }
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre es obligatorio.");
            return;
        }

        int edad = leerEntero("Ingrese la edad: ");

        if (edad <= 0) {
            System.out.println("La edad debe ser mayor que cero.");
            return;
        }

        System.out.print("Ingrese el programa academico: ");
        String programa = teclado.nextLine().trim();

        if (programa.isEmpty()) {
            System.out.println("El programa es obligatorio.");
            return;
        }

        Estudiante nuevo = new Estudiante(id, nombre, edad, programa);

        estudiantes.add(nuevo);
        totalEstudiantes++;

        System.out.println("Estudiante registrado exitosamente.");
    }

    public static void mostrarEstudiante(Estudiante estudiante) {

        System.out.println("------------------------------");
        System.out.println("ID: " + estudiante.getId());
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Edad: " + estudiante.getEdad());
        System.out.println("Programa: " + estudiante.getPrograma());
    }

    public static void mostrarEstudiantes() {

        System.out.println("\n--- LISTA DE ESTUDIANTES ---");

        if (totalEstudiantes == 0) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Estudiante estudiante : estudiantes) {
                mostrarEstudiante(estudiante);
            }

            System.out.println("Total de estudiantes: " + totalEstudiantes);
        }
    }

    public static void buscarEstudiante() {

        System.out.println("\n--- BUSCAR ESTUDIANTE ---");

        int idBuscado = leerEntero("Ingrese el ID que desea buscar: ");

        boolean encontrado = false;

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getId() == idBuscado) {
                System.out.println("Estudiante encontrado:");
                mostrarEstudiante(estudiante);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Busqueda realizada correctamente.");
        } else {
            System.out.println("No se encontro un estudiante con ese ID.");
        }
    }
}

class Estudiante {

    private int id;
    private String nombre;
    private int edad;
    private String programa;

    public Estudiante(int id, String nombre, int edad, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.programa = programa;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPrograma() {
        return programa;
    }
}
