function trap(height: number[]): number {
    /***
        first height or water contained at i 
        waterHeight[i] = Math.min(leftmaxheight, rightmaxheohgt)- height[i]

     */
    let total : number = 0;
    let waterheight_i : number = 0;
    let leftmax : number[] = [];
    let rightmax : number[] = [];
    leftmaxheight(height,leftmax);
    rightmaxheight(height,rightmax);

    for(let i=0; i<height.length; i++){
        if(i==0 || i==height.length-1){
            continue;
        }
        waterheight_i= Math.min(leftmax[i], rightmax[i])- height[i];
        total+=waterheight_i;
    }

    return total;
};


function leftmaxheight(height: number[],leftmax: number[]): number[]{
    let maxH: number =0;
    for(let i=0; i<height.length ; i++){
        maxH= Math.max(height[i],maxH);
        leftmax[i]=maxH;
    }

    return leftmax;
}

function rightmaxheight(height: number[],rightmax: number[]): number[]{
    let maxH: number =0;
   
    for(let i=height.length-1; i>=0 ; i--){
        maxH= Math.max(height[i],maxH)
        rightmax[i]=maxH;
    }

    return rightmax;
}