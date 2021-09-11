package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrayImageTest {


    @Test
    void getFrame() {
        int [][] mat={{1,2,3},{4,9,6},{7,3,1}};
        GrayImage grayImage=new GrayImage(mat);
        assertArrayEquals(mat,grayImage.getFrame());
    }

    @Test
    void getPixel() {
        int [][] mat={{1,2,3},{4,9,6},{7,3,1}};
        GrayImage grayImage=new GrayImage(mat);
        int [] arr={9};
        assertArrayEquals(arr,grayImage.getPixel(1,1));
    }

    @Test
    void getSize() {
        int [][] mat={{1,2,3},{4,9,6},{7,3,1}};
        GrayImage grayImage=new GrayImage(mat);
        assertEquals(9,grayImage.getSize());
    }

    @Test
    void rotate90() {
        int [][] mat={{1,2,3},{4,9,6},{7,3,1}};
        GrayImage grayImage=new GrayImage(mat);
        grayImage.rotate90();
        int [][] rotated={{7,4,1},{3,9,2},{1,6,3}};
        for(int i=0;i<grayImage.getFrame().length;i++){
            assertArrayEquals(grayImage.getFrame()[i],rotated[i]);
        }
    }

    @Test
    void smooth() {
        int [][] mat={{1,2,3},{4,9,6},{7,3,1}};
        GrayImage grayImage=new GrayImage(mat);
        grayImage.smooth(3);
        int [][] afterSmooth={{5,5,5},{4,3,3},{5,5,6}};


    }

    @Test
    void crop() {
        int [][] mat={{1,2,3},{4,9,6},{7,3,1}};
        GrayImage grayImage=new GrayImage(mat);
        grayImage.crop(2,2);
        int [][] cropped={{1,2},{4,9}};
        for(int i=0;i<grayImage.getFrame().length;i++){
            assertArrayEquals(grayImage.getFrame()[i],cropped[i]);
        }

    }

    @Test
    void addFrom() {
        int [][] mat={{1,2,3},{4,9,6},{7,3,1}};
        GrayImage grayImage=new GrayImage(mat);
        int [][] mat1={{1,1,1},{1,1,1},{1,1,1}};
        GrayImage grayImage1=new GrayImage(mat1);
        grayImage.addFrom(grayImage1);
        int [][] mat2={{2,3,4},{5,10,7},{8,4,2}};

        for(int i=0;i<grayImage.getFrame().length;i++){
            assertArrayEquals(grayImage.getFrame()[i],mat2[i]);
        }
    }
}