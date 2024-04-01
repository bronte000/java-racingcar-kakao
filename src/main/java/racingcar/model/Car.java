package racingcar.model;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 1);
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public void moveWithDiceNum(int diceResult) {
        if (diceResult >= MOVE_THRESHOLD) {
            position++;
        }
    }
}
