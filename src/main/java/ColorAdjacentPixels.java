/**
 * Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C, replace the color of the given pixel and all adjacent same colored pixels with C.
 * For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:
 * B	B	W	B
 * W	W 	W	W
 * W 	W 	W	B
 * B 	B 	B	W
 *
 * Becomes
 * B 	B 	G	B
 * G 	G 	G	G
 * G 	G 	G	B
 * B 	B 	B	W
 */
public class ColorAdjacentPixels {

    static char[][] colors = {{'B', 'B', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}, {'B', 'B', 'B'}};

    public static void colorAdjacentPixels(int x, int y, char color, int rows, int columns, int[][] visited){

        if( x +1 <= rows -1 && colors[x][y] == colors[x+1][y] && visited[x+1][y] != 1){
            visited[x+1][y] = 1;
            ColorAdjacentPixels.colorAdjacentPixels(x+1,y,color,rows,columns, visited);

        }
        int c1 = 0;
        char c = 'a';
        c1 = c;

        if(y + 1 <= columns -1 && colors[x][y] == colors[x][y+1] && visited[x][y + 1] != 1){
            visited[x][y + 1] = 1;
            ColorAdjacentPixels.colorAdjacentPixels(x,y + 1,color,rows,columns, visited);
        }
        if(x -1 >=0 && colors[x][y] == colors[x- 1][y] && visited[x -1][y] != 1){
            visited[x -1][y] = 1;
            ColorAdjacentPixels.colorAdjacentPixels(x -1 ,y,color,rows,columns, visited);
        }
        if(y - 1>=0 && colors[x][y] == colors[x][y - 1] && visited[x][y -1] != 1){
            visited[x][y -1] = 1;
            ColorAdjacentPixels.colorAdjacentPixels(x ,y - 1,color,rows,columns, visited);
        }
        colors[x][y] = color;

    }

    public static void main(String[] args){

        int a = 2; //input
        int b = 2; //input

        char color = 'G'; //input

        int rows = colors.length;
        int columns =0;
        if(rows >= 1){
            columns = colors[0].length;
            int[][] visited = new int[rows][columns];
            for(int i= 0; i<= rows -1; i++){
                for(int j = 0; j <= columns -1;j++){
                    visited[i][j] = 0;
                }

            }
            colorAdjacentPixels(a,b, color, rows, columns, visited);
        }

        for(int i= 0; i<= rows -1; i++){
            for(int j = 0; j <= columns -1 ;j++){
                System.out.print(colors[i][j] + " ");
            }
            System.out.println(" ");

        }


    }




}
