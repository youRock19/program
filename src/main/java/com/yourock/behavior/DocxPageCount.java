package com.yourock.behavior;

import com.aspose.words.Document;
import lombok.RequiredArgsConstructor;
import com.yourock.request.BaseData;
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
                    .mapToLong(path -> {
                        try {
                            Document doc = new Document(path);
                            return doc.getPageCount();
                        } catch (Exception e) {
                            throw new RuntimeException();
                        }
                    })
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
