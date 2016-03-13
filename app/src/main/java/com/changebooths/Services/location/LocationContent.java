package com.changebooths.Services.location;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.changebooths.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class LocationContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<LocationItem> ITEMS = new ArrayList<LocationItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, LocationItem> ITEM_MAP = new HashMap<String, LocationItem>();

    private static final int COUNT = 4;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(LocationItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static LocationItem createDummyItem(int position) {
        switch (position) {
            case 1:
                return new LocationItem(String.valueOf(position), new LatLng(27.700597, 85.278239), "Water", R.drawable.map_water_blue);
            case 2:
                return new LocationItem(String.valueOf(position), new LatLng(27.714579, 85.311288), "Food", R.drawable.map_food_blue);
            case 3:
                return new LocationItem(String.valueOf(position), new LatLng(27.711249, 85.319307), "Healthcare", R.drawable.map_health_blue);
            case 4:
                return new LocationItem(String.valueOf(position), new LatLng(27.713394, 85.320616), "Job Training", R.drawable.map_job_blue);
        }
        return new LocationItem("", new LatLng(27.713394, 85.320616), "", R.drawable.map_water_blue);
    }

    public static class LocationItem {
        public final String id;
        public final LatLng latLng;
        public final String name;
        public final int serviceDrawable;
        //public final String

        public LocationItem(String id, LatLng latLng, String name, int serviceDrawable) {
            this.id = id;
            this.latLng = latLng;
            this.name = name;
            this.serviceDrawable = serviceDrawable;
        }

    }

}
