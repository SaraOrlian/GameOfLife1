import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridView extends JComponent{

    private Grid grid;
    public static final int CELL_SIZE = 40;
    public static final int SPACING_BETWEEN_CELLS = 2;


    public GridView(Grid grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
        paintAliveCells(g);
    }

    void paintGrid(Graphics g) {
        ArrayList<Square> board2= new ArrayList<>();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.GRAY);
        for (int i = 0; i < getWidth()/40; i++) {
            for (int j = 0; j < getHeight()/45; j++) {  //the height is divided by 45 here to allow for extra space on the bottom- to put the buttons
                g.fillRect(SPACING_BETWEEN_CELLS+i*CELL_SIZE,
                           SPACING_BETWEEN_CELLS+j*CELL_SIZE,
                        CELL_SIZE-SPACING_BETWEEN_CELLS*SPACING_BETWEEN_CELLS,
                        CELL_SIZE-SPACING_BETWEEN_CELLS*SPACING_BETWEEN_CELLS);
                board2.add(new Square(SPACING_BETWEEN_CELLS+i*CELL_SIZE, SPACING_BETWEEN_CELLS+j*CELL_SIZE));
            }
        }
        grid.setBoard2(board2);
    }

    void paintAliveCells(Graphics g) {
        if (!grid.getAliveSquares().isEmpty()) {
            for (Square s : grid.getAliveSquares()) {
                g.setColor(Color.YELLOW);
                g.fillRect(SPACING_BETWEEN_CELLS+s.getX()*CELL_SIZE,
                           SPACING_BETWEEN_CELLS+s.getY()*CELL_SIZE,
                        CELL_SIZE-SPACING_BETWEEN_CELLS*SPACING_BETWEEN_CELLS,
                        CELL_SIZE-SPACING_BETWEEN_CELLS*SPACING_BETWEEN_CELLS);
            }
        }
    }

}

//Don't forget Test
