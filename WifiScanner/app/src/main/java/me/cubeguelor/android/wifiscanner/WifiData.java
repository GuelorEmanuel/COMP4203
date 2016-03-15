package me.cubeguelor.android.wifiscanner;


import android.net.wifi.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Guelor on 16-03-14.
 */
public class WifiData implements Parcelable {
    private List<WifiDataNetwork> mNetworks;


    public WifiData() { mNetworks = new ArrayList<>();}
    public WifiData(Parcel in) { in.readTypedList(mNetworks, WifiDataNetwork.CREATOR);}


    public static final Parcelable.Creator<WifiData> CREATOR
            = new Parcelable.Creator<WifiData>() {
        public WifiData createFromParcel(Parcel in) {
            return new WifiData(in);
        }

        public WifiData[] newArray(int size) {
            return new WifiData[size];
        }
    };

    /**
     * Stores the last WiFi scan performed by {@link
     * WifiManager.getScanResults()} creating a {@link WifiDataNetwork()} object
     * for each network detected.
     *
     * @param results
     *            list of networks detected
     */
    public void addNetworks(List<ScanResult> results) {
        mNetworks.clear();
        for (ScanResult result : results) {
            mNetworks.add(new WifiDataNetwork(result));
        }
        Collections.sort(mNetworks);
    }

    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mNetworks);
    }

    /**
     * @return Returns a string containing a concise, human-readable description
     *         of this object.
     */
    @Override
    public String toString() {
        if (mNetworks == null || mNetworks.size() == 0) {
            System.out.println("NET: "+ mNetworks);
            return "Empty data";
        }
        else {

            System.out.println("NET: "+ mNetworks);
            return mNetworks.size() + " networks data";
        }
    }

    /**
     * @return Returns the list of scanned networks
     */
    public List<WifiDataNetwork> getNetworks() {
        return mNetworks;
    }
}



