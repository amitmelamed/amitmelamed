package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RGBImageTest {

    @Test
    void getPixel() {
        int [][][] frame={
                        {{1,2,3},
                        {4,5,6},
                        {7,8,9}}

                        ,{{2,3,4},
                        {5,6,7},
                        {8,9,10}},

                         {{3,4,5},
                          {6,7,8},
                          {9,10,11}}};
        RGBImage rgbImage=new RGBImage(frame);
        int []pixel={5,6,7};
        assertArrayEquals(pixel,rgbImage.getPixel(1,1));
    }

    @Test
    void rotate90() {
        int [][][] frame={
                {{1,2,3},
                        {4,5,6},
                        {7,8,9}}

                ,{{2,3,4},
                {5,6,7},
                {8,9,10}},

                {{3,4,5},
                        {6,7,8},
                        {9,10,11}}};
        RGBImage rgbImage=new RGBImage(frame);
        rgbImage.rotate90();
        int [][][]rotated={
                {{7,4,1},{8,5,2},{9,6,3}},
                {{8,5,2},{9,6,3},{10,7,4}},
                {{9,6,3},{10,7,4},{11,8,5}}
        };
        for(int i=0;i<3;i++){
            for(int k=0;k<rotated[0].length;k++){
                assertArrayEquals(rotated[i][k],rgbImage.frame[i][k]);
            }
        }
    }

    @Test
    void smooth() {
        int [][][] frame={
                {{1,2,3},
                        {4,5,6},
                        {7,8,9}}

                ,{{2,3,4},
                {5,6,7},
                {8,9,10}},

                {{3,4,5},
                        {6,7,8},
                        {9,10,11}}};
        RGBImage rgbImage=new RGBImage(frame);
        rgbImage.smooth(3);
        int [][][] smoothMat={
                {{3,3,4},{4,5,5},{5,6,6}},
                {{4,4,5},{5,6,6},{6,7,7}},
                {{5,5,6},{6,7,7},{7,8,8}}
        };
        for (int i=0;i<3;i++){
            for(int k=0;k<rgbImage.frame[0].length;k++){
                assertArrayEquals(smoothMat[i][k],rgbImage.frame[i][k]);

        }
        }
    }

    @Test
    void crop() {
        int [][][] frame={
                {{1,2,3},
                        {4,5,6},
                        {7,8,9}}

                ,{{2,3,4},
                {5,6,7},
                {8,9,10}},

                {{3,4,5},
                        {6,7,8},
                        {9,10,11}}};
        RGBImage rgbImage=new RGBImage(frame);
        rgbImage.crop(2,2);
        int [][][] croppedFrame={{{1,2},{4,5}},{{2,3},{5,6}},{{3,4},{6,7}}};
        for(int i=0;i<3;i++){
            for(int k=0;k<rgbImage.frame[0].length;k++){
                assertArrayEquals(rgbImage.frame[i][k],rgbImage.frame[i][k]);
            }
        }
    }




    @Test
    void addFrom() {
        int [][][] add={{{1,1,1},{1,1,1},{1,1,1}},{{1,1,1},{1,1,1},{1,1,1}},{{1,1,1},{1,1,1},{1,1,1}}};
        int [][][] frame={
                {{1,2,3},
                        {4,5,6},
                        {7,8,9}}

                ,{{2,3,4},
                {5,6,7},
                {8,9,10}},

                {{3,4,5},
                        {6,7,8},
                        {9,10,11}}};

        int [][][] added={{{2,3,4},{5,6,7},{8,9,10}}

        ,{{3,4,5},{6,7,8},{9,10,11}},
            {{4,5,6},{7,8,9},{10,11,12}}};

        RGBImage rgbImage=new RGBImage(frame);
        RGBImage rgbImage1=new RGBImage(add);
        rgbImage.addFrom(rgbImage1);

        for(int i=0;i<3;i++){
            for(int k=0;k<rgbImage.frame[0].length;k++){
                assertArrayEquals(added[i][k],rgbImage.frame[i][k]);
            }
        }


    }
}