package com.yourock.behavior;

import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import com.yourock.request.BaseData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
                    .mapToLong(path -> {
                        try (PDDocument document= PDDocument.load(new File(path))) {
                            return document.getNumberOfPages();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
