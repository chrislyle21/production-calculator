package learning.mytestapp;
/**
 * Created by chris on 09/02/2018.
 */

public class ProdCal {
    /* Instance variables */
    private double profileLength;
    private double production;
    private double prevCount;
    private double lastCount;
    private double numberOfStillages;

    /**
     * Constructor for objects of class ProdCal.
     */
    public ProdCal()
    {
        this.profileLength = 0;
        this.production = 0;
        this.prevCount = 0;
        this.lastCount = 0;
        this.numberOfStillages = 0;
    }
    public void setNumberOfStillages(double aStillage)
    {

        this.numberOfStillages = aStillage;
    }

    public double getNumberOfStillages()
    {

        return this.numberOfStillages;
    }

    /**
     * Returns the profile length of the receiver.
     */
    public double getProfileLength()
    {

        return this.profileLength;
    }

    /**
     * Returns the number of lengths from full stillages of the receiver.
     */
    public double getProduction()
    {

        return this.production;
    }

    /**
     * Returns the previous count (last count of previous shift), of the receiver.
     */
    public double getPrevCount()
    {

        return this.prevCount;
    }

    /**
     * Returns the last count of the receiver.
     */
    public double getLastCount()
    {

        return this.lastCount;
    }

    /**
     * Sets the profile length of the receiver.
     */
    public void setProfileLength(double n)
    {

        this.profileLength = n;
    }

    /**
     * Sets the number of lengths from full stillages of the receiver.
     */
    public void setProduction(double n)
    {

        this.production = n;
    }

    /**
     * Sets the previous count (last count of previous shift), of the receiver.
     */
    public void setPrevCount(double n)
    {

        this.prevCount = n;
    }

    /**
     * Sets the last count of the receiver.
     */
    public void setLastCount(double n)
    {

        this.lastCount = n;
    }

    /**
     * Returns the calculated value of the receiver.
     */
    public double calculate()
    {
        return ((this.getProduction() * this.getNumberOfStillages() + this.getLastCount() - this.getPrevCount()) * this.getProfileLength());
    }
}
