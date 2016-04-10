package main.java;

/**
 * Created by tolgacaner on 06/04/16.
 */
public class Administrator extends Member {
    public Administrator(String fname, String lname, String pword) {
        super(fname,lname,pword);
        onCreate();
    }

    private Integer rank;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
