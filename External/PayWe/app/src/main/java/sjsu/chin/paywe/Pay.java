package sjsu.chin.paywe;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Cann on 11/29/2015.
 */
public class Pay {
    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }
S
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }


    private String mTitle;
    private UUID mId;

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    private Date mDate;
    private boolean mSolved;

    public Pay() {
       mId = UUID.randomUUID();
        mDate = new Date();
    }
}
