class RectangleOverlap{
    
    // 判断两个矩形是否覆盖

    // 检查坐标
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[1] >= rec2[3] ||
                 rec1[0] >= rec2[2] ||
                 rec1[3] <= rec2[1] ||
                 rec1[2] <= rec2[0]);
    }

    // 检查面积
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])) && 
                (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

}