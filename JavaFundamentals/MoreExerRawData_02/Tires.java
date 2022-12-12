package MoreExerRawData_02;

public class Tires {

    private double[] tiresPressureArr;
    private int[] tiresAgeArr;

    public Tires(double[] tiresPressureArr, int[] tiresAgeArr){
        this.tiresPressureArr = tiresPressureArr;
        this.tiresAgeArr = tiresAgeArr;

    }

    public double[] getTiresPressureArr() {
        return tiresPressureArr;
    }

    public int[] getTiresAgeArr() {
        return tiresAgeArr;
    }
}
