function maxArea(height: number[]): number {

    let n: number= height.length;
    let i : number= 0;
    let j : number= n-1;
    let area : number = 0;
    let max_area: number= 0;

    while(i<j){
        let width : number= j-i;
        let waterHeight= Math.min(height[i],height[j])

        area = width*waterHeight;

        max_area= Math.max(max_area,area);

        if(height[i]<height[j]){
            i++;
        }else{
            j--;
        }
    }

    return max_area;
};