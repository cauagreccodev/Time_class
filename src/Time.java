import java.util.Objects;

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
            throw new IllegalArgumentException("Invalid Minute input");
        }
    }
    private void validate_second(byte second){
        if(second < 0 || second > 59){
            throw new IllegalArgumentException("Invalid Second Input");
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
    public Time(Time other) throws Exception
    {
        if(other == null){
            throw new IllegalArgumentException("Time model cannot be null");
        }
        this.hour = other.hour;
        this.minute = other.minute;
        this.second = other.second;
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
        return hour; //converts all the minutes in hours
    }


    /*
    * Returns the minutes stored in the object.
     */
    public byte getMinute()
    {
        return minute;  // converts all the seconds in minutes
    }


    /*
    * Returns the seconds stored in the object.
     */
    public byte getSecond()
    {
        return second; // get the remainder of the minutes calculated after extract the minutes
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
        if(seconds < 0){
            throw new IllegalArgumentException("Invalid advance() input");
        }
        int total = (this.hour * 3600) + (this.minute * 60) + this.second;
        total = (total + seconds) % 86400;

        this.hour = (byte) (total / 3600);
        this.minute = (byte) ((total % 3600) / 60);
        this.second = (byte) (total % 60);
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
        if(seconds < 0){
            throw new IllegalArgumentException("Invalid goBack() input");
        }
        int total = (this.hour * 3600) + (this.minute * 60) + this.second;
        total = (total - (seconds % 86400) + 86400) % 86400;

        this.hour = (byte) (total / 3600);
        this.minute = (byte) ((total % 3600) / 60);
        this.second = (byte) (total % 60);
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
        if(seconds < 0){
            throw new IllegalArgumentException("Invalid getFutureTime() input");
        }
        Time t2 = new Time(this); 
        t2.advance(seconds);
        return t2;
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
        if(seconds < 0){
            throw new IllegalArgumentException("Invalid getPastTime() input");
        }
        Time t2 = new Time(this);
        t2.goBack(seconds);
        return t2;
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
        return String.format("Time: %02d:%02d:%02d", + getHour(), getMinute(), getSecond());
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
        if(obj == this){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) return false;
        Time other = (Time) obj;
        return this.hour == other.hour && this.minute == other.minute && this.second == other.second;
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
        return Objects.hash(hour, minute, second);
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
    public int compareTo(Time other)
    {   
        int result = Byte.compare(this.hour, other.hour);
        if(result != 0) return result;

        result = Byte.compare(this.minute, other.minute);
        if(result != 0) return result;

        return Integer.compare(this.second, other.second);
    }
}