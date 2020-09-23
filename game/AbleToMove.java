package game;

public interface AbleToMove {
    public void move(int deltax, int deltay);

    public void move(int deltax, int deltay, boolean isJump);
}
