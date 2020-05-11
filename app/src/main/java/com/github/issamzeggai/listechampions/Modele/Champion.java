package com.github.issamzeggai.listechampions.Modele;
import java.io.Serializable;

import java.util.List;
public class Champion  implements Serializable {
    private String name;
    private String description;
    private String icon;
    private String title;

    public String getTitle() {
        return title;
    }
    private Stats stats;

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