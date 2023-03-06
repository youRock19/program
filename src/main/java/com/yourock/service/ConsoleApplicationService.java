package com.yourock.service;

import com.yourock.behavior.PageCount;
import com.yourock.request.BaseData;

public class ConsoleApplicationService extends BaseService {
    public ConsoleApplicationService(BaseData baseData, PageCount ...pageCount) {
        super(baseData, pageCount);
    }

    public void display() {
        System.out.println("Documents: " + getCountFiles());
        System.out.println("Pages " + getCountPages());
    }
}
