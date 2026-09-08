public class Time implements Comparable<Time>
{
    private byte hour;
    private byte minute;
    private byte second;


    /*
    * Class constructor.
     *
    * Must initialize the hour, minute, and second fields.
     *
    * Use the setter methods to assign the values, taking advantage of
    * the validation in those methods.
     *
    * If any received value is invalid, an exception must be thrown.
     */
    
    private void validate_hour(byte hour){
        if(hour < 0 || hour > 23){
            throw new IllegalArgumentException("Invalid Hour input");
        }
    }
    private void validate_minute(byte minute){
        if(minute < 0 || minute > 59){
            throw new IllegalArgumentException("Invalid Minute input")
        }
    }
    private void validate_second(byte second){
        if(second < 0 || second > 59){
            throw new IllegalArgumentException("Invalid Second Input")
        }
    }
    public Time(byte hour, byte minute, byte second) throws Exception
    {
        validate_hour(hour);
        validate_minute(minute);
        validate_second(second);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }


    /*
    * Changes the object's hour.
     *
    * The hour must be between 0 and 23.
     *
    * If the received value is invalid, throw an exception with an
    * appropriate message.
     */
    public void setHour(byte hour) throws Exception
    {
        validate_hour(hour);
        this.hour = hour;
    }


    /*
    * Changes the object's minutes.
     *
    * The value must be between 0 and 59.
     *
    * If the received value is invalid, throw an exception with an
    * appropriate message.
     */
    public void setMinute(byte minute) throws Exception
    {
       validate_minute(minute);
       this.minute = minute;
    }


    /*
    * Changes the object's seconds.
     *
    * The value must be between 0 and 59.
     *
    * If the received value is invalid, throw an exception with an
    * appropriate message.
     */
    public void setSecond(byte second) throws Exception
    {
        validate_second(second);
        this.second = second;
    }


    /*
    * Returns the hour stored in the object.
     */
    public byte getHour()
    {
        return hour;
    }


    /*
    * Returns the minutes stored in the object.
     */
    public byte getMinute()
    {
        return minute;
    }


    /*
    * Returns the seconds stored in the object.
     */
    public byte getSecond()
    {
        return second;
    }


    /*
    * Advances the current time by a specified number of seconds.
     *
    * The received amount must be greater than zero.
    * Otherwise, throw an exception.
     *
    * The method must account for changes in minutes, hours, and days.
     *
    * Examples:
     *
    * 10:20:30 + 40 seconds = 10:21:10
     *
    * 23:59:50 + 20 seconds = 00:00:10
     *
    * The resulting time must always remain within one day,
    * that is, between 00:00:00 and 23:59:59.
     */
    public void advance(int seconds) throws Exception
    {
        // TO IMPLEMENT
    }


    /*
    * Moves the current time back by a specified number of seconds.
     *
    * The received amount must be greater than zero.
    * Otherwise, throw an exception.
     *
    * The method must correctly account for changes in minutes, hours,
    * and days.
     *
    * Examples:
     *
    * 10:20:30 - 40 seconds = 10:19:50
     *
    * 00:00:10 - 20 seconds = 23:59:50
     *
    * The resulting time must always remain within one day,
    * that is, between 00:00:00 and 23:59:59.
     */
    public void goBack(int seconds) throws Exception
    {
        // TO IMPLEMENT
    }


    /*
    * Returns a NEW Time object representing a future time.
     *
    * The new time must correspond to the current time plus the
    * specified number of seconds.
     *
    * IMPORTANT:
    * This method must NOT change the current object (this).
     *
    * Use the copy constructor to create the new object.
     *
    * Example:
     *
    * Time t1 = new Time((byte)10, (byte)20, (byte)30);
    * Time t2 = t1.getFutureTime(60);
     *
    * t1 remains 10:20:30
    * t2 will be 10:21:30
     */
    public Time getFutureTime(int seconds) throws Exception
    {
        // TO IMPLEMENT
    }


    /*
    * Returns a NEW Time object representing a past time.
     *
    * The new time must correspond to the current time minus the
    * specified number of seconds.
     *
    * IMPORTANT:
    * This method must NOT change the current object (this).
     *
    * Use the copy constructor to create the new object.
     */
    public Time getPastTime(int seconds) throws Exception
    {
        // TO IMPLEMENT
    }


    /*
    * Returns a textual representation of the time.
     *
    * The format must be:
     *
     * HH:MM:SS
     *
    * Always use two digits for the hour, minute, and second.
     *
    * Examples:
     *
     * 08:05:03
     * 14:30:45
     * 00:00:00
     */
    @Override
    public String toString()
    {
        // TO IMPLEMENT
    }


    /*
    * Compares this object with another object.
     *
    * The method must return true only when the received object is also
    * a Time object with exactly the same hour, minute, and second.
     *
    * Consider the following cases:
     *
    * - comparing the object with itself;
    * - received object equal to null;
    * - object from a different class;
    * - Time objects with different values;
    * - Time objects with the same values.
     */
    @Override
    public boolean equals(Object obj)
    {
        // TO IMPLEMENT
    }


    /*
    * Returns the object's hash code.
     *
    * The calculation must consider the three fields:
     *
    * - hour;
    * - minute;
    * - second.
     *
    * ATTENTION:
    * Objects considered equal by equals() must produce the same
    * hashCode().
     */
    @Override
    public int hashCode()
    {
        // TO IMPLEMENT
    }


    /*
    * COPY CONSTRUCTOR.
     *
    * Must create a new Time using another Time object as its model.
     *
    * Example:
     *
    * Time t1 = new Time((byte)10, (byte)30, (byte)20);
    * Time t2 = new Time(t1);
     *
    * t1 and t2 must have the same values, but must be different objects
    * in memory.
     *
    * If the received model is null, throw an exception.
     *
    * Also consider whether this class's fields require a deep copy
    * or whether a direct copy of the values is sufficient.
     */
    public Time(Time model) throws Exception
    {
        // TO IMPLEMENT
    }


    /*
    * Compares two times chronologically.
     *
    * This method will be used to allow ordering of Time objects
    * Time objects using features such as Arrays.sort().
     *
    * The comparison must consider, IN THIS ORDER:
     *
    * 1st - hour
    * 2nd - minute
    * 3rd - second
     *
    * That is:
     *
    * First compare the hours.
     *
    * If the hours differ, it is already possible to determine which
    * time comes first.
     *
    * If the hours are equal, compare the minutes.
     *
    * If the minutes are also equal, compare the seconds.
     *
    * The method must return:
     *
    * value < 0  -> if this comes before time;
    * value > 0  -> if this comes after time;
    * 0          -> if the times are equal.
     *
    * Examples:
     *
     * 08:30:20 < 09:10:15
     *
     * 08:30:20 < 08:40:10
     *
     * 08:30:20 < 08:30:40
     *
     * 08:30:20 == 08:30:20
     */
    @Override
    public int compareTo(Time time)
    {
        // TO IMPLEMENT
    }
}