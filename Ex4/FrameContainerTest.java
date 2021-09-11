package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameContainerTest {

    @Test
    void get() {
    }

    @Test
    void add() {
        int [][][] mat={{{1,1,1},{1,1,1},{1,1,1}},{{1,1,1},{1,1,1},{1,1,1}},{{1,1,1},{1,1,1},{1,1,1}}};
        RGBImage rgbImage=new RGBImage(mat);
        FrameContainer frameContainer=new FrameContainer();
        assertEquals(0,frameContainer.size());
        frameContainer.add(rgbImage);
        assertEquals(1,frameContainer.size());
        frameContainer.add(rgbImage);
        frameContainer.add(rgbImage);
        frameContainer.add(rgbImage);
        assertEquals(4,frameContainer.size());


    }

    @Test
    void remove() {
        int [][][] mat1={{{1,1,1},{1,1,1},{1,1,1}},{{1,1,1},{1,1,1},{1,1,1}},{{1,1,1},{1,1,1},{1,1,1}}};
        int [][][] mat2={{{1,1,1},{1,1,1},{1,1,1}},{{1,1,1},{1,1,1},{1,1,1}},{{1,1,1},{1,1,1},{1,1,1}}};
        RGBImage rgbImage1=new RGBImage(mat1);
        RGBImage rgbImage2=new RGBImage(mat2);
        FrameContainer frameContainer=new FrameContainer();
        frameContainer.add(rgbImage1);
        frameContainer.add(rgbImage1);
        frameContainer.add(rgbImage1);
        frameContainer.add(rgbImage2);
        frameContainer.add(rgbImage2);
        frameContainer.add(rgbImage2);
        assertEquals(6,frameContainer.size());
        frameContainer.remove(rgbImage1);
        assertEquals(3,frameContainer.size());





    }

    @Test
    void rotateAll() {
        int [][][] frame={{{1,2,3}, {4,5,6}, {7,8,9}},{{2,3,4}, {5,6,7}, {8,9,10}}, {{3,4,5}, {6,7,8}, {9,10,11}}};
        int [][][]rotated={{{7,4,1},{8,5,2},{9,6,3}}, {{8,5,2},{9,6,3},{10,7,4}}, {{9,6,3},{10,7,4},{11,8,5}}};
        RGBImage image1=new RGBImage(frame);
        RGBImage imageRoteted=new RGBImage(rotated);
        FrameContainer frameContainer=new FrameContainer();
        frameContainer.add(image1);
        frameContainer.rotateAll();
        assertArrayEquals(imageRoteted.getPixel(0,0), frameContainer.get(0).getPixel(0,0));
        assertArrayEquals(imageRoteted.getPixel(1,1), frameContainer.get(0).getPixel(1,1));
        assertArrayEquals(imageRoteted.getPixel(2,1), frameContainer.get(0).getPixel(2,1));
        assertArrayEquals(imageRoteted.getPixel(2,0), frameContainer.get(0).getPixel(2,0));



    }

    @Test
    void testRotateAll() {
        int [][][] frame={{{1,2,3}, {4,5,6}, {7,8,9}},{{2,3,4}, {5,6,7}, {8,9,10}}, {{3,4,5}, {6,7,8}, {9,10,11}}};
        int [][][]rotated={{{7,4,1},{8,5,2},{9,6,3}}, {{8,5,2},{9,6,3},{10,7,4}}, {{9,6,3},{10,7,4},{11,8,5}}};
        RGBImage image1=new RGBImage(frame);
        RGBImage imageRoteted=new RGBImage(rotated);
        FrameContainer frameContainer=new FrameContainer();
        frameContainer.add(image1);
        frameContainer.rotateAll();
        assertArrayEquals(imageRoteted.getPixel(0,0), frameContainer.get(0).getPixel(0,0));
        assertArrayEquals(imageRoteted.getPixel(1,1), frameContainer.get(0).getPixel(1,1));
        assertArrayEquals(imageRoteted.getPixel(2,1), frameContainer.get(0).getPixel(2,1));
        assertArrayEquals(imageRoteted.getPixel(2,0), frameContainer.get(0).getPixel(2,0));
    }

    @Test
    void smoothAll() {
        int [][][] frame={{{1,2,3}, {4,5,6}, {7,8,9}},{{2,3,4}, {5,6,7}, {8,9,10}}, {{3,4,5}, {6,7,8}, {9,10,11}}};
        RGBImage image1=new RGBImage(frame);
        int [][][] smoothMat={
                {{3,3,4},{4,5,5},{5,6,6}},
                {{4,4,5},{5,6,6},{6,7,7}},
                {{5,5,6},{6,7,7},{7,8,8}}
        };
        RGBImage smoothImage =new RGBImage(smoothMat);
        FrameContainer frameContainer=new FrameContainer();
        frameContainer.add(image1);
        frameContainer.smoothAll(3);
        assertArrayEquals(smoothImage.getPixel(0,0), frameContainer.get(0).getPixel(0,0));
        assertArrayEquals(smoothImage.getPixel(1,1), frameContainer.get(0).getPixel(1,1));
        assertArrayEquals(smoothImage.getPixel(2,1), frameContainer.get(0).getPixel(2,1));
        assertArrayEquals(smoothImage.getPixel(2,0), frameContainer.get(0).getPixel(2,0));


    }

    @Test
    void testSmoothAll() {
        int [][][] frame={{{1,2,3}, {4,5,6}, {7,8,9}},{{2,3,4}, {5,6,7}, {8,9,10}}, {{3,4,5}, {6,7,8}, {9,10,11}}};
        RGBImage image1=new RGBImage(frame);
        int [][][] smoothMat={
                {{3,3,4},{4,5,5},{5,6,6}},
                {{4,4,5},{5,6,6},{6,7,7}},
                {{5,5,6},{6,7,7},{7,8,8}}
        };
        RGBImage smoothImage =new RGBImage(smoothMat);
        FrameContainer frameContainer=new FrameContainer();
        frameContainer.add(image1);
        frameContainer.smoothAll(3);
        assertArrayEquals(smoothImage.getPixel(0,0), frameContainer.get(0).getPixel(0,0));
        assertArrayEquals(smoothImage.getPixel(1,1), frameContainer.get(0).getPixel(1,1));
        assertArrayEquals(smoothImage.getPixel(2,1), frameContainer.get(0).getPixel(2,1));
        assertArrayEquals(smoothImage.getPixel(2,0), frameContainer.get(0).getPixel(2,0));
    }
}