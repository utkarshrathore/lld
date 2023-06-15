package util;

public class VoteCalculator {
    public static Integer calculatePointsBasedOnIndex(int index) {
        switch (index) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return null;
        }
    }
}
