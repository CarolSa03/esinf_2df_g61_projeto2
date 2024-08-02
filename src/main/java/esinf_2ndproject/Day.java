package esinf_2ndproject;

/**
 * The type Day.
 */
public class Day implements Comparable<Day> {

    private double dayNum;

    private AVL<Timestamp> timestampAVL;

    /**
     * Instantiates a new Day.
     *
     * @param dayNum       the day num
     * @param timestampAVL the timestamp avl
     */
    public Day(double dayNum, AVL<Timestamp> timestampAVL) {
        setDayNum(dayNum);
        setTimestampAVL(timestampAVL);
    }

    /**
     * Instantiates a new Day.
     *
     * @param dayNum the day num
     */
    public Day(double dayNum) {
        setDayNum(dayNum);
        setTimestampAVL(new AVL<>());
    }

    /**
     * Instantiates a new Day.
     */
    public Day() {
        setTimestampAVL(new AVL<>());
    }

    /**
     * Gets day num.
     *
     * @return the day num
     */
    public double getDayNum() {
        return dayNum;
    }

    /**
     * Sets day num.
     *
     * @param dayNum the day num
     */
    public void setDayNum(double dayNum) {
        this.dayNum = dayNum;
    }

    /**
     * Gets timestamp avl.
     *
     * @return the timestamp avl
     */
    public AVL<Timestamp> getTimestampAVL() {
        return timestampAVL;
    }

    /**
     * Sets timestamp avl.
     *
     * @param timestampAVL the timestamp avl
     */
    public void setTimestampAVL(AVL<Timestamp> timestampAVL) {
        this.timestampAVL = timestampAVL;
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayNum=" + dayNum +
                ", timestampAVL=\n" + timestampAVL +
                '}';
    }

    @Override
    public int compareTo(Day o) {
        if (this.dayNum > o.dayNum) return 1;
        else if (this.dayNum < o.dayNum) return -1;
        return 0;
    }

}