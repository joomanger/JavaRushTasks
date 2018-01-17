package com.javarush.task.task31.task3111;


import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();


    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        if (partOfName != null) {
            if (file.getFileName().toString().contains(partOfName)) {
                foundFiles.add(file);
            }
        }

        if (!partOfContent.isEmpty()&&!foundFiles.contains(file)) {
            try {
                try (Stream<String> stream = Files.lines(file)) {
                    List<String> list = stream
                            .filter(line -> line.contains(partOfContent))
                            .collect(Collectors.toList());
                    if (list.size() > 0) {
                        foundFiles.add(file);
                    }
                }
            } catch (UncheckedIOException ex) {

            }
        }
        return super.visitFile(file, attrs);
    }


}
