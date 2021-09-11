package com.company;

public class GrayImage implements Frame, Comparable<Frame> {

	private int[][] frame;
	// constructors
	public GrayImage(int [][] frame){
		this.frame=new int[frame.length][frame[0].length];
		for(int h=0;h<frame.length;h++){
			for(int l=0;l<frame[0].length;l++){
				this.frame[h][l]=frame[h][l];
			}
		}
	}
	public GrayImage(GrayImage grayImage){
		this.frame=new int[grayImage.frame.length][grayImage.frame[0].length];
		for(int h=0;h<grayImage.frame.length;h++){
			for(int l=0;l<grayImage.frame[0].length;l++){
				this.frame[h][l]=grayImage.frame[h][l];
			}
		}
	}
	//get methods
	public int[][] getFrame() {
		return frame;
	}
	public int[] getPixel(int x, int y) {
		int [] pixel=new int[1];
		pixel[0]=frame[x][y];
		return pixel;
	}
	public void rotate180(){

		int [][] rotatedFrame=new int[frame.length][frame[0].length];
		for(int x=rotatedFrame.length-1;x>=0;x--){
			for(int y=0;y<rotatedFrame[0].length;y++)
				rotatedFrame[rotatedFrame.length-1-x][y]=frame[x][y];
		}
		this.frame=new int[rotatedFrame.length][rotatedFrame[0].length];
		for(int x=0;x<frame.length;x++){
			for (int y=0;y<frame[0].length;y++){
				frame[x][y]=rotatedFrame[x][y];
			}
		}

	}

	@Override
	public int getSize() {
		return frame.length*frame[0].length;
	}

	// action methods
	public void rotate90() {
		rotate180();
		int [][] rotatedFrame=new int[frame[0].length][frame.length];

		for(int x=0;x<rotatedFrame.length;x++){
			for(int y=rotatedFrame[0].length-1;y>=0;y--){
				rotatedFrame[x][y]=frame[y][x];
			}
		}
		this.frame=new int[rotatedFrame.length][rotatedFrame[0].length];
		for(int x=0;x<frame.length;x++){
			for (int y=0;y<frame[0].length;y++){
				frame[x][y]=rotatedFrame[x][y];
			}
		}



	}
	public void smooth(int n) {
		if(n<3||n%2==0){
			System.out.println("invailed input, enter uneven number and bigger than 2");
			return;
		}
		int [][] newFrame=new int[frame.length][frame[0].length];
		int sum=0;
		int countNei=0;
		for(int h=0;h<frame.length;h++){
			for(int l=0;l<frame[h].length;l++){
				for(int x=h-(n/2);x<h-(n/2)+n;x++){
					for(int y=l-(n/2);y<l-(n/2)+n;y++){
						if(x<frame.length&&y<frame[0].length&&x>=0&&y>=0)
						{
							sum=sum+frame[x][y];
							countNei++;
						}
					}
				}
				countNei--;
				System.out.print(countNei);
				sum=sum-frame[h][l];
				sum=sum/countNei;
				newFrame[h][l]=sum;
				sum=0;
				countNei=0;
			}
		}
		for(int x=0;x<frame.length;x++){
			for(int y=0;y<frame[0].length;y++){
				this.frame[x][y]=newFrame[x][y];
			}
		}
	}
	public void crop(int x, int y) {
		if(x>frame.length||y>frame[0].length) {
			System.out.println("incorrect input");
			return;
		}
		int [][] newFrame=new int[x][y];
		for(int h=0;h<x;h++){
			for(int l=0;l<y;l++){
				newFrame[h][l]=this.frame[h][l];
			}
		}
		this.frame=new int[x][y];
		for(int h=0;h<frame.length;h++){
			for(int l=0;l<frame[0].length;l++){
				this.frame[h][l]=newFrame[h][l];
			}
		}


	}
	@Override
	public void addFrom(Frame f) {

		if (  f instanceof GrayImage&&((GrayImage) f).frame.length==frame.length&&((GrayImage) f).frame[0].length==frame[0].length){

			for(int x=0;x<frame.length;x++){
				for(int y=0;y<frame[0].length;y++){
					frame[x][y]=frame[x][y]+((GrayImage) f).frame[x][y];
					if(frame[x][y]>254){
						frame[x][y]=frame[x][y]-254;
					}
				}

			}
		}

	}
	@Override
	public int compareTo(Frame f) {
		int sizeFrame=this.frame.length*this.frame[0].length;
		if(f instanceof GrayImage){
			int sizeF=((GrayImage) f).frame.length*((GrayImage) f).frame[0].length;
			if(sizeFrame>sizeF)
				return 1;
			if(sizeFrame==sizeF)
				return 0;
			return -1;
		}
		if(f instanceof RGBImage){
			int sizeF=((RGBImage) f).frame[0].length*((RGBImage) f).frame[0][0].length;
			if(sizeFrame>sizeF)
				return 1;
			if(sizeFrame==sizeF)
				return 0;
			return -1;
		}
		return 1;
	}
}
