package com.yourock;

import com.yourock.behavior.DocxPageCount;
import com.yourock.behavior.PdfPageCount;
import com.yourock.request.ConsoleBaseData;
import com.yourock.service.ConsoleApplicationService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class
Runner {
    public static void main(String[] args) throws IOException {

        ConsoleBaseData consoleBaseData = ConsoleBaseData.getInstance();

        ConsoleApplicationService service = new ConsoleApplicationService(consoleBaseData,
                new PdfPageCount(consoleBaseData), new DocxPageCount(consoleBaseData));

        service.display();

    }
}