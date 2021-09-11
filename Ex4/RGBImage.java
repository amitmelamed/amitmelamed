package com.company;

public class RGBImage implements Frame, Comparable<Frame>{
	
	
	int frame[][][];

	// constructors
	public RGBImage(int[][][] frame) {
		//h = height
		//l = length
		//c = color
		this.frame=new int[3][frame[0].length][frame[0][0].length];
		for(int c=0;c<=2;c++){
			for(int h=0;h<frame[c].length;h++){
				for(int l=0;l<frame[c][h].length;l++){
					this.frame[c][h][l]=frame[c][h][l];
				}
			}
		}

	}
	public RGBImage(RGBImage rgbImage){
		//h = height
		//l = length
		//c = color
		for(int c=0;c<=2;c++){
			for(int h=0;h<rgbImage.frame[c].length;h++){
				for(int l=0;l<rgbImage.frame[c][h].length;l++){
					this.frame[c][h][l]=rgbImage.frame[c][h][l];
				}
			}
		}

	}

	//get methods

	public int[][][] getFrame() {
		return frame;
	}

	public int[] getPixel(int x, int y) {

		int[] pixel=new int[3];
		for(int i=0;i<pixel.length;i++){
			pixel[i]=frame[i][x][y];
		}
		return pixel;
	}

	//actions methods

	@Override
	public void rotate90() {
		rotate180();
		int [][][] rotatedFrame=new int[3][frame[0][0].length][frame[0].length];
		for(int c=0;c<3;c++){
			for(int x=0;x<rotatedFrame[0].length;x++){
				for(int y=0;y<rotatedFrame[0][0].length;y++){
					rotatedFrame[c][x][y]=frame[c][y][x];
				}
			}
		}
		frame=new int[3][rotatedFrame[0].length][rotatedFrame[0][0].length];
		for(int c=0;c<3;c++){
			for(int x=0;x<rotatedFrame[0].length;x++){
				for(int y=0;y<rotatedFrame[0][0].length;y++){
					frame[c][x][y]=rotatedFrame[c][x][y];
				}
			}
		}
	}




	public void smooth(int n) {
		if(n<3||n%2==0){
			System.out.println("invailed input, enter uneven number and bigger than 2");
			return;
		}
		int [][][] newFrame=new int[3][frame[0].length][frame[0][0].length];
		for(int c=0;c<3;c++){

			int sum=0;
			int countNei=0;
			for(int h=0;h<frame[c].length;h++){
				for(int l=0;l<frame[c][h].length;l++){
					for(int x=h-(n/2);x<h-(n/2)+n;x++){
						for(int y=l-(n/2);y<l-(n/2)+n;y++){
							if(x<frame[0].length&&y<frame[0][0].length&&x>=0&&y>=0)
							{
								sum=sum+frame[c][x][y];
								countNei++;
							}

						}

					}
					countNei--;
					sum=sum-frame[c][h][l];
					sum=sum/countNei;
					newFrame[c][h][l]=sum;
					sum=0;
					countNei=0;
				}
			}


		}
		for(int c=0;c<3;c++){
			for(int x=0;x<frame[c].length;x++){
				for(int y=0;y<frame[c][x].length;y++)
					this.frame[c][x][y]=newFrame[c][x][y];
			}
		}
	}



	public void crop(int x, int y) {
		for(int c=0;c<3;c++){
			if(x>frame[c].length||y>frame[c][0].length){
				System.out.println("incorrect input");
				return;
			}

		}
		int [][][] newFrame=new int[3][x][y];
		for(int c=0;c<3;c++){
			for(int h=0;h<x;h++){
				for(int l=0;l<y;l++){
					newFrame[c][h][l]=this.frame[c][h][l];
				}
			}
		}
		this.frame=new int[3][x][y];
		for(int c=0;c<3;c++){
			for(int h=0;h<x;h++){
				for(int l=0;l<y;l++){
					this.frame[c][h][l]=newFrame[c][h][l];
				}
			}
		}

	}

	@Override
	public int getSize(){
		return frame[0].length*frame[0][0].length;
	}

	public void addFrom(Frame f) {
		if(f instanceof RGBImage && ((RGBImage) f).frame.length==frame.length&&((RGBImage) f).frame[0].length==frame[0].length){
			for(int c=0;c<3;c++){
				for(int x=0;x<frame[c].length;x++){
					for(int y=0;y<frame[c][x].length;y++){
						if((frame[c][x][y]+((RGBImage) f).frame[c][x][y])<254){
							frame[c][x][y]=frame[c][x][y]+((RGBImage) f).frame[c][x][y];

						}
					}
				}
			}
		}

	}

	@Override
	public void rotate180() {
		int [][][] rotatedFrame=new int[3][frame[0].length][frame[0][0].length];
		for(int c=0;c<3;c++) {
			for (int x = rotatedFrame[0].length - 1; x >= 0; x--) {
				for (int y = 0; y < rotatedFrame[0][0].length; y++)
					rotatedFrame[c][rotatedFrame[0].length - 1 - x][y] = frame[c][x][y];
			}
		}
		this.frame=new int[3][rotatedFrame[0].length][rotatedFrame[0][0].length];
		for(int c=0;c<3;c++){
			for(int x=0;x<frame[0].length;x++){
				for (int y=0;y<frame[0][0].length;y++){
					frame[c][x][y]=rotatedFrame[c][x][y];
				}
			}

		}


	}

	@Override
	public int compareTo(Frame f) {
		int sizeFrame=this.frame[0].length*this.frame[0][0].length;
		if(f instanceof GrayImage){
			int sizeF=((GrayImage) f).getFrame().length*((GrayImage) f).getFrame()[0].length;
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
