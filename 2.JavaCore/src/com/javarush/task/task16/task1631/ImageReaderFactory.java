package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Alex on 29.11.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) {
        if(imageType==null)
            throw new IllegalArgumentException("Неизвестный тип картинки");
        switch (imageType) {
            case BMP:
                return new BmpReader();
            //break;
            case JPG:
                return new JpgReader();
            //break;
            case PNG:
                return new PngReader();
            //break;
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }

    }
}
