package com.todoapp;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Tambah Tugas");
        System.out.println("2. Lihat Semua Tugas");
        System.out.println("3. Tandai Tugas Selesai");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
    }

    private static void addTask() {
        System.out.print("Masukkan nama tugas: ");
        String taskName = scanner.nextLine();
        tasks.add(new Task(taskName));
        System.out.println("Tugas berhasil ditambahkan.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Tidak ada tugas.");
        } else {
            System.out.println("\nDaftar Tugas:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).toString());
            }
        }
    }

    private static void completeTask() {
        viewTasks();
        System.out.print("Masukkan nomor tugas yang sudah selesai: ");
        int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.get(taskNumber).markAsCompleted();
            System.out.println("Tugas berhasil ditandai sebagai selesai.");
        } else {
            System.out.println("Nomor tugas tidak valid.");
        }
    }
}
