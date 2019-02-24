class RectangleArea{

    // problem
    // Find the total area covered by two rectilinear rectangles in a 2D plane.
    // 计算平面上两个矩形的面积之和

    // 两个矩形可能有覆盖

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 如果没有覆盖，left == right
        int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F), top = Math.max(Math.min(D, H), bottom);
        return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
    }
}