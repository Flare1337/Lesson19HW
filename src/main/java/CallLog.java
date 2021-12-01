import java.io.Serializable;

import java.util.Objects;

public class CallLog implements Serializable, Comparable<CallLog>{
    private int date;
    private String phoneNumber;
    private boolean isSuccessfulCall;

    public CallLog(int date, String phoneNumber, boolean isSuccessfulCall) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.isSuccessfulCall = isSuccessfulCall;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSuccessfulCall() {
        return isSuccessfulCall;
    }

    public void setSuccessfulCall(boolean successfulCall) {
        isSuccessfulCall = successfulCall;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CallLog callLog = (CallLog) obj;
        return phoneNumber.equals(callLog.phoneNumber) &&
                isSuccessfulCall == callLog.isSuccessfulCall &&
                date == callLog.getDate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, phoneNumber);
    }

    @Override
    public int compareTo(CallLog o) {
        return Integer.max(Integer.parseInt(this.getPhoneNumber()), Integer.parseInt(o.getPhoneNumber()));
    }

    @Override
    public String toString() {
        return "CallLog " +
                "date: " + date +
                ", phoneNumber: " + phoneNumber +
                ", isSuccessfulCall: " + isSuccessfulCall;
    }
}
