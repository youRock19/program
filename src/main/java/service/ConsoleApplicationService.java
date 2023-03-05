package service;

import com.yourock.behavior.DocxPageCount;
import com.yourock.behavior.PageCount;
import com.yourock.behavior.PdfPageCount;
import request.BaseData;
import request.ConsoleBaseData;

public class ConsoleApplicationService extends BaseService {
    public ConsoleApplicationService(BaseData baseData, PageCount ...pageCount) {
        super(baseData, pageCount);
    }

    public void display() {
        System.out.println("Documents: " + getCountFiles());
        System.out.println("Pages " + getCountPages());
    }
}
