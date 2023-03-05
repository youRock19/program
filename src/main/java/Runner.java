import com.yourock.behavior.DocxPageCount;
import com.yourock.behavior.PdfPageCount;
import org.apache.pdfbox.pdmodel.PDDocument;
import request.BaseData;
import request.ConsoleBaseData;
import service.ConsoleApplicationService;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class
Runner {
    public static void main(String[] args) {

        ConsoleBaseData consoleBaseData = ConsoleBaseData.getInstance();

        ConsoleApplicationService service = new ConsoleApplicationService(consoleBaseData,
                new PdfPageCount(consoleBaseData), new DocxPageCount(consoleBaseData));

        service.display();


    }
}