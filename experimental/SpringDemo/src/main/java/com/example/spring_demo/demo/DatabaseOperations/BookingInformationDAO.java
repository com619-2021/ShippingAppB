package com.example.spring_demo.demo.DatabaseOperations;

public class BookingInformationDAO
{
    /**
     * The number of passengers to go on the ship.
     */
    private int numberOfPassengers;

    /**
     * The cargo to go on the ship.
     */
    private String cargo;

    /**
     * The weight to go on the ship.
     */
    private double weightInKiloGrams;

    /**
     * Gets the number of passengers.
     * @return the number of passengers to board the ship.
     */
    public int getNumberOfPassengers() { return this.numberOfPassengers; }

    /**
     * Gets the  cargo information.
     * @return the information of cargo to be shipped.
     */
    public String getCargo() { return this.cargo; }

    /**
     * gets the weight of the cargo to go on ship in kilograms including the passengers.
     * @return the wight of cargo in kilograms including the passengers. Must be to 2 decimal places
     */
    public double getWeightInKiloGrams() { return this.weightInKiloGrams; }

    /**
     * Initalizes a new instance of the <see cref="BookingInformationDAO"></see> class.
     * @param numberOfPassengers the number of passengers to board the ship.
     * @param cargo the information of cargo to be shipped.
     * @param weightInKilogramsToTwoDecimalPlaces the wight of cargo in kilograms including the passengers. Must be to 2 decimal places
     */
    public BookingInformationDAO(int numberOfPassengers, String cargo, double weightInKilogramsToTwoDecimalPlaces)
    {
        this.cargo = cargo;
        this.numberOfPassengers = numberOfPassengers;
        this.weightInKiloGrams = weightInKilogramsToTwoDecimalPlaces;
    }
}
