package com.yourock.behavior;

import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import request.BaseData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
//исправить зависимость от ConsoleBaseData
@RequiredArgsConstructor
public class PdfPageCount implements PageCount {
    private final BaseData baseData;

    @Override
    public Long getCountPages(){
        Long result = 0L;
        try {
            result = Files.list(baseData.getPath())
                    .map(path -> path.toString())
                    .filter(path -> path.endsWith(".pdf"))
                    .map(path -> {
                        try {
                            return PDDocument.load(new File(path));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .mapToLong(document -> document.getNumberOfPages())
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
