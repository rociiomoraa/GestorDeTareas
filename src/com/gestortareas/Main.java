package com.gestortareas;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenidx al gestor de tareas!");

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        ArrayList<String> tareas = new ArrayList<>();

        cargarTareasDesdeArchivo(tareas);

        while (!salir) {
            System.out.println("\n--- Gestor de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver tareas (ordenadas)");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Desmarcar tarea completada");
            System.out.println("6. Salir");
            System.out.print("\nElige una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Ingresa un número.");
                scanner.nextLine();
                continue;
            }

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarTarea(scanner, tareas);
                    pausar(scanner);
                    break;
                case 2:
                    mostrarTareas(tareas, true);
                    pausar(scanner);
                    break;
                case 3:
                    marcarComoCompletada(scanner, tareas);
                    pausar(scanner);
                    break;
                case 4:
                    eliminarTarea(scanner, tareas);
                    pausar(scanner);
                    break;
                case 5:
                    desmarcarTarea(scanner, tareas);
                    pausar(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, inténtalo de nuevo.");
                    pausar(scanner);
            }
        }
        scanner.close();
    }

    public static void agregarTarea(Scanner scanner, ArrayList<String> tareas) {
        System.out.print("Escribe una nueva tarea: ");
        String tarea = scanner.nextLine();

        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String tareaConFecha = tarea + " (Agregada el: " + fecha + ")";

        tareas.add(tareaConFecha);
        guardarTareasEnArchivo(tareas);
        System.out.println("Tarea agregada con éxito!");
    }

    public static void mostrarTareas(ArrayList<String> tareas, boolean ordenar) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista.");
            return;
        }

        ArrayList<String> listaTareas = new ArrayList<>(tareas);
        if (ordenar) {
            Collections.sort(listaTareas, (t1, t2) -> Boolean.compare(t1.startsWith("✔ "), t2.startsWith("✔ ")));
        }

        System.out.println("\n--- Lista de Tareas ---");
        for (int i = 0; i < listaTareas.size(); i++) {
            System.out.println((i + 1) + ". " + listaTareas.get(i));
        }
    }

    public static void marcarComoCompletada(Scanner scanner, ArrayList<String> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista para marcar como completadas.");
            return;
        }

        mostrarTareas(tareas, false);

        System.out.print("Elige el número de la tarea que deseas marcar como completada: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingresa un número.");
            scanner.nextLine();
            return;
        }
        int numeroTarea = scanner.nextInt();
        scanner.nextLine();

        if (numeroTarea < 1 || numeroTarea > tareas.size()) {
            System.out.println("Número inválido. Inténtalo de nuevo.");
            return;
        }

        String tareaSeleccionada = tareas.get(numeroTarea - 1);

        if (!tareaSeleccionada.startsWith("✔ ")) {
            tareas.set(numeroTarea - 1, "✔ " + tareaSeleccionada);
            guardarTareasEnArchivo(tareas);
            System.out.println("Tarea marcada como completada.");
        } else {
            System.out.println("Esta tarea ya estaba marcada como completada.");
        }
    }

    public static void eliminarTarea(Scanner scanner, ArrayList<String> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista para eliminar.");
            return;
        }

        mostrarTareas(tareas, false);

        System.out.print("Elige el número de la tarea que deseas eliminar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingresa un número.");
            scanner.nextLine();
            return;
        }
        int numeroTarea = scanner.nextInt();
        scanner.nextLine();

        if (numeroTarea < 1 || numeroTarea > tareas.size()) {
            System.out.println("Número inválido. Inténtalo de nuevo.");
            return;
        }

        String tareaEliminada = tareas.remove(numeroTarea - 1);
        guardarTareasEnArchivo(tareas);
        System.out.println("Tarea eliminada: " + tareaEliminada);
    }

    public static void guardarTareasEnArchivo(ArrayList<String> tareas) {
        try (FileWriter writer = new FileWriter("tareas.txt")) {
            for (String tarea : tareas) {
                writer.write(tarea.replace("\n", " ") + "|\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error al guardar las tareas: " + e.getMessage());
        }
    }

    public static void cargarTareasDesdeArchivo(ArrayList<String> tareas) {
        try (BufferedReader reader = new BufferedReader(new FileReader("tareas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                tareas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("No hay tareas previas guardadas.");
        }
    }

    public static void pausar(Scanner scanner) {
        System.out.println("\nPresiona Enter para volver al menú...");
        scanner.nextLine();
    }

    public static void desmarcarTarea(Scanner scanner, ArrayList<String> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista para desmarcar.");
            return;
        }
        mostrarTareas(tareas, false);

        System.out.print("Elige el número de la tarea que deseas desmarcar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingresa un número.");
            scanner.nextLine();
            return;
        }
        int numeroTarea = scanner.nextInt();
        scanner.nextLine();

        if (numeroTarea < 1 || numeroTarea > tareas.size()) {
            System.out.println("Número inválido. Inténtalo de nuevo.");
            return;
        }

        String tareaSeleccionada = tareas.get(numeroTarea - 1);

        if (tareaSeleccionada.startsWith("✔ ")) {
            tareas.set(numeroTarea - 1, tareaSeleccionada.substring(2));
            guardarTareasEnArchivo(tareas);
            System.out.println("Tarea desmarcada correctamente.");
        } else {
            System.out.println("Esta tarea no está marcada como completada.");
        }
    }
}
