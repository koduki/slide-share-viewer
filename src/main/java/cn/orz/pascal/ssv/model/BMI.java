package cn.orz.pascal.ssv.model;

/**
 * MBI(Body Mass Index) calculator.
 *
 * @author koduki
 */
public final class BMI {
    public static final int AVERAGE = 22;

    private BMI() {
    }

    /**
     * calculate BMI.
     *
     * @param weight body weight.
     * @param height body height.
     * @return calculate result.
     */
    public static double calc(double weight, double height) {
        return weight / Math.pow(height / 100.0, 2);
    }
}
