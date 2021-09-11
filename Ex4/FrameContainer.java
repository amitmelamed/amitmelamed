package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FrameContainer implements ContainerFunctions {
    private Frame [] frames;
    private int size;

    public FrameContainer(String fileName,boolean gray){
        size=0;
        ArrayList<String> arrayList=new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arrayList.add(data);
                size++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        frames=new Frame[arrayList.size()];
        Frame frame;
        for(int i=0;i<arrayList.size();i++){
            frames[i]=MyImageIO.readImageFromFile(arrayList.get(i),gray);
        }
    }

    public FrameContainer(){
        this.frames=new Frame[0];
        size=0;
    }
    @Override
    public Frame get(int i) {
        return frames[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Frame f) {
        size++;
        Frame [] newFrames=new Frame[size];
        for(int k=0;k<size-1;k++){
            newFrames[k]=frames[k];
        }
        newFrames[size-1]=f;
        frames=new Frame[size];
        System.arraycopy(newFrames, 0, frames, 0, size);
    }

    @Override
    public void remove(Frame f) {
        Frame[] newFrames=new Frame[size-1];
        for(int i=0;i<frames.length;i++){
            if(frames[i].equals(f))
                frames[i]=null;
        }
        int index=0;
        for (Frame frame : frames) {
            if (frame != null) {
                newFrames[index] = frame;
                index++;
            }
        }
        size=index;
        frames=new Frame[size];
        for(int i=0;i<size;i++){
            frames[i]=newFrames[i];
        }
    }

    @Override
    public void sort(Frame[] f) {
        Frame tempFrame;
        boolean sorted=false;
        while (!sorted){
            sorted=true;
            for(int i=0;i<f.length-1;i++){
                if(f[i].getSize()>f[i+1].getSize()){
                    sorted=false;
                    tempFrame=f[i];
                    f[i]=f[i+1];
                    f[i+1]=tempFrame;
                }
            }
        }
    }
    public void sort(){
        Frame tempFrame;
        boolean sorted=false;
        while (!sorted){
            sorted=true;
            for(int i=0;i<frames.length-1;i++){
                if(frames[i].getSize()>frames[i+1].getSize()){
                    sorted=false;
                    tempFrame=frames[i];
                    frames[i]=frames[i+1];
                    frames[i+1]=tempFrame;
                }
            }
        }

    }

    @Override
    public void rotateAll(Frame[] f) {
        for (Frame frame : frames) {
            frame.rotate90();
        }
    }
    public void rotateAll() {
        for (Frame frame : frames) {
            frame.rotate90();
        }
    }

    @Override
    public void smoothAll(Frame[] f, int n) {
        for (Frame frame : f) {
            frame.smooth(n);
        }
    }
    public void smoothAll(int n){
        for(int i=0;i<frames.length;i++){
            frames[i].smooth(n);
        }
    }
}
