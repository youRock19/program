package com.yourock.behavior;

import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import request.BaseData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
@RequiredArgsConstructor
public class DocxPageCount implements PageCount {

    private final BaseData baseData;
    @Override
    public Long getCountPages() {
        Long result = 0L;
        try {
            result = Files.list(baseData.getPath())
                    .map(path -> path.toString())
                    .filter(path -> path.endsWith(".docx"))
                    .map(path -> {
                        try {
                            return new XWPFDocument(new FileInputStream(new File(path)));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .mapToLong(document -> document.getProperties().getExtendedProperties().getPages())
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
