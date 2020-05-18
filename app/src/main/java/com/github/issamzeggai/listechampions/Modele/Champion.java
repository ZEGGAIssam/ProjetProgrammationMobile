package com.github.issamzeggai.listechampions.Modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Champion  implements Serializable {
    private String name;
    private String description;
    private String icon;
    private String title;
    private Stats stats;

    public ArrayList<String> getTags() {
        return tags;
    }

    private ArrayList<String> tags;

    public String getTitle() {
        return title;
    }

    public Stats getStats() {
        return stats;
    }
    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
