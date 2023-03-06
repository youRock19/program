package com.yourock.request;

import lombok.Getter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@Getter
public class ConsoleBaseData implements BaseData {
    private volatile static ConsoleBaseData instance;
    private Path path;

    private ConsoleBaseData() {
        setPath();
    }

    public static ConsoleBaseData getInstance() {
        if (instance == null) {
            synchronized (ConsoleBaseData.class) {
                if (instance == null) {
                    instance = new ConsoleBaseData();
                }
            }
        }
        return instance;
    }


    public void setPath() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isEnabled = true;
            System.out.println("Please enter directory name or 'exit' to exit");
            do {
                String data = scanner.nextLine();
                this.path = Paths.get(data);
                if (data.equals("exit")) {
                    isEnabled = false;
                } else if (this.path.isAbsolute() && Files.isDirectory(this.path)) {
                    isEnabled = false;
                } else {
                    System.out.println("This directory is not exist, try again or 'exit' to exit");
                }
            } while ((isEnabled));
        }
    }
}
