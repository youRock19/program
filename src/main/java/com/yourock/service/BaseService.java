package com.yourock.service;

import com.yourock.behavior.PageCount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.yourock.request.BaseData;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public abstract class BaseService {
    private final BaseData baseData;
    private final PageCount[] pageCounts;
    //подсчет количества файлов в пакпе
    public Long getCountFiles() {
        try {
            return Files.list(baseData.getPath()).filter(path -> Files.isRegularFile(path)).count();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    //делегирование вызова метода подсчета страниц в классы поведения
    public Long getCountPages() {
        return Arrays.stream(pageCounts).mapToLong(pageCount -> pageCount.getCountPages()).sum();
    }


}
