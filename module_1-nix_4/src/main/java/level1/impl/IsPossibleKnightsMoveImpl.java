package level1.impl;

import level1.IsPossibleKnightsMove;

public class IsPossibleKnightsMoveImpl implements IsPossibleKnightsMove {

    int startX;
    int startY;
    int finX;
    int finY;

    public IsPossibleKnightsMoveImpl(int startX, int startY, int finX, int finY) {
        this.startX = startX;
        this.startY = startY;
        this.finX = finX;
        this.finY = finY;
    }

        @Override
        public boolean isPossible(int x, int y) {
               switch (Math.abs(x)) {
                case 2:
                    if (Math.abs(y) == Math.abs(1)) return true;
                    break;
                case 1:
                    if (Math.abs(y) == Math.abs(2)) return true;
                    break;
            }
            return false;
        }

}
